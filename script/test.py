from stockExplainData import ExplainableFeatureExtractor
one_obj = ExplainableFeatureExtractor("test")
for k,v in one_obj.getExtraFeat('a'*100).items():
    print k + "\t" + str(v)
