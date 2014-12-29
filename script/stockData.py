#! /usr/bin/py
# -*- coding: utf-8 -*-

import os
import sys
import pickle
import numpy as nu

from stockCommon import *

sz_code = "sz399001"
sh_code = "sh000001"

class StockRawData():
    def __init__(self, inputFilename):
        self.__inputFilename = inputFilename
        self.__dict = {}
        self.__cateDict = {}


    def merge(self, outFilename, cateFilename):
        for line in open(self.__inputFilename):
            line = ''.join(line.split(','))
            if len(line) < 4:
                continue
            fields = line[:-1].split('\t')
            self.readData(fields)
        self.__saveRawRecords(outFilename, cateFilename)

    
    def readData(self, fields):
        cate = fields[1]
        if cate == "cate":
            self.__readCategory(fields)
        else:
            self.__readRawData(fields)


    def __readRawData(self, fields):
        if len(fields) < 3:
            return
        code, cate, date = fields[:3]
        key = code + cate + date
        value = fields
        self.__dict[key] = value


    def __readCategory(self, fields):
        cateCode = fields[0]
        cate = fields[1]
        if cate != 'cate':
            return
        for code in fields[2:]:
            categories = self.__cateDict.get(code, [])
            categories.append(cateCode)
            self.__cateDict[cateCode] = categories


    def __saveRawRecords(self, outFilename, cateFileName):
        recordList = []
        for (k, fields) in self.__dict.items():
            [code, cate, date] = fields[:3]
            if cate != 'ifeng':
                continue
            ifeng_records = fields
            fund_records = self.__dict.get(code + "fund" + date, None)
            hd_records = self.__dict.get(code + "hd" + date, None)
            sz_records = self.__dict.get(sh_code + "ifeng" + date, None)
            if "sz" in code:
                sz_records = self.__dict.get(sz_code + "ifeng" + date, None)
            if code == sh_code or code == sz_code:
                continue
            if ifeng_records is None or fund_records is None or hd_records is None or sz_records is None\
                    or len(ifeng_records) < 17 or len(fund_records) < 18 or len(hd_records) < 18 :
                sys.stderr.write('lack records[' + ','.join([code, date]) + ']\n')
                continue
            out_records = [
                    code,
                    date,
                    fund_records[3],
                    ifeng_records[10],
                    ifeng_records[11],
                    ifeng_records[12],
                    ifeng_records[7],
                    ifeng_records[13],
                    ifeng_records[14],
                    ifeng_records[15],
                    ifeng_records[9],
                    ifeng_records[16],
                    fund_records[8],
                    fund_records[9],
                    hd_records[9],
                    sz_records[5]
                ]
            line = "\t".join(out_records)
            recordList.append(line)

        fout = open(outFilename, "w")
        for line in sorted(recordList, reverse = True):
            fout.write(line + '\n')
        fout.close()

        fout = open(cateFileName, 'wb')
        pickle.dump(self.__cateDict, fout)
        fout.close()

class StockPickleData():
    @classmethod
    def saveAsPickle(cls, in_filename, out_filename):
        prev_code = None
        record_list = []
        record_dict = {}
        for line in open(in_filename):
            fields = line.split('\t')
            code = fields[0]
            if code != prev_code and prev_code is not None:
                # save dict and clear list
                record_dict[prev_code] = record_list
                record_list = []
            record_list.append(fields)
            prev_code = code
        record_dict[prev_code] = record_list
        fout = open(out_filename, 'wb')
        pickle.dump(record_dict, fout)
        fout.close()
        

class StockRecordsData():
    __fieldMap = {
            'ma' : 0,
            'ma5' : 1,
            'ma10' : 2,
            'ma20' : 3,
            'exchange' : 4,
            'exchange5' : 5,
            'exchange10' : 6,
            'exchange20' : 7,
            'ma_gradient' : 8,
            'hsl' : 9,
            'ltsz' : 10,
            'zjlr' : 11,
            'ydjl' : 12,
            'szdata' : 13,
            }

    def __init__(self,
            recordFilename,
            cateFilename,
            featureWindow,
            labelWindow,
            thres_up,
            thres_down):
        self.__recordFilename = recordFilename
        self.__cateDict = pickle.load(open(cateFilename, 'rb'))
        self.__featureWindow = featureWindow
        self.__labelWindow = labelWindow
        self.__thresUp = thres_up
        self.__thresDown = thres_down
        self.__raw_records_dict = {}


    def generateFeatures(self, feat_processors):
        prev_code = None


        records = []
        dates = []
        record_dict = pickle.load(open(self.__recordFilename, 'rb'))
        for code in record_dict.keys():
            fields = record_dict[code]
            records = [record[2:] for record in fields]
            dates = [record[1] for record in fields]
            cateInfo = self.__cateDict.get(code, [])
            for feat_processor in feat_processors:
                self.processRecordsBycode(
                        code,
                        records,
                        dates,
                        cateInfo,
                        feat_processor)


    # input     : complete input records of one code
    #   write features of train & test into files
    def processRecordsBycode(self, code, records, dates, categories, feat_processor):
        float_records = [ [float(el) for el in ele] for ele in records ]
        nu_records = nu.asarray(float_records)
        train_stuff = self.genTrainFeatures(nu_records, dates, feat_processor)
        test_stuff = self.genTestFeatures(nu_records, feat_processor)
        for item in train_stuff:
            if item is None:
                continue
            date, label, features = item
            if len(features) == 0:
                continue
            feat_processor.trainfile.write(("%s\t%s\t%f\t%s\n") % (code, date, float(label), '\t'.join(features)))
        
        if test_stuff and len(test_stuff) > 0:
            feat_processor.testfile.write(("%s\t%s\t%f\t%s\n") % (code, dates[0], 0, '\t'.join(test_stuff)))


    def genTrainFeatures(self, records, dates, feat_processor):
        res_list = []
        for label_beg in range(len(records)):
            label_end = label_beg + self.__labelWindow
            feat_end = label_end + self.__featureWindow
            if feat_end > len(records):
                break
            date = dates[label_end]
            label = 0.0
            label_idx = self.__fieldMap['ma']
            label = _Grandient(records[:, label_idx], label_beg, label_end, 1, 1)
            if label < self.__thresUp and label > self.__thresDown:
                res_list.append(None)
                continue
            #feature_list = feat_processor(records[label_end:feat_end])
            feature_list = feat_processor.extract_window_feature(records[label_end:feat_end])
            res_list.append([date, label, feature_list])
        return res_list


    def genTestFeatures(self, records, feat_processor):
        if len(records) < self.__featureWindow:
            return None
        #return feat_processor(records[:self.__featureWindow])
        return feat_processor.extract_window_feature(records[:self.__featureWindow])


    # wdProcessBLABLA: must return a list of feature
    #       feature format: "%s:%f" % (name, value)
    def wdProcessRawFeature(self, windowRecods):
        feature_list = []
        tmp_feat_list = []
        sample_rates = [3, 5, 10, 20, 30]
        compare_windows = [1, 3, 5, 10, 20, 30, 60]
        gradient_field_list = ['ma', 'exchange']#, 'ltsz', 'zjlr', 'ydjl', 'szdata',]
        pos_field_list = []#'zjlr', 'ydjl', ]

        for field in gradient_field_list:
            idx = self.__fieldMap[field]
            records = windowRecods[:, idx]
            for sample_rate in sample_rates:
                tmp_feat_list.extend(_GradientsBySample(records, sample_rate) *  sample_rate)
            tmp_feat_list.extend(_GradientsByList(records, compare_windows, 60, 3) * 10)
        feature_list.extend(_TransFeatFromFloats('grad', tmp_feat_list))
        
        tmp_feat_list = []
        for field in pos_field_list:
            idx = self.__fieldMap[field]
            records = windowRecods[:, idx]
            tmp_feat_list.append(_Pos(records, 3))
            tmp_feat_list.append(_Pos(records, 5))
            tmp_feat_list.append(_Pos(records, 10))
            tmp_feat_list.append(_ConinousPotiveCount(records))

        feature_list.extend(_TransFeatFromFloats('cnt', tmp_feat_list))

        return feature_list


    # proces records of feature window, for LR training use
    def wdProcessForLr(self, windowRecords):
        feature_list = []#self.genSimpleFeature(windowRecords)
        feature_list.extend(self.genWindowFeature(windowRecords))
        return [ "%s:%f" % (k, v) for [k,v] in feature_list]


    # input     : records of feature window
    # gen simple feature from records of feature window, element format: sfea_ma:2.34
    def genSimpleFeature(self, records):
        field_list = ['ma', 'ma10', 'exchange',]
        ret_features = []
        for key in field_list:
            idx = self.__fieldMap.get(key, None)
            if idx is None:
                sys.stderr.write( "key not foumd:" + key + '\n')
                continue
            feature = ["sfea_" + key, float(records[0][idx])]
            ret_features.append(feature)
        return ret_features


    def genWindowFeature(self, records):
        res_features = []
        res_features.extend(self.__getMaFeatures(records[:, self.__fieldMap['ma']]))
        res_features.extend(self.__getExchangeFeatures(records[:, self.__fieldMap['exchange']]))
        res_features.extend(self.__getLtszFeatures(records[:, self.__fieldMap['ltsz']]))
        res_features.extend(self.__getZjlrFeatures(records[:, self.__fieldMap['zjlr']]))
        res_features.extend(self.__getYdjlFeatures(records[:, self.__fieldMap['ydjl']]))
        res_features.extend(self.__getSzdataFeatures(records[:, self.__fieldMap['szdata']]))
        return res_features

    
    def __getMaFeatures(self, records):
        return [
            ["maContinousInc", _ContinousInc(records, [5, 10, 20, 30, 60], 0)],
            ["maContinousIncExtend", _ContinousInc(records, [60, 100], 0)],
            ["maCmp_1_5", cmp(_Mean(records, 0, 1), _Mean(records, 0, 5))],
            ["maCmp_0_50_N30", cmp(_Grandient(records, 0, 50, 1, 1), 0.3)],
            ["maCmp_0_100_N50", cmp(_Grandient(records, 0, 99, 1, 1), 0.5)],
            ["maCmpMean_0_5_Mean_5_5", cmp(_Mean(records, 0, 5), _Mean(records, 5, 5))],
            ["maCmpMean_0_10_Mean_10_10", cmp(_Mean(records, 0, 10), _Mean(records, 10, 10))],
            ["maCmpGrad_3_10_N3", cmp(_Grandient(records, 0, 10, 3, 3), 0.03)],
            ["maCmpGrad_5_20_N5", cmp(_Grandient(records, 0, 20, 5, 5), 0.05)],
            ["maCmpGrad_5_40_N10", cmp(_Grandient(records, 0, 40, 5, 5), 0.1)],
            ["maCmpGrad_5_40_N15", cmp(_Grandient(records, 0, 40, 5, 5), 0.15)],
            ["maCmpGrad_5_60_N15", cmp(_Grandient(records, 0, 60, 5, 5), 0.15)],
            ["maCmpGrad_5_60_N30", cmp(_Grandient(records, 0, 60, 5, 5), 0.3)],
            ["maGrad_0_40_5", _Grandient(records, 0, 40, 5, 5)],
            ["maGrad_0_60_5", _Grandient(records, 0, 60, 5, 5)],
            ["maGrad_0_100_5", _Grandient(records, 0, 100, 5, 5)],
            ["maGrad_0_240_5_5", _Grandient(records, 0, 240, 5, 5)],

            # important
            ['maLastShangShen', _HoriCmp(records, [[5,20], [10,20], [20,30], [30,60]], 0)],
            ['maCountShangShen', _CountHoriCmp(records, [[5,20], [10,20], [20,30], [30,60]], 60)],
            ['maVehiShangShen5', _VehiCmp(records, 60, 5)],
            ['maVehiShangShen10', _VehiCmp(records, 60, 10)],
            ['maVehiShangShen20', _VehiCmp(records, 60, 20)],
            ['maVehiShangShen30', _VehiCmp(records, 60, 30)],
            #['maGradientUpperTheshod10', cmp(_Grandient(records, 0, 0, 1, 10), 0.1)],
            #['maGradientLowerTheshod10', cmp(_Grandient(records, 0, 0, 1, 10), -0.1)],
            #['maGradientUpperTheshod60', cmp(_Grandient(records, 0, 0, 1, 10), 0.2)],
            #['maGradientLowerTheshod60', cmp(_Grandient(records, 0, 0, 1, 10), -0.1)],
        ]


    def __getExchangeFeatures(self, records):
        # 1. cmp(Grandient(0, 10, 10, 10), 0)
        # 2. cmp(Grandient(0, 20, 20, 20), 1)
        # 3. cmp(Grandient(0, 30, 30, 30), 0)
        return [
            ["exCmp0_1_0_3", cmp(_Grandient(records, 0, 0, 1, 3), 0)],
            ["exCmp0_1_0_5", cmp(_Grandient(records, 0, 0, 1, 5), 0)],
            ["exCmp0_1_0_10", cmp(_Grandient(records, 0, 0, 1, 10), 0)],
            ["exCmp0_3_3_3", cmp(_Grandient(records, 0, 3, 3, 3), 0)],
            ["exCmp0_5_5_5", cmp(_Grandient(records, 0, 5, 5, 5), 0)],
            ["exCmp0_10_10_10", cmp(_Grandient(records, 0, 10, 10, 10), 0)],
            ["exCmp0_20_20_20", cmp(_Grandient(records, 0, 20, 20, 20), 0)],
            ["exCmp0_30_30_30", cmp(_Grandient(records, 0, 30, 30, 30), 0)],
            ["exCmp0_5_5_5_C1", cmp(_Grandient(records, 0, 10, 5, 5), 1)],
            ["exCmp0_10_10_10_C1", cmp(_Grandient(records, 0, 10, 10, 10), 1)],
            ["exCmp0_20_20_20_C1", cmp(_Grandient(records, 0, 20, 20, 20), 1)],
            ["exCmp0_30_30_30_C1", cmp(_Grandient(records, 0, 30, 30, 30), 1)],
            ["exGrad0_100_100_C0", _Grandient(records, 0, 100, 100, 100)],
            ["exGrad_0_90_90", _Grandient(records, 0, 90, 90, 90)],
        ]


    def __getLtszFeatures(self, records):
        # pos(3), pos(5)
        return [
            ["ltszPos3", _Pos(records, 3)],
            ["ltszPos5", _Pos(records, 5)],
        ]


    def __getZjlrFeatures(self, records):
        # pos(3), pos(5)
        return [
            ["zjlrPos3", _Pos(records, 3)],
            ["zjlrPos5", _Pos(records, 5)],
        ]


    def __getYdjlFeatures(self, records):
        # pos(3), pos(5)
        return [
            ["zjlrPos3", _Pos(records, 3)],
            ["zjlrPos5", _Pos(records, 5)],
        ]


    def __getSzdataFeatures(self, records):
        # Grandient(0, 0, 1, 3)
        # Grandient(0, 0, 3, 5)
        # Grandient(0, 0, 5, 10)
        return [
            ["szDataDel_1_3", _Grandient(records, 0, 0, 1, 3)],
            ["szDataDel_1_5", _Grandient(records, 0, 0, 1, 5)],
            ["szDataDel_1_10", _Grandient(records, 0, 0, 1, 10)],
            ["szDataDel_3_5", _Grandient(records, 0, 0, 3, 5)],
            ["szDataDel_5_10", _Grandient(records, 0, 0, 5, 10)],
        ]


    # value :[name, value]
    def __genFeat(self, prefix, idx, value):
        k, v = value
        feature = prefix + '_' + str(idx) + '_' + k + ':' + str(v)
        return feature



class FeatureData():
    def __init__(self, devNum):
        self.__featNameDict = {}
        self.__featId = 1
        self.__records = []
        self.__devNum = devNum
        self.__beg = 2


    def __getFeatIdx(self, feature):
        feat_idx = self.__featNameDict.get(feature, None)
        if feat_idx is None:
            feat_idx = self.__featId
            self.__featId += 1
            self.__featNameDict[feature] = feat_idx
        return feat_idx


    def processTrainData(self, inFilename, outFilename):
        self.__records = []
        for line in open(inFilename):
            self.__loadLine_v1(line)

        # generate static results
        self.__processTrainRecords_v1()
        self.__generateTrainFeature_v1(outFilename)

        

    def processTestData(self, inFilename, outFilename):
        fout = open(outFilename, 'w')
        for line in open(inFilename):
            fields = line[:-1].split('\t')
            records = [float(fields[self.__beg]),]
            records.extend( [float(ele.split(':')[1]) for ele in fields[self.__beg + 1:]] )
            features = self.__genFeature_v1(records)
            fout.write('\t'.join(features) + '\n')
        fout.close()

    def __processTrainRecords_v1(self):
        nu_array = nu.asarray(self.__records)
        self.__min = nu.min(nu_array, axis = 0)
        self.__max = nu.max(nu_array, axis = 0)


    def __generateTrainFeature_v1(self, outFilename):
        fout = open(outFilename, 'w')
        # process records and save
        for fields in self.__records:
            item_list = self.__genFeature_v1(fields)
            fout.write('\t'.join(item_list) + '\n')
        fout.close()

    
    def __loadLine_v1(self, line):
        fields = line[:-1].split('\t')
        records = [float(fields[self.__beg])]
        records.extend([float(field.split(':')[1]) for field in fields[self.__beg + 1:]])
        self.__records.append(records)


    def __genFeature_v1(self, records):
        item_list = []
        label = records[0]
        label_str = '-1'
        if label > 0:
            label_str = '1'
        for idx in range(1, len(records)):
            span = (float(self.__max[idx]) - float(self.__min[idx])) / 100
            span += 0.00000001
            res = int( (records[idx] - float(self.__min[idx])) / span )
            desc = "%d:%d" % (idx, res)
            item_list.append(desc)
        res_records = [label_str,]
        res_records.extend( [ str(item)+":1" for item in self.__genIdFea(item_list)] )

        return res_records

    def __genIdFea(self, records):
        feaList = []
        for record in records:
            feaList.append(self.__getFeatIdx(record))
        return sorted(feaList)



