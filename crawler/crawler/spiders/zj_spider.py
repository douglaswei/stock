#!/usr/bin/python
#coding=utf-8

from scrapy.contrib.spiders import CrawlSpider, Rule
from scrapy.contrib.linkextractors.sgml import SgmlLinkExtractor
from scrapy.selector import Selector

from crawler.dawn import Dawn
from crawler.items import Parts
from crawler.items import PartSymptomsItem
from crawler.items import SymptomsDiseaseItem


#from crawler.items import JbkItem

class ZjSpider(CrawlSpider):
    #name DIY
    name = "zj"
    allowed_domains = ["39.net",]
    start_urls = [
        "http://jbk.39.net/zicha", 
    ]
    rules = (
        Rule(SgmlLinkExtractor(allow=(r'http://jbk.39.net/zicha/*')), follow = True, callback="parse_item"), 
    )

    def parse_item(self, response):
        hxs = Selector(response)

    	#部位集合的路径
        parts_list_xpath = hxs.xpath('//section[contains(@id, "s2")]//div[contains(@class, "myBox2_22")]//div[contains(@class, "symCon")]/ul[contains(@id, "symList")]/li')

    	#年龄集合的路径    	
        age_list_xpath = hxs.xpath('//section[contains(@id, "s1")]//div[contains(@class, "myTab myTab1")]//div[contains(@id, "s1_age")]/a')

        if not age_list_xpath or not parts_list_xpath:
        	return

        sex_list = [u'男', u'女']
        age_list = []
        parts_list = []

        for age_xpath in age_list_xpath:
    		age = age_xpath.xpath('./@v').extract()
    		age_list.append(age)
    	
    	for parts_xpath in parts_list_xpath:
    		parts = parts_xpath.xpath('./a/text()').extract()
    		parts_list.append(parts)


        #导出关系的item集合
        parts_item_list = []
        #所有二级部位集合，为了方便后续循环部位取症状
        all_parts_list = []
        #简历一级部位与二级部位的关系，为了方便后续二级部位循环取不到症状，转用一级部位取
        dict_parts = {}
        for parts in parts_list:
    	    father_part = parts[0]
    	    parts = parts[0].encode('gbk')
    	    dawn = Dawn()
    	    data = {'act' : 'subbody',
                    'q' : parts}
          	
          	#循环一级部位，模拟浏览器发送请求，获取返回的二级部位（json数据）
    	    result = dawn.request('http://jbk.39.net/SelfDiagnosis/DiagnosisHandler.ashx', data)
    	    if result is not None and result != 'null':
    		    parts_item = Parts()
    		    parts_item['father_part'] = father_part
    		    parts_item['child_part'] = result
    		    parts_item_list.append(parts_item)

    		    #获取二级部位的集合
    		    result_list = []
    		    result_list = result[1 : -1].split(',')
    		    for str_temp in result_list:
    		    	dict_parts[str_temp.strip('"').decode('utf-8')] = father_part

    		    all_parts_list.extend(result_list)
    		    
    	#symptoms_list = []
        #存储症状id的集合
        symptoms_id_list = []
    	part_symptoms_list = []
        #症状名称和id关系
        symptoms_relation = {}
    	for single_part in all_parts_list:
    	    for single_age in age_list:
    		    for single_sex in sex_list:
    			    dawn_result = Dawn()
    			    single_part_gbk = single_part.strip('"').decode('utf-8').encode('gbk')
    			    single_part_str = single_part.strip('"')
    			    single_age_utf8 = single_age[0].encode('utf-8')
    			    single_sex_gbk = single_sex.encode('gbk')
    			    single_sex_utf8 = single_sex.encode('utf-8')

    			    #通过二级部位、性别、年龄、职业（默认为所有）获取返回的症状，如果获取的结果为null，则用一级部位重新获取
    	    	    param_result = {'act' : 'allsym',
    	    	    			'q' : single_part_gbk,
    	    	    			'jid' : 13, 
    	    	    			'age' : single_age_utf8,
    	    	    			'sex' : single_sex_gbk}

    	    	    result_zz = dawn_result.request('http://jbk.39.net/SelfDiagnosis/DiagnosisHandler.ashx', param_result)

                    #二级部位请求不到症状的数据，改用一级部位重新请求一次
    	    	    if result_zz is not None and result_zz != 'None':
    	    	    	if result_zz == '[]':
	    	    	    	param_result = {'act' : 'allsym',
	    	    	    			'q' : dict_parts[single_part_str.decode('utf-8')].encode('gbk'),
	    	    	    			'jid' : 13, 
	    	    	    			'age' : single_age_utf8,
	    	    	    			'sex' : single_sex_gbk}
	    	    	    	result_zz = dawn_result.request('http://jbk.39.net/SelfDiagnosis/DiagnosisHandler.ashx', param_result)

    	    	        part_symptoms = PartSymptomsItem()
                        result_zz_list_full = []
    	    	        result_zz_list = []
    	    	        result_zz_list = result_zz[1 : -1].split('},')
                        for result_zz_temp in result_zz_list:
                            if not result_zz_temp.endswith('}'):
                                result_zz_list_full.append(result_zz_temp + '}')
                            else:
                                result_zz_list_full.append(result_zz_temp)

    	    	        part_symptoms['part'] = single_part_str
    	    	        part_symptoms['symptoms'] = result_zz_list_full
    	    	        part_symptoms['age'] = single_age_utf8
    	    	        part_symptoms['sex'] = single_sex_utf8
    	    	        #symptoms_list.append(result_zz_list)
    	    	        part_symptoms_list.append(part_symptoms)

                        if result_zz_list_full is not None:
                            for symptom_json in result_zz_list_full:
                                symptom_id = eval(symptom_json)
                                #print symptom_id['Key']
                                symptoms_id_list.append(symptom_id['Key'])
                                symptoms_relation[symptom_id['Key']] = symptom_id['Value']


        symptoms_disease_list = []
        #获取所有症状的ID，通过ID、年龄、和性别发送请求获取可能发生的疾病信息
        if len(symptoms_id_list) > 0:
            for symptoms_id in set(symptoms_id_list):
                if symptoms_id is not None and symptoms_id != 'None':
                    for single_age in age_list:
                        for single_sex in sex_list:
                            get_disease_Dawn = Dawn()
                            single_age_utf8 = single_age[0].encode('utf-8')
                            single_sex_gbk = single_sex.encode('gbk')
                            single_sex_utf8 = single_sex.encode('utf-8')

                            get_disease_param = {'act' : 'result',
                                    'ids' : symptoms_id,
                                    'jid' : 13, 
                                    'age' : single_age_utf8,
                                    'sex' : single_sex_gbk}

                            #print '-------------'
                            #print get_disease_param
                            get_disease_result = get_disease_Dawn.request('http://jbk.39.net/SelfDiagnosis/DiagnosisHandler.ashx', get_disease_param)
                            #print get_disease_result

                            symptomsDisease = SymptomsDiseaseItem()
                            symptomsDisease['symptoms_name'] = symptoms_relation[symptoms_id]
                            symptomsDisease['symptoms_id'] = symptoms_id
                            symptomsDisease['disease_list'] = get_disease_result
                            symptomsDisease['age'] = single_age_utf8
                            symptomsDisease['sex'] = single_sex_utf8
                            symptoms_disease_list.append(symptomsDisease)

    	#返回部位和症状的关系数据为part_symptoms_list，返回一级部位和二级部位关系数据为parts_item_list
        #return set(part_symptoms_list)

        #返回症状和疾病的关系数据
        return set(symptoms_disease_list)
















