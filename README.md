# stock

stock项目分为以下几个模块：
1. 数据库部分，主要负责数据的定义和存储
2. 数据抓取平台，也就是所谓的爬虫
3. 计算平台，主要负责数据加工，对原始的数据计算，获得统计数据等
4. 特征抽取平台，主要负责特征的抽取，组合，归一化等
5. 模型的训练和验证，针对具体的目标，设计不同的模型，用于分类或回归；在部分数据上验证模型的效果，并得到指标（TPR，AUC）


##数据:
### ifeng:
1. 开盘
2. 最高价
3. 收盘
4. 最低价
5. 成交手
6. 均价diff
7. 涨幅
8. ma5
9. ma10
10. ma20
11. 成交5
12. 成交10
13. 成交20
14. 换手率

### bestgo_fund
1. ma
2. 涨幅
3. 换手率
4. ddx
5. bbd
6. 流通市值
7. 资金净流入
8. 多日资金力度10
9. 多日资金力度20
10. 多日资金力度30
11. 多日资金力度60
12. 多日资金力度90
13. 多日资金飘红10
14. 多日资金飘红20
15. 多日资金飘红30
16. 多日资金飘红60
17. 多日资金飘红90


### bestgo_hd
1. ma
2. 涨幅
3. 换手率
4. ddx
5. bbd
6. 流通市值
7. 隐单净量
8. 多日隐单力度1
9. 多日隐单力度3
10. 多日隐单力度5
11. 多日隐单力度10
12. 多日隐单飘红3
13. 多日隐单飘红5
14. 多日隐单飘红10
15. 多日隐单飘红20