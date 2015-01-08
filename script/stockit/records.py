#! /usr/bin/python

class BaseRecord(object):
    def processItems(self, items):
        return None

    def getDefaultRecords(self):
        return None


class fundRecords(BaseRecord):
    def processItems(self, items):
        res = []
        res.extend(items[3:6])
        res.extend(items[8:10])
        return [float(ele) for ele in res]


class hdRecords(BaseRecord):
    def processItems(self, items):
        res = [float(items[9])]
        return res

    def getDefaultRecords(self):
        return [0]

    
