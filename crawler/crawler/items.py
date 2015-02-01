# Define here the models for your scraped items
#
# See documentation in:
# http://doc.scrapy.org/en/latest/topics/items.html

from scrapy.item import Item, Field

class DmozItem(Item):
    # define the fields for your item here like:
    title = Field()
    link = Field()
    desc = Field()
    pass

class DoubanItem(Item):
    groupName = Field()
    groupURL = Field()
    totalNumber = Field()
    RelativeGroups = Field()
    ActiveUesrs = Field()

class JbkItem(Item):
    url_string = Field()
    class_name = Field()
    disease_name = Field()
    introduction = Field()
    alias_name = Field()
    location = Field()
    infectious = Field()
    crowd = Field()
    symptom = Field()
    related_disease = Field()
    department = Field()
    cost = Field()
    cure_rate = Field()
    cure_method = Field()
    inspection = Field()
    operation = Field()

class JbkRlationItem(Item):
    name = Field()
    dis_sym = Field()
    relations = Field()

class ZzkItem(Item):
    # define the fields for your item here like:
    # name = Field()
    symptoms_name = Field()
    symptoms_description = Field()
    url = Field()
    disease = Field()

class DiseaseItem(Item):
    disease_name = Field()
    symptoms = Field()
    department = Field()
    disease_url = Field()

class YybItem(Item):
    disease_name = Field()
    department = Field()
    description = Field()
    symptoms_name = Field()
    disease_url = Field()

class Parts(Item):
    father_part = Field()
    child_part = Field()

class PartSymptomsItem(Item):
    part = Field()
    symptoms = Field()
    age = Field()
    sex = Field()

class SymptomsDiseaseItem(Item):
    symptoms_id = Field()
    symptoms_name = Field()
    disease_list = Field()
    age = Field()
    sex = Field()

class StockItem(Item):
    channel = Field()
    code = Field()
    sub_code = Field()
    cate = Field()
    cdate = Field()
    name = Field()
    records = Field()
