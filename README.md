# stock

stock项目分为以下几个模块：
1. 数据库部分，主要负责数据的定义和存储
2. 数据抓取平台，也就是所谓的爬虫
3. 计算平台，主要负责数据加工，对原始的数据计算，获得统计数据等
4. 特征抽取平台，主要负责特征的抽取，组合，归一化等
5. 模型的训练和验证，针对具体的目标，设计不同的模型，用于分类或回归；在部分数据上验证模型的效果，并得到指标（TPR，AUC）


##数据:
### ifeng:
0. stockCode
1. cate
2. date
3. 开盘
4. 最高价
5. 收盘
6. 最低价
7. 成交手
8. 均价diff
9. 涨幅
10. ma5
11. ma10
12. ma20
13. 成交5
14. 成交10
15. 成交20
16. 换手率

### bestgo_fund
0. stockCode
1. cate
2. date
3. ma
4. 涨幅
5. 换手率
6. ddx
7. bbd
8. 流通市值
9. 资金净流入
10. 多日资金力度1
11. 多日资金力度3
12. 多日资金力度5
13. 多日资金力度10
14. 多日资金飘红3
15. 多日资金飘红5
16. 多日资金飘红10
17. 多日资金飘红20


### bestgo_hd
0. stockCode
1. cate
2. date
3. ma
4. 涨幅
5. 换手率
6. ddx
7. bbd
8. 流通市值
9. 隐单净量
10. 多日隐单力度1
11. 多日隐单力度3
12. 多日隐单力度5
13. 多日隐单力度10
14. 多日隐单飘红3
15. 多日隐单飘红5
16. 多日隐单飘红10
17. 多日隐单飘红20

### merged data : stock_code, stock_date
0. stockCode
1. date
2. ma
3. ma5
4. ma10
5. ma20
6. exchange
7. exchange5
8. exchange10
9. exchange20
10. ma_gradient
11. hsl
12. ltsz
13. zjlr
14. ydjl
15. szdata

# generate feature

