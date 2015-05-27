__author__ = 'wgz'


class FeatTranslator:
    def __init__(self):
        self.feat_name_id_map = {}
        pass

    def extract(self, field_map, is_discrete):
        result_map = {}

        for feat_name, feat_value in field_map.items():
            if feat_name == "code" or feat_name == "date" or feat_name == "label":
                continue

            key = is_discrete and feat_name + ':' + str(feat_value) or feat_name
            feat_id = self.feat_name_id_map.get(key, None)
            if feat_id is None:
                feat_id = len(self.feat_name_id_map) + 1
                self.feat_name_id_map[key] = feat_id
            result_map[feat_id] = is_discrete and 1 or feat_value

        return result_map

    def reset(self):
        self.feat_name_id_map.clear()
