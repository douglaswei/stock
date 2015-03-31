import douglas.stock.spider.pageprocess.Shdjt.GeguPageProcess;

/**
 * Created by wgz on 15/3/31.
 */
public class TestShdjtPageProcessor {
    public static void main(String[] args) {
        GeguPageProcess pageProcess = new GeguPageProcess();
        pageProcess.processHtml(html);
    }

    public final static String html = "\n" +
            "\n" +
            "\n" +
            "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
            "<html>\n" +
            "<head>\n" +
            "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\">\n" +
            "<meta name=\"GENERATOR\" content=\"Microsoft FrontPage 4.0\">\n" +
            "<meta name=\"ProgId\" content=\"FrontPage.Editor.Document\">\n" +
            "\n" +
            "<meta name=\"description\" content=\"常林股份.600710_个股_资金流向(多日)_散户大家庭\">\n" +
            "<meta name=\"keywords\" content=\"常林股份,600710,资金流,dde,小单差,单数比\">\n" +
            "<title>常林股份.600710_个股_资金流向(多日)_散户大家庭</title>\n" +
            "\n" +
            "<script type=\"text/javascript\" src=\"js/shdjt.js\"></script>\n" +
            "<script type=\"text/javascript\" src=\"js/js.js\"></script>\n" +
            "<SCRIPT language=javascript src=\"DatePicker/WdatePicker.js\"></SCRIPT>\n" +
            "<SCRIPT src=\"js/SuggestFramework-min.js\" type=text/javascript></SCRIPT>\n" +
            "<script type=\"text/javascript\" src=\"http://cbjs.baidu.com/js/m.js\"></script>\n" +
            "<link rel=\"stylesheet\" type=\"text/css\" href=\"css/shdjt.css\">\n" +
            "<link rel=\"stylesheet\" type=\"text/css\" href=\"css/bt.css\">\n" +
            "</head>\n" +
            "\n" +
            "\n" +
            "\n" +
            "<script type=\"text/javascript\">\n" +
            "//<![data[\n" +
            "window.onload = function(){\n" +
            "var td = document.getElementById(\"senfe\").getElementsByTagName(\"td\");\n" +
            "for(var i=0; i<td.length; i++)\n" +
            "{\n" +
            "td[i].onclick = function()\n" +
            "{\n" +
            "for(var j=50; j<td.length-50; j++)\n" +
            "{\n" +
            "if(td[j].cellIndex==this.cellIndex || td[j].parentElement.rowIndex==this.parentElement.rowIndex){\n" +
            "td[j].style.backgroundColor=\"#f3dbda\"; //鼠标经过表格的颜色\n" +
            "}\n" +
            "else\n" +
            "{\n" +
            "td[j].style.backgroundColor=\"\";\n" +
            "}\n" +
            "}\n" +
            "}\n" +
            "/* \n" +
            "td[i].onmouseout = function(){\n" +
            "for(var j=0; j<td.length; j++){\n" +
            "if(td[j].cellIndex==this.cellIndex || td[j].parentElement.rowIndex==this.parentElement.rowIndex){\n" +
            "td[j].style.backgroundColor=\"\";\n" +
            "}\n" +
            "}\n" +
            "}\n" +
            "*/\n" +
            "}\n" +
            "}\n" +
            "//]]-->\n" +
            "</script>\n" +
            "\n" +
            "\n" +
            "<body  topmargin=\"0\" leftmargin=\"0\" >\n" +
            "<div align=\"center\">\n" +
            "<table border=\"0\" width=\"1140\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#f6f6f6\">\n" +
            "  <tr>\n" +
            "    <td width=\"450\" height=\"24\" class=tdtop><div class=\"divtop\" align=\"left\"><font color=\"#FF1E1E\">速记：shdjt.com=散户大家庭首字母,这里是中国广大散户的家!</font></div></td>\n" +
            "    <td height=\"24\" class=tdtop><div class=\"divtop\" align=\"right\">\n" +
            "      <a class=anews href=\"http://www.shdjt.com\" target=\"_blank\">散户大家庭.首页</a> \n" +
            "      <font color=\"#000000\">|</font> <a class=anews href=\"http://b.shdjt.com\" target=\"_blank\">股票论坛</a> \n" +
            "      <font color=\"#000000\">|</font> <a class=anews href=\"http://qgqp.shdjt.com\" target=\"_blank\">千股千评</a> \n" +
            "      <font color=\"#000000\">|</font> <a class=anews href=\"http://cwzx.shdjt.com\" target=\"_blank\">仓位在线</a>\n" +
            "      <font color=\"#000000\">|</font> <a class=anews href=\"http://lhb.shdjt.com\" target=\"_blank\">股票龙虎榜</a>\n" +
            "      <font color=\"#000000\">|</font> <a class=anews href=\"http://news.shdjt.com\" target=\"_blank\">股票新闻</a>\n" +
            "    <font color=\"#000000\">|</font> <a class=anews href=\"http://b.shdjt.com/index.asp?boardid=3\" target=\"_blank\">留言</a></div>\n" +
            "</td>\n" +
            "  </tr>\n" +
            "</table>\n" +
            "\n" +
            "<table border=\"0\" width=\"1140\" cellspacing=\"0\" cellpadding=\"0\">\n" +
            "  <tr height=\"80\">\n" +
            "    <td width=\"234\"><a href=\"http://www.shdjt.com\"><img border=\"0\" src=\"images/shdjt.png\" width=\"280\" height=\"80\"></a></td>\n" +
            "    <td height=\"80\">\n" +
            "<script async src=\"//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js\"></script>\n" +
            "<!-- 728x90, 创建于 08-4-22 -->\n" +
            "<ins class=\"adsbygoogle\"\n" +
            "     style=\"display:inline-block;width:728px;height:90px\"\n" +
            "     data-ad-client=\"ca-pub-3854125850080352\"\n" +
            "     data-ad-slot=\"8048377235\"></ins>\n" +
            "<script>\n" +
            "(adsbygoogle = window.adsbygoogle || []).push({});\n" +
            "</script>\n" +
            "    \t</td>\n" +
            "  </tr>\n" +
            "</table>\n" +
            "<table border=\"0\" id=\"changejj\" cellspacing=\"0\" cellpadding=\"0\" height=\"5\">\n" +
            "\t<tr>\n" +
            "\t\t<td></td>\n" +
            "\t</tr>\n" +
            "</table>\n" +
            "<table border=\"0\" width=\"1140\" cellspacing=\"0\" cellpadding=\"0\">\n" +
            "  <tr>\n" +
            "   <td><div align=\"center\">\n" +
            "   \t<form method=\"post\" action=\"sort.asp\" style=\"margin-top: 0; margin-bottom: 0\">\n" +
            "<font color=\"#ba3e3c\">全部个股.历史数据回放：</font><input class=\"Wdate\" onclick='WdatePicker()' type=\"text\" name=\"cxrq\" size=\"10\">&nbsp; <input class=input1 type=\"submit\" value=\"日期查询\" name=\"B1\"> \n" +
            "</form>\n" +
            "   \t<form method=\"post\"  action=\"gpdm.asp\" style=\"margin-top: 0; margin-bottom: 0\">\n" +
            "\t  <font color=\"#ba3e3c\">股票代码/名称/拼音：</font><input type=\"text\" id=stockcode name=\"gpdm\" class=\"textbox\" size=\"10\">\n" +
            "  <input class=input1 type=\"submit\" value=\"查该股资金流向…\" name=\"B1\">\n" +
            "</form>\n" +
            "&nbsp;<a  class=atop target=\"_blank\" href=\"http://#\" ></a>\n" +
            "</div></td>\n" +
            "  </tr>\n" +
            "    <tr>\n" +
            "   <td></td>\n" +
            "  </tr>\n" +
            "</table>\n" +
            "<SCRIPT src=\"js/loadstock.js\" type=text/javascript></SCRIPT>\n" +
            "<table border=\"0\" id=\"changejj\" cellspacing=\"0\" cellpadding=\"0\" height=\"2\">\n" +
            "\t<tr>\n" +
            "\t\t<td></td>\n" +
            "\t</tr>\n" +
            "</table>\n" +
            "<table border=\"0\" id=\"changejj\" width=\"1140\" cellspacing=\"0\" cellpadding=\"0\" height=\"5\">\n" +
            "\t<tr>\n" +
            "\t\t<td><font color='#d17270'><b>我的最近查询:</b></font> <a href='gpdm.asp?gpdm=600710'><font color='#d17270'>常林股份</font></a> <a href='gpdm.asp?gpdm=600500'><font color='#d17270'>中化国际</font></a> <a href='gpdm.asp?gpdm=993064'><font color='#d17270'>[医疗器械]</font></a> <a href='gpdm.asp?gpdm=600608'><font color='#d17270'>上海科技</font></a> <a href='gpdm.asp?gpdm=603020'><font color='#d17270'>爱普股份</font></a> <a href='gpdm.asp?gpdm=600029'><font color='#d17270'>南方航空</font></a> <a href='gpdm.asp?gpdm=600122'><font color='#d17270'>宏图高科</font></a> <a href='gpdm.asp?gpdm=603969'><font color='#d17270'>银龙股份</font></a></td>\n" +
            "\t</tr>\n" +
            "</table>\n" +
            "<table border=\"0\" id=\"changejj\" cellspacing=\"0\" cellpadding=\"0\" height=\"2\">\n" +
            "\t<tr>\n" +
            "\t\t<td></td>\n" +
            "\t</tr>\n" +
            "</table>\n" +
            "<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n" +
            "\t<tr>\n" +
            "\t\t<td>\n" +
            "<div class=\"nav area\">\n" +
            "    \t  <div class=\"mainnav\">\n" +
            "                    <ul  class=\"main-nav\">\n" +
            "                \t    <li class=\"nav_line\"></li>\n" +
            "                \t    <li><a href=\"http://www.shdjt.com\"><span>首页</span></a></li>\n" +
            "                      <li class=\"nav_line\"></li>\n" +
            "                \t    <li onmouseover=\"ShowHMenu(1)\" onmouseout=\"ShowHMenu(0)\" id=\"Hmenu_1_Title\" class=\"menu\"><a href=\"#\"><span>DDE个股.沪深…</span></a>\n" +
            "                          <div class=\"nav-jumplayer-1\" id=\"Hmenu_1\" style=\"display: none;\" onmouseover=\"ShowHMenu(1)\" onmouseout=\"ShowHMenu(0)\">\n" +
            "                              <div class=\"content\">\n" +
            "                                  <ul>\n" +
            "                                      <li><a href=\"sh.htm\">沪市个股　　　&nbsp;</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a href=\"sz.htm\">深市个股　　　&nbsp;</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a href=\"cy.htm\">创业板个股 　 &nbsp;</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a href=\"bg.htm\">沪深Ｂ股　　　&nbsp;</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a href=\"jj.htm\">沪深基金.可交易</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a href=\"bk.htm\">沪深板块.资金流</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a href=\"zs.htm\">沪深指数.一览表</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a href=\"pjsyl.asp\">沪深.平均市盈率</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a href=\"http://www.shdjt.com/\">首页综合 　　 &nbsp;</a></li>\n" +
            "                                  </ul>\n" +
            "                              </div>\n" +
            "                          </div>                      \n" +
            "               \t\t\t\t\t</li>\n" +
            "                      \t<li class=\"nav_line\"></li>\n" +
            "                        <li onmouseover=\"ShowHMenu(2)\" onmouseout=\"ShowHMenu(0)\" id=\"Hmenu_2_Title\" class=\"menu\"><a href=\"#\"><span>板块个股</span></a>\n" +
            "                          <div class=\"nav-jumplayer-2\" id=\"Hmenu_2\" style=\"display: none;\" onmouseover=\"ShowHMenu(2)\" onmouseout=\"ShowHMenu(0)\">\n" +
            "                              <div class=\"content\">\n" +
            "                                  <ul>\n" +
            "                                      <li><a href=\"flsort.asp?lb=sh000016\">上证50 &nbsp;</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a href=\"flsort.asp?lb=993505\">沪深300&nbsp;</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a href=\"flsort.asp?lb=399333\">中小板 &nbsp;</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a href=\"flsort.asp?lb=993124\">深成分股</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a href=\"flsort.asp?lb=991017\">银行　 &nbsp;</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a href=\"flsort.asp?lb=991036\">券商　 &nbsp;</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a href=\"flsort.asp?lb=991009\">钢铁　 &nbsp;</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a href=\"flsort.asp?lb=991007\">房地产 &nbsp;</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a href=\"flsort.asp?lb=991019\">煤炭石油</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a href=\"flsort.asp?lb=991034\">有色金属</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a href=\"flsort.asp?lb=993039\">沪自贸区</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a href=\"bk.htm\">更多… &nbsp;</a></li>\n" +
            "                                  </ul>\n" +
            "                              </div>\n" +
            "                          </div>                      \n" +
            "               \t\t\t\t\t</li>\n" +
            "                      \t<li class=\"nav_line\"></li>\n" +
            "                        <li onmouseover=\"ShowHMenu(3)\" onmouseout=\"ShowHMenu(0)\" id=\"Hmenu_3_Title\" class=\"menu\"><a href=\"#\"><span>主题投资库</span></a>\n" +
            "                          <div class=\"nav-jumplayer-3\" id=\"Hmenu_3\" style=\"display: none;\" onmouseover=\"ShowHMenu(3)\" onmouseout=\"ShowHMenu(0)\">\n" +
            "                              <div class=\"content\">\n" +
            "                                  <ul>\n" +
            "                                      <li><a href='zt.asp?lb=%BD%A8%D6%FE%BD%DA%C4%DC'>建筑节能</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a href='zt.asp?lb=%B3%AC%BC%B6%CF%B8%BE%FA'>超级细菌</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a href='zt.asp?lb=%D1%F8%C0%CF%B8%C5%C4%EE'>养老概念</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a href='zt.asp?lb=%B8%DF%B6%CB%C9%E8%B1%B8'>高端设备</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a href='zt.asp?lb=%CE%DB%CB%AE%B4%A6%C0%ED'>污水处理</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a href='zt.asp?lb=%C7%A6%D0%BF%BD%F0%CA%F4'>铅锌金属</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a href='zt.asp?lb=%F2%E7%B3%E6%B2%A1%B6%BE'>蜱虫病毒</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a href='zt.asp?lb=%D0%C5%CF%A2%B0%B2%C8%AB'>信息安全</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a href='zt.asp?lb=%CA%D6%BB%FA%D3%CE%CF%B7'>手机游戏</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a title=\"主题投资库\" href=\"ztlist.htm\">更多… &nbsp;</a></li>\n" +
            "                                  </ul>\n" +
            "                              </div>\n" +
            "                          </div>                      \n" +
            "               \t\t\t\t\t</li>               \t\t\t\t\t\n" +
            "               \t\t\t\t\t<li class=\"nav_line\"></li>\n" +
            "                        <li onmouseover=\"ShowHMenu(4)\" onmouseout=\"ShowHMenu(0)\" id=\"Hmenu_4_Title\" class=\"menu\"><a href=\"#\"><span>个股.综合排序</span></a>\n" +
            "                          <div class=\"nav-jumplayer-4\" id=\"Hmenu_4\" style=\"display: none;\" onmouseover=\"ShowHMenu(4)\" onmouseout=\"ShowHMenu(0)\">\n" +
            "                              <div class=\"content\">\n" +
            "                                  <ul>\n" +
            "                                      <li><a href=\"sort.asp\">全指标排序 &nbsp;</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a href=\"zbsort.htm\">ddx增量排序&nbsp;</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a href=\"zjlsort.htm\">资金流排序 &nbsp;</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a href=\"gpdm.asp\">个股查询.表&nbsp;</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a href=\"gpdm_p.asp\">个股查询.图&nbsp;</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a href=\"gpdmfs.asp\">分时ddx查询&nbsp;</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a href=\"#\">-----------</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a target=\"_blank\" href=\"http://qgqp.shdjt.com/gpdm.asp\">个股专家点评</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a target=\"_blank\" href=\"http://cwzx.shdjt.com/gpdmgd.asp\">个股10大股东</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a target=\"_blank\" href=\"http://news.shdjt.com/newsgpdm.asp\">个股新闻查询</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a target=\"_blank\" href=\"http://lhb.shdjt.com/gpdm.asp\">个股异动查询</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t</ul>\n" +
            "                              </div>\n" +
            "                          </div>                      \n" +
            "               \t\t\t\t\t</li>\n" +
            "                        <li class=\"nav_line\"></li>\n" +
            "                        <li onmouseover=\"ShowHMenu(5)\" onmouseout=\"ShowHMenu(0)\" id=\"Hmenu_5_Title\" class=\"menu\"><a href=\"#\"><span>异动股机构坐席</span></a>\n" +
            "                          <div class=\"nav-jumplayer-5\" id=\"Hmenu_5\" style=\"display: none;\" onmouseover=\"ShowHMenu(5)\" onmouseout=\"ShowHMenu(0)\">\n" +
            "                              <div class=\"content\">\n" +
            "                                  <ul>\n" +
            "                                      <li><a target=\"_blank\" href=\"http://lhb.shdjt.com/jgzx.asp\">机构坐席 　　 &nbsp;</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a target=\"_blank\" href=\"http://lhb.shdjt.com/gpdm.asp?gpdm=new\">新股坐席 　　 &nbsp;</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a target=\"_blank\" href=\"http://lhb.shdjt.com/zhsort.htm\">异动股排名 　 &nbsp;</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a target=\"_blank\" href=\"http://lhb.shdjt.com/jgzxcx.asp\">营业部搜索 　 &nbsp;</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a target=\"_blank\" href=\"http://lhb.shdjt.com\">异动股T+0龙虎榜</a></li>\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t\n" +
            "\t                                 </ul>\n" +
            "                              </div>\n" +
            "                          </div>                      \n" +
            "               \t\t\t\t\t</li>\n" +
            "               \t\t\t\t\t<li class=\"nav_line\"></li>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t<li onmouseover=\"ShowHMenu(6)\" onmouseout=\"ShowHMenu(0)\" id=\"Hmenu_6_Title\" class=\"menu\"><a href=\"#\"><span>flash版行情</span></a>\n" +
            "                          <div class=\"nav-jumplayer-6\" id=\"Hmenu_6\" style=\"display: none;\" onmouseover=\"ShowHMenu(6)\" onmouseout=\"ShowHMenu(0)\">\n" +
            "                              <div class=\"content\">\n" +
            "                                  <ul>\n" +
            "                                      <li><a  target=\"_blank\" href=\"dzh.htm\">大智慧flash版</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a  target=\"_blank\" href=\"ths.htm\">同花顺flash版</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a  target=\"_blank\" href=\"tdx.htm\">通达信flash版</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a  target=\"_blank\" href=\"qianxun.htm\">千寻flash版 &nbsp;</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a  target=\"_blank\" href=\"dp.htm\">web大盘看全球</a></li>\n" +
            "\t                                 </ul>\n" +
            "                              </div>\n" +
            "                          </div>                      \n" +
            "               \t\t\t\t\t</li>\n" +
            "              \t\t\t\t<li class=\"nav_line\"></li>\n" +
            "                        <li onmouseover=\"ShowHMenu(7)\" onmouseout=\"ShowHMenu(0)\" id=\"Hmenu_7_Title\" class=\"menu\"><a href=\"#\"><span>其他.工具</span></a>\n" +
            "                          <div class=\"nav-jumplayer-7\" id=\"Hmenu_7\" style=\"display: none;\" onmouseover=\"ShowHMenu(7)\" onmouseout=\"ShowHMenu(0)\">\n" +
            "                               <div class=\"content\">\n" +
            "                                  <ul>\n" +
            "                                      <li><a target=\"_blank\" href=\"http://b.shdjt.com/dispbbs.asp?boardid=2&Id=12583\">散户天天宝　　 &nbsp;</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a target=\"_blank\" href=\"http://b.shdjt.com/dispbbs.asp?boardid=8&Id=194\">股票计算器　　 &nbsp;</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a target=\"_blank\" href=\"http://b.shdjt.com/dispbbs.asp?boardid=8&Id=194\">大智慧VIP版78合1</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a target=\"_blank\" href=\"http://cwzx.shdjt.com/top.htm\">最牛散户top100 &nbsp;</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a href=\"zxg.asp\">自选股　　　　 &nbsp;</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a href=\"help.htm\">?.帮助　　　　 &nbsp;</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t</ul>\n" +
            "                              </div>\n" +
            "                          </div>                      \n" +
            "               \t\t\t\t\t</li>\n" +
            "               \t\t\t\t\t<li class=\"nav_line\"></li>\n" +
            "                        <li onmouseover=\"ShowHMenu(8)\" onmouseout=\"ShowHMenu(0)\" id=\"Hmenu_8_Title\" class=\"menu\"><a href=\"#\"><span>旗下网站</span></a>\n" +
            "                          <div class=\"nav-jumplayer-8\" id=\"Hmenu_8\" style=\"display: none;\" onmouseover=\"ShowHMenu(8)\" onmouseout=\"ShowHMenu(0)\">\n" +
            "                               <div class=\"content\">\n" +
            "                                  <ul>\n" +
            "                                      <li><a target=\"_blank\" href=\"http://b.shdjt.com\">散户股票论坛 &nbsp;</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a target=\"_blank\" href=\"http://qgqp.shdjt.com\">千股千评　　 &nbsp;</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a target=\"_blank\" href=\"http://cwzx.shdjt.com\">仓位在线　　 &nbsp;</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a target=\"_blank\" href=\"http://lhb.shdjt.com\">股票龙虎榜　 &nbsp;</a></li>\n" +
            "\t\t\t\t\t\t\t\t       \t\t\t\t\t\t\t\t<li><a target=\"_blank\" href=\"http://news.shdjt.com\">股票新闻汇聚站</a></li>\n" +
            "                                  </ul>\n" +
            "                              </div>\n" +
            "                          </div>                      \n" +
            "               \t\t\t\t\t</li>\n" +
            "                 \t\t\t\t<li class=\"nav_line\"></li>\n" +
            "                    </ul>\n" +
            "\t\t\t\t</div>\n" +
            "</div>\t\t\t\n" +
            "\t\t\t</td>\n" +
            "\t</tr>\n" +
            "</table>\n" +
            "\n" +
            "<table border=\"0\" width=\"1140\" align=\"center\" id=\"table1\" cellpadding=\"0\" bordercolor=\"#ba3e3c\" bordercolorlight=\"#ba3e3c\" bordercolordark=\"#ba3e3c\" cellspacing=\"0\" style=\"border-collapse: collapse\">\n" +
            "<tr>\n" +
            "<td width=\"162\" valign=\"top\">\n" +
            "<script type=\"text/javascript\">BAIDU_CLB_fillSlot(\"914599\");</script>\n" +
            "</td>\n" +
            "<td  width=\"728\" valign=\"top\">\n" +
            "<script type=\"text/javascript\">BAIDU_CLB_fillSlot(\"914586\");</script>\n" +
            "<script async src=\"//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js\"></script>\n" +
            "<!-- 728x90, 创建于 08-4-22 -->\n" +
            "<ins class=\"adsbygoogle\"\n" +
            "     style=\"display:inline-block;width:728px;height:90px\"\n" +
            "     data-ad-client=\"ca-pub-3854125850080352\"\n" +
            "     data-ad-slot=\"8048377235\"></ins>\n" +
            "<script>\n" +
            "(adsbygoogle = window.adsbygoogle || []).push({});\n" +
            "</script>\n" +
            "<script type=\"text/javascript\">BAIDU_CLB_fillSlot(\"698574\");</script>\n" +
            "</td>\n" +
            "<td width=\"248\" valign=\"top\">\n" +
            "<table class=\"tb2td1\" width=\"100%\" align=\"center\" id=\"table1\" cellpadding=\"0\" bordercolor=\"#ba3e3c\" bordercolorlight=\"#ba3e3c\" bordercolordark=\"#ba3e3c\" cellspacing=\"0\" style=\"border-collapse: collapse\">\n" +
            "<tr><td>\n" +
            "<iframe id=\"test\" name=\"test11\" align=\"middle\" marginwidth=\"0\" marginheight=\"0\" src=\"bbs_new.html\" frameborder=\"0\" width=\"246\" scrolling=\"no\" height=\"268\" twffan=\"done\"></iframe>\n" +
            "</td></tr></table>\n" +
            "</td>\n" +
            "</tr></table>\n" +
            "<SCRIPT src=\"js/loadstock.js\" type=text/javascript></SCRIPT>\n" +
            "\n" +
            "<table class=\"tb2td1\" width=\"1140\" align=\"center\" id=\"table1\" cellpadding=\"0\" bordercolor=\"#BA3E3C\" bordercolorlight=\"#BA3E3C\" bordercolordark=\"#BA3E3C\" cellspacing=\"0\" >\n" +
            "\t<tr bgcolor=\"#BA3E3C\" height=\"30\">\n" +
            "<td class=tdhelp  colspan=\"3\">&nbsp;<b>常林股份.600710:最新股票新闻</b> &nbsp;<a target=\"_blank\" href='http://news.shdjt.com/newsgpdm.asp?gpdm=600710'>更多常林股份新闻…</a></td>\n" +
            "</tr>\n" +
            "<tr height='25'><td class=tdleft><a class=\"anews\" target=\"_blank\" href='http://news.shdjt.com/gpnews.asp?newsid=600710-20150320193000'>[1].常林股份有限公司2014年度业绩盈亏不确定的进展公</a>&nbsp;<font color=\"c0c0c0\">2015-3-21</font></td><td class=tdleft><a class=\"anews\" target=\"_blank\" href='http://news.shdjt.com/gpnews.asp?newsid=600710-20150306100730'>[2].常林股份去年业绩盈亏尚不确定若亏损将戴帽</a>&nbsp;<font color=\"c0c0c0\">2015-3-21</font></td><td class=tdleft><a class=\"anews\" target=\"_blank\" href='http://news.shdjt.com/gpnews.asp?newsid=600710-20150213173730'>[3].常林股份有限公司2014年度业绩盈亏不确定的进展公</a>&nbsp;<font color=\"c0c0c0\">2015-3-21</font></td></tr><tr height='25'><td class=tdleft><a class=\"anews\" target=\"_blank\" href='http://news.shdjt.com/gpnews.asp?newsid=600710-20141225111500'>[4].常林股份：第七届董事会第一次会议决议公告</a>&nbsp;<font color=\"c0c0c0\">2014-12-25</font></td><td class=tdleft><a class=\"anews\" target=\"_blank\" href='http://news.shdjt.com/gpnews.asp?newsid=600710-20141223184500'>[5].常林股份有限公司处置部分资产进展公告</a>&nbsp;<font color=\"c0c0c0\">2014-12-25</font></td><td class=tdleft><a class=\"anews\" target=\"_blank\" href='http://news.shdjt.com/gpnews.asp?newsid=600710-20141210190730'>[6].常林股份有限公司关于处置部分资产的补充公告</a>&nbsp;<font color=\"c0c0c0\">2014-12-25</font></td></tr><tr height='25'><td class=tdleft><a class=\"anews\" target=\"_blank\" href='http://news.shdjt.com/gpnews.asp?newsid=600710-20141210013659'>[7].常林股份有限公司第六届董事会第十八次会议决议公</a>&nbsp;<font color=\"c0c0c0\">2014-12-10</font></td><td class=tdleft><a class=\"anews\" target=\"_blank\" href='http://news.shdjt.com/gpnews.asp?newsid=600710-20141205083730'>[8].周五晚间私募传闻集锦</a>&nbsp;<font color=\"c0c0c0\">2014-12-10</font></td><td class=tdleft><a class=\"anews\" target=\"_blank\" href='http://news.shdjt.com/gpnews.asp?newsid=600710-20141205053730'>[9].2014“感动山西”20位候选人名单确定</a>&nbsp;<font color=\"c0c0c0\">2014-12-10</font></td></tr>\n" +
            "</table>\t\n" +
            "\n" +
            "\n" +
            "<div id=\"aa1\" style=\"display:none; width:0px; height:0px; background-color:#999; float:left\">\n" +
            "<iframe marginwidth=\"0\" marginheight=\"0\"  frameborder=\"0\" bordercolor=\"#000000\" scrolling=\"no\" id=\"zxgid\"></iframe>\n" +
            "</div>\n" +
            "<table class=\"tb2td1\" width=\"1140\" align=\"center\" id=\"table1\" cellpadding=\"0\" bordercolor=\"#BA3E3C\" bordercolorlight=\"#BA3E3C\" bordercolordark=\"#BA3E3C\" cellspacing=\"0\" >\n" +
            "\t<tr bgcolor=\"#BA3E3C\" height=\"30\">\n" +
            "<td>\n" +
            "<table width=\"100%\" border=\"0\" id=\"changejj\" cellspacing=\"0\" cellpadding=\"0\" height=\"2\">\n" +
            "<tr>\n" +
            "<td width=\"1020\"  class=tdhelp>\n" +
            "&nbsp;<b>常林股份.600710:每天的dde资金流指标</b> &nbsp;<a class=ahs2 href=\"javascript:location.reload()\">【手工刷新下方数据】</a>\n" +
            "\n" +
            "<input class=input2 style=\"width:170px;\"  onclick=\"javascript:document.getElementById('zxgid').src='zxg_cz.asp?cz=add&gpdm=600710'\" type=\"button\" value=\"添加.常林股份.到自选股\" name=\"B1\">\n" +
            "\n" +
            "<input class=input2 onclick=\"location.href='zxg.asp'\" type=\"button\" style=\"width:100px;\"  value=\"我的自选股\" name=\"B1\">\n" +
            "\n" +
            "<input class=input3 style=\"width:70px;\" onclick=\"location.href='setwidth.asp?w=2&url=http://www.shdjt.com/gpdm.asp?gpdm=600710'\"  type=\"button\" value=\"切:宽表格\" name=\"B1\">\n" +
            "\n" +
            "</td>\n" +
            "<td width=\"120\"  class=tdhelp>\n" +
            "<a target=\"_blank\" href=\"help.htm\"><font color=\"#00FFFF\">？.指标使用说明</font><a>\n" +
            "</td>\n" +
            "</tr>\n" +
            "</table>\n" +
            "\t</td>\n" +
            "</tr>\n" +
            " \t<tr height=\"25\">\n" +
            "\t\t<td class=tdleft1>常林股份：\n" +
            "<a class=\"ak\" title=\"常林股份分时ddx资金流\" href=\"gpdmfs.asp?gpdm=600710\"><img border=\"0\" src=\"images/1.png\" align=\"texttop\"> 分时ddx</a>\n" +
            "<a class=\"ak\" title=\"常林股份分日dde资金流趋势图\" href=\"gpdm_p.asp?gpdm=600710\"><img border=\"0\" src=\"images/2.png\" align=\"texttop\">  分日dde资金流.图 </a>\n" +
            "\n" +
            "<a target=\"_blank\" class=\"ak\" title=\"常林股份专家点评\"  href=\"http://qgqp.shdjt.com/gpdm.asp?gpdm=600710\"><img border=\"0\" src=\"images/3.png\" align=\"texttop\"> 专家点评</a>\n" +
            "<a target=\"_blank\" class=\"ak\" title=\"常林股份相关新闻\"  href=\"http://news.shdjt.com/newsgpdm.asp?gpdm=600710\"><img border=\"0\" src=\"images/4.png\" align=\"texttop\"> 新闻…</a>\n" +
            "\n" +
            "<a target=\"_blank\" class=\"ak\" title=\"常林股份十大股东\"  href=\"http://cwzx.shdjt.com/gpdmgd.asp?gpdm=600710\"><img border=\"0\" src=\"images/5.png\" align=\"texttop\"> 十大股东</a>\n" +
            "<a target=\"_blank\" class=\"ak\" title=\"常林股份异动坐席\" href=\"http://lhb.shdjt.com/gpdm.asp?gpdm=600710\"><img border=\"0\" src=\"images/6.png\" align=\"texttop\"> 异动坐席</a>\n" +
            "\n" +
            "</td>\n" +
            "\t</tr> \n" +
            "<tr height=\"25\">\n" +
            "<td class=tdhsleft>\n" +
            "<font color=\"BA3E3C\">历史数据：</font>[<a  class=azs href=\"gpdm.asp?page=1&gpdm=600710\">1</a>]\n" +
            "[<a  class=azs href=\"gpdm.asp?page=2&gpdm=600710\">2</a>]\n" +
            "[<a  class=azs href=\"gpdm.asp?page=3&gpdm=600710\">3</a>]\n" +
            "[<a  class=azs href=\"gpdm.asp?page=4&gpdm=600710\">4</a>]\n" +
            "[<a  class=azs href=\"gpdm.asp?page=5&gpdm=600710\">5</a>]\n" +
            "[<a  class=azs href=\"gpdm.asp?page=6&gpdm=600710\">6</a>]\n" +
            "[<a  class=azs href=\"gpdm.asp?page=7&gpdm=600710\">7</a>]\n" +
            "[<a  class=azs href=\"gpdm.asp?page=8&gpdm=600710\">8</a>]\n" +
            "[<a  class=azs href=\"gpdm.asp?page=9&gpdm=600710\">9</a>]\n" +
            "[<a  class=azs href=\"gpdm.asp?page=10&gpdm=600710\">10</a>]\n" +
            "[<a  class=azs href=\"gpdm.asp?page=11&gpdm=600710\">11</a>]\n" +
            "[<a  class=azs href=\"gpdm.asp?page=12&gpdm=600710\">12</a>]\n" +
            "[<a  class=azs href=\"gpdm.asp?page=13&gpdm=600710\">13</a>]\n" +
            "[<a  class=azs href=\"gpdm.asp?page=14&gpdm=600710\">14</a>]\n" +
            "[<a  class=azs href=\"gpdm.asp?page=15&gpdm=600710\">15</a>]\n" +
            "\n" +
            "\t\t\t</td>\n" +
            "\t</tr>\n" +
            "\n" +
            "<tr height=\"25\">\n" +
            "<td class=tdhsleft>\n" +
            "<font color='#737373'>相关板块概念：</font><a class='anews' target='_blank' href='flsort.asp?lb=991027'>机械<font color='9a9a9a'>[-0.03%]</font></a>　<a class='anews' target='_blank' href='flsort.asp?lb=993144'>低价<font color='9a9a9a'>[-0.25%]</font></a>　<a class='anews' target='_blank' href='flsort.asp?lb=993622'>长江三角<font color='9a9a9a'>[1.31%]</font></a>　<a class='anews' target='_blank' href='flsort.asp?lb=993795'>中字头<font color='9a9a9a'>[0.13%]</font></a><br><font color='#737373'>微主题：</font><a class='anews1' target='_blank' href='zt.asp?lb=%B1%A3%D5%CF%B7%BF%2D%BB%FA%D0%B5'>保障房-机械　<a class='anews1' target='_blank' href='zt.asp?lb=工程机械'>工程机械　<a class='anews1' target='_blank' href='zt.asp?lb=国机系'>国机系\n" +
            "</td>\n" +
            "</tr>\n" +
            "\n" +
            "<tr height=\"25\">\n" +
            "<td class=tdleft>\n" +
            "\t<font color=\"#CD6765\">\n" +
            "『今日数据』 最新:7.1(3.20%)　最高:7.34(6.69%)　最低:6.92(0.58%)　日震幅:6.10%　流通市值:45.46亿元　流通股:6.4亿股　市盈率:-38.04　每股收益:-0.140<br>『多日统计』 3日震幅:18.81%　3日涨幅:13.99%　周涨幅:17.77%　月涨幅:34.54%　半年涨幅:64.5%　年涨幅:120.87%\n" +
            "</font>\n" +
            "</td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "\t<td>\t\t\t\n" +
            "\n" +
            "<div id=\"gpdm_divid\" class=\"gpdm_div\"  style=\"width:1134px; height:540px; \"  >\n" +
            "<table id=\"senfe\" class=\"tb0td1gpdm\" width=\"2100\" cellspacing=\"0\" cellpadding=\"0\" overflow-x:scroll bordercolor=\"#ecc5c4\" bordercolorlight=\"#ecc5c4\" bordercolordark=\"#ecc5c4\" style=\"border-collapse: collapse\">\n" +
            "<thead>\n" +
            "<tr bgcolor=\"#BA3E3C\">\n" +
            "<td width=\"60\">日期</td>\n" +
            "<td width=\"40\">更新<br>时间</td>\n" +
            "<td width=\"50\">股票<br>代码</td>\n" +
            "<td width=\"130\">股票名称</td>\n" +
            "<td width=\"40\">最新</td>\n" +
            "<td width=\"40\">涨幅<br>%</td>\n" +
            "<td width=\"45\" title=\"大单买入净量占流通盘的百分比(越大越好)\">ddx</td>\n" +
            "<td width=\"45\" title=\"每日卖出单数和买入单数差的累计值(越大越好)\">ddy</td>\n" +
            "<td  width=\"55\" title=\"表示了大资金买入强度，色带越宽、越高表示买入强度越大(越大越好)\">ddz</td>\n" +
            "<td width=\"50\" title=\"（越大越好） 正:大资金流入 负:大资金流出\" >净额<br>(万元)<br></td>\n" +
            "<td width=\"40\" title=\"(单位:万元)特大差%*总成交量（大机构净流入）\">特大<br>差量</td>\n" +
            "<td width=\"40\" title=\"(单位:万元)大单差%*总成交量（中机构净流入）\">大单<br>差量</td>\n" +
            "<td width=\"40\" title=\"(单位:万元)中单差%*总成交量（中散户净流入）\">中单<br>差量</td>\n" +
            "<td width=\"40\" title=\"(单位:万元)小单差%*总成交量（小散户净流入）\">小单<br>差量</td>\n" +
            "<td width=\"40\" title=\"正:机构买（越正买的越厉害）负:机构卖（越负卖的越厉害）\">强度<br></td>\n" +
            "<td width=\"40\" title=\"主动率=((外盘-内盘)/(内盘+外盘))*100\">主动<br>率%</td>\n" +
            "<td width=\"40\" title=\"通吃率=((净额)/成交额)*100\">通吃<br>率%</td>\n" +
            "<td width=\"30\" title=\"(单位:%)(特大买入-特大卖出)（数值越大说明大机构买入越多，数值越大越好）\">特大<br>差%</td>\n" +
            "<td width=\"30\" title=\"(单位:%)(大单买入-大单卖出)（数值越大说明中机构买入越多，数值越大越好）\">大单<br>差%</td>\n" +
            "<td width=\"30\" title=\"(单位:%)(中单买入-中单卖出)（数值越大说明中散户买入越多，数值越负越好）\">中单<br>差%</td>\n" +
            "<td width=\"30\" title=\"(单位:%)(小单买入-小单卖出)（数值越大说明小散户买入越多，数值越负越好）\">小单<br>差%</td>\n" +
            "<td width=\"30\" title=\"大资金参与买卖的程度，大于100应该关注\">活跃<br>度</td>\n" +
            "<td width=\"30\" title=\"卖出单数/买入单数，(单数比＞1说明大资金买入强，越大越强)\">单数<br>比</td>\n" +
            "<td width=\"45\" title=\"5日ddx累计数值\">5日<br>ddx</td>\n" +
            "<td width=\"45\" title=\"5日ddy累计数值\">5日<br>ddy</td>\n" +
            "<td width=\"45\" title=\"60日ddx累计数值\">60日<br>ddx</td>\n" +
            "<td width=\"45\" title=\"60日ddx累计数值\">60日<br>ddy</td>\n" +
            "<td width=\"18\" title=\"该股近10天里，ddx翻红的天数合计次数。\">次</td>\n" +
            "<td width=\"18\" title=\"该股ddx连续翻红的天数。(在排序页面里进行排序它，很可能选出未来牛股)\">连</td>\n" +
            "<td width=\"50\" title=\"(单位:手)=小单差*成交量总手(都是越小越好),小单差开盘的时候是失真的，这个时候用小单差手来判断就准确多了\">小单<br>差手</td>\n" +
            "<td width=\"40\" title=\"反应了大资金参与买卖的强度\">资金<br>强度</td>\n" +
            "<td width=\"40\" title=\"当天总的买入单数，买入单数<卖出单数 比较好\">买入<br>单数</td>\n" +
            "<td width=\"40\" title=\"当天总的卖出单数\">卖出<br>单数</td>\n" +
            "<td width=\"40\" title=\"每单平均买入手数,越大越好\">买单<br>均手</td>\n" +
            "<td width=\"40\" title=\"每单平均卖出手数,越小越好\">卖单<br>均手</td>\n" +
            "<td width=\"40\" title=\"(单位:万元)根据'小单差量'做的顺序递加每日累计和\">小单<br>累计</td>\n" +
            "<td width=\"60\" title=\"(单位:万元)根据'特大差量+大单差量'做的顺序递加每日累计和\">净额<br>累计</td>\n" +
            "<td width=\"30\" title=\"特大单买入占的总买入的比例\">特大<br>买入</td>\n" +
            "<td width=\"30\" title=\"特大单卖出占的总买出的比例\">特大<br>卖出</td>\n" +
            "<td width=\"30\" title=\"大单买入占的总买入的比例\">大单<br>买入</td>\n" +
            "<td width=\"30\" title=\"大单卖出占的总买出的比例\">大单<br>卖出</td>\n" +
            "<td width=\"30\" title=\"中单买入占的总买入的比例\">中单<br>买入</td>\n" +
            "<td width=\"30\" title=\"中单卖出占的总买出的比例\">中单<br>卖出</td>\n" +
            "<td width=\"30\" title=\"小单买入占的总买入的比例\">小单<br>买入</td>\n" +
            "<td width=\"30\" title=\"小单卖出占的总买出的比例\">小单<br>卖出</td>\n" +
            "<td width=\"40\">换手<br>率%</td>\n" +
            "<td width=\"40\">量比</td>\n" +
            "<td width=\"70\">市盈<br>率</td>\n" +
            "<td width=\"40\">每股<br>收益</td>\n" +
            "<td width=\"70\">日期</td>\n" +
            "</tr>\n" +
            "</thead>\n" +
            "<tr height='30'><td>2015-3-31</td><td>14:0</td><td>600710</td><td class=tdleft><a class=ared target='_blank' href='gpdm.asp?gpdm=600710'>常林股份</a> <font color='#cc99ff'>机械仪表</font><br><a target='_blank' title='常林股份分时ddx资金流' class=ahs3 href='gpdmfs.asp?gpdm=600710'>分</a>.<a class=ahs3 target='_blank' title='常林股份分日dde资金流' href='gpdm.asp?gpdm=600710'>日</a>.<a class=ahs3 target='_blank' title='常林股份分日dde资金流趋势图' href='gpdm_p.asp?gpdm=600710'>图</a>.<a class=ahs3 title='常林股份专家点评' target='_blank' href='http://qgqp.shdjt.com/gpdm.asp?gpdm=600710'>评</a>.<a class=ahs3 title='常林股份异动坐席' target='_blank' href='http://lhb.shdjt.com/gpdm.asp?gpdm=600710'>异</a>.<a class=ahs3 title='常林股份相关新闻' target='_blank' href='http://news.shdjt.com/newsgpdm.asp?gpdm=600710'>闻</a>.<a class=ahs3 title='常林股份十大股东' target='_blank' href='http://cwzx.shdjt.com/gpdmgd.asp?gpdm=600710'>东</a></td><td>7.10</td><td class=tdred>3.20</td><td class=tdblue>-3.287</td><td>-5.177</td><td>-89.518</td>\t<td class=tdbgblue>-15010</td>\t<td class=tdblue>-13892</td>\t<td class=tdblue>-1118</td>\t<td class=tdblue>4258</td>\t<td class=tdblue>10752</td>\t<td class=tdbgblue>-33.84</td><td class=tdred>12.29</td><td class=tdblue>-28.2</td><td class=tdblue>-26.1</td><td>-2.1</td><td>8.0</td><td class=tdblue>20.2</td><td bgcolor='#f0f0f0'>119</td><td>.43</td><td>-3.909</td><td>-6.902</td><td>-7.210</td><td>-14.827</td><td>5</td><td>0</td><td class=tdblue>151109</td><td>1068</td><td>24960</td><td>10802</td><td>30.0</td><td>69.3</td><td>10752</td><td>-15010</td><td>8.1</td><td>34.2</td><td>37.5</td><td>39.6</td><td>19.7</td><td>11.7</td><td>34.7</td><td>14.5</td><td>11.68</td><td>2.76</td><td>-38.04</td><td>-0.140</td><td>2015-3-31</td></tr><tr height='24'><td>2015-3-31</td><td>11:31</td><td>600710</td><td class=tdred>常林股份</td><td>7.13</td><td class=tdred>3.63</td><td class=tdblue>-3.152</td><td>-4.851</td><td>-94.871</td>\t<td class=tdbgblue>-14364</td>\t<td class=tdblue>-14118</td>\t<td class=tdblue>-246</td>\t<td class=tdblue>4181</td>\t<td class=tdblue>10183</td>\t<td class=tdbgblue>-35.04</td><td class=tdred>10.58</td><td class=tdblue>-29.2</td><td class=tdblue>-28.7</td><td>-0.5</td><td>8.5</td><td class=tdblue>20.7</td><td bgcolor='#f0f0f0'>120</td><td>.42</td><td>-3.678</td><td>-6.348</td><td>-6.979</td><td>-14.173</td><td>5</td><td>0</td><td class=tdblue>143076</td><td>995</td><td>22709</td><td>9461</td><td>30.4</td><td>73.1</td><td>10183</td><td>-14364</td><td>7.9</td><td>36.6</td><td>37.7</td><td>38.2</td><td>19.8</td><td>11.3</td><td>34.6</td><td>13.9</td><td>10.80</td><td>3.81</td><td>-38.20</td><td>-0.140</td><td>2015-3-31</td></tr><tr height='24'><td>2015-3-30</td><td>16:12</td><td>600710</td><td class=tdred>常林股份</td><td>6.88</td><td class=tdred>10.08</td><td class=tdred>1.295</td><td>1.504</td><td>63.266</td>\t<td class=tdbgred>5522</td>\t<td class=tdred>8081</td>\t<td class=tdblue>-2559</td>\t<td class=tdred>-1725</td>\t<td class=tdred>-3796</td>\t<td class=tdbgred>23.04</td><td class=tdblue>-10.73</td><td class=tdred>19.2</td><td class=tdred>28.1</td><td>-8.9</td><td>-6.0</td><td class=tdred>-13.2</td><td bgcolor='#f0f0f0'>133</td><td>1.82</td><td>2.338</td><td>2.535</td><td>-0.815</td><td>-4.827</td><td>5</td><td>1</td><td class=tdred>-56988</td><td>689</td><td>4975</td><td>9046</td><td>86.8</td><td>47.7</td><td>6387</td><td>-8843</td><td>42.9</td><td>14.8</td><td>33.4</td><td>42.3</td><td>11.3</td><td>17.3</td><td>12.4</td><td>25.6</td><td>6.74</td><td>1.32</td><td>-36.86</td><td>-0.140</td><td>2015-3-30</td></tr><tr height='24'><td>2015-3-27</td><td>16:13</td><td>600710</td><td class=tdred>常林股份</td><td>6.25</td><td class=tdred>0.48</td><td class=tdblue>-0.131</td><td>-0.093</td><td>-5.035</td>\t<td class=tdbgblue>-532</td>\t<td class=tdblue>-1187</td>\t<td class=tdred>655</td>\t<td class=tdblue>246</td>\t<td class=tdblue>286</td>\t<td class=tdbgblue>-3.12</td><td class=tdblue>-6.33</td><td class=tdblue>-2.6</td><td class=tdblue>-5.8</td><td>3.2</td><td>1.2</td><td class=tdblue>1.4</td><td bgcolor='#f0f0f0'>123</td><td>.96</td><td>0.205</td><td>0.001</td><td>-4.275</td><td>-8.714</td><td>4</td><td>0</td><td class=tdblue>4522</td><td>477</td><td>6408</td><td>6159</td><td>50.4</td><td>52.4</td><td>6673</td><td>-9375</td><td>10.2</td><td>16.0</td><td>49.9</td><td>46.7</td><td>16.9</td><td>15.7</td><td>23.0</td><td>21.6</td><td>5.04</td><td>.98</td><td>-33.48</td><td>-0.140</td><td>2015-3-27</td></tr><tr height='24'><td>2015-3-26</td><td>16:12</td><td>600710</td><td class=tdred>常林股份</td><td>6.22</td><td class=tdred>2.98</td><td class=tdred>0.250</td><td>0.148</td><td>6.328</td>\t<td class=tdbgred>1004</td>\t<td class=tdred>1030</td>\t<td class=tdblue>-26</td>\t<td class=tdred>-238</td>\t<td class=tdred>-766</td>\t<td class=tdbgred>4.56</td><td class=tdred>9.04</td><td class=tdred>3.8</td><td class=tdred>3.9</td><td>-0.1</td><td>-0.9</td><td class=tdred>-2.9</td><td bgcolor='#f0f0f0'>100</td><td>1.05</td><td>0.635</td><td>0.233</td><td>-4.153</td><td>-8.821</td><td>4</td><td>2</td><td class=tdred>-12205</td><td>505</td><td>7611</td><td>8006</td><td>55.3</td><td>52.6</td><td>5907</td><td>-8371</td><td>12.7</td><td>8.8</td><td>39.1</td><td>39.2</td><td>15.5</td><td>16.4</td><td>32.7</td><td>35.6</td><td>6.57</td><td>1.37</td><td>-33.32</td><td>-0.140</td><td>2015-3-26</td></tr><tr height='24'><td>2015-3-25</td><td>16:12</td><td>600710</td><td class=tdred>常林股份</td><td>6.04</td><td class=tdred>0.33</td><td class=tdred>0.216</td><td>0.088</td><td>7.901</td>\t<td class=tdbgred>833</td>\t<td class=tdred>2434</td>\t<td class=tdblue>-1600</td>\t<td class=tdred>-550</td>\t<td class=tdred>-283</td>\t<td class=tdbgred>6.00</td><td class=tdred>5.29</td><td class=tdred>5</td><td class=tdred>14.6</td><td>-9.6</td><td>-3.3</td><td class=tdred>-1.7</td><td bgcolor='#f0f0f0'>122</td><td>1.05</td><td>0.328</td><td>-0.020</td><td>-4.802</td><td>-9.420</td><td>3</td><td>1</td><td class=tdred>-4708</td><td>405</td><td>4881</td><td>5118</td><td>56.7</td><td>54.1</td><td>5624</td><td>-7538</td><td>17.3</td><td>2.7</td><td>46.3</td><td>55.9</td><td>16.1</td><td>19.4</td><td>20.3</td><td>22.0</td><td>4.32</td><td>.9</td><td>-32.36</td><td>-0.140</td><td>2015-3-25</td></tr><tr height='24'><td>2015-3-24</td><td>16:12</td><td>600710</td><td class=tdblue>常林股份</td><td>6.02</td><td class=tdblue>-0.99</td><td class=tdblue>-0.083</td><td>-0.202</td><td>-6.179</td>\t<td class=tdbgblue>-320</td>\t<td class=tdred>400</td>\t<td class=tdblue>-721</td>\t<td class=tdblue>60</td>\t<td class=tdblue>260</td>\t<td class=tdbgblue>-1.92</td><td class=tdblue>-1.76</td><td class=tdblue>-1.6</td><td class=tdred>2.0</td><td>-3.6</td><td>0.3</td><td class=tdblue>1.3</td><td bgcolor='#f0f0f0'>86</td><td>.9</td><td>-0.049</td><td>-0.250</td><td>-5.404</td><td>-9.919</td><td>2</td><td>0</td><td class=tdblue>4324</td><td>343</td><td>5370</td><td>4829</td><td>61.9</td><td>68.9</td><td>5884</td><td>-7858</td><td>4.3</td><td>2.3</td><td>37.9</td><td>41.5</td><td>15.3</td><td>15.0</td><td>42.5</td><td>41.2</td><td>5.20</td><td>1.09</td><td>-32.25</td><td>-0.140</td><td>2015-3-24</td></tr><tr height='24'><td>2015-3-23</td><td>16:12</td><td>600710</td><td class=tdred>常林股份</td><td>6.08</td><td class=tdred>0.50</td><td class=tdblue>-0.216</td><td>-0.335</td><td>-14.239</td>\t<td class=tdbgblue>-838</td>\t<td class=tdblue>-33</td>\t<td class=tdblue>-806</td>\t<td class=tdblue>148</td>\t<td class=tdblue>691</td>\t<td class=tdbgblue>-6.12</td><td class=tdblue>-4.16</td><td class=tdblue>-5.1</td><td class=tdblue>-0.2</td><td>-4.9</td><td>0.9</td><td class=tdblue>4.2</td><td bgcolor='#f0f0f0'>100</td><td>.83</td><td>0.134</td><td>0.129</td><td>-5.418</td><td>-9.844</td><td>3</td><td>0</td><td class=tdblue>11379</td><td>325</td><td>5509</td><td>4593</td><td>49.2</td><td>59.0</td><td>6575</td><td>-8697</td><td>6.4</td><td>6.6</td><td>40.8</td><td>45.7</td><td>17.6</td><td>16.7</td><td>35.2</td><td>31.0</td><td>4.23</td><td>.89</td><td>-32.57</td><td>-0.140</td><td>2015-3-23</td></tr><tr height='24'><td>2015-3-20</td><td>16:12</td><td>600710</td><td class=tdred>常林股份</td><td>6.05</td><td class=tdred>3.42</td><td class=tdred>0.605</td><td>0.710</td><td>28.503</td>\t<td class=tdbgred>2329</td>\t<td class=tdred>602</td>\t<td class=tdred>1727</td>\t<td class=tdred>-462</td>\t<td class=tdred>-1868</td>\t<td class=tdbgred>13.92</td><td class=tdblue>-2.26</td><td class=tdred>11.6</td><td class=tdred>3.0</td><td>8.6</td><td>-2.3</td><td class=tdred>-9.3</td><td bgcolor='#f0f0f0'>112</td><td>1.34</td><td>0.741</td><td>1.033</td><td>-5.163</td><td>-9.496</td><td>4</td><td>1</td><td class=tdred>-31067</td><td>449</td><td>5744</td><td>7693</td><td>58.2</td><td>43.4</td><td>4707</td><td>-6367</td><td>8.8</td><td>5.8</td><td>53.2</td><td>44.6</td><td>18.6</td><td>20.9</td><td>19.4</td><td>28.7</td><td>5.22</td><td>1.3</td><td>-32.41</td><td>-0.140</td><td>2015-3-20</td></tr><tr height='24'><td>2015-3-19</td><td>16:13</td><td>600710</td><td class=tdblue>常林股份</td><td>5.85</td><td class=tdblue>-0.34</td><td class=tdblue>-0.318</td><td>-0.333</td><td>-14.914</td>\t<td class=tdbgblue>-1193</td>\t<td class=tdblue>-1247</td>\t<td class=tdred>54</td>\t<td class=tdblue>398</td>\t<td class=tdblue>795</td>\t<td class=tdbgblue>-7.92</td><td class=tdblue>-9.48</td><td class=tdblue>-6.6</td><td class=tdblue>-6.9</td><td>0.3</td><td>2.2</td><td class=tdblue>4.4</td><td bgcolor='#f0f0f0'>92</td><td>.84</td><td>-0.402</td><td>-0.226</td><td>-6.569</td><td>-11.262</td><td>3</td><td>0</td><td class=tdblue>13585</td><td>341</td><td>5547</td><td>4636</td><td>55.7</td><td>66.6</td><td>5502</td><td>-7560</td><td>2.2</td><td>9.1</td><td>40.3</td><td>40.0</td><td>17.4</td><td>15.2</td><td>40.1</td><td>35.7</td><td>4.82</td><td>1.41</td><td>-31.34</td><td>-0.140</td><td>2015-3-19</td></tr><tr height='24'><td>2015-3-18</td><td>16:27</td><td>600710</td><td class=tdred>常林股份</td><td>5.87</td><td class=tdred>2.98</td><td class=tdred>0.533</td><td>0.422</td><td>23.794</td>\t<td class=tdbgred>1989</td>\t<td class=tdred>1260</td>\t<td class=tdred>729</td>\t<td class=tdred>-746</td>\t<td class=tdred>-1243</td>\t<td class=tdbgred>14.40</td><td class=tdred>10.58</td><td class=tdred>12</td><td class=tdred>7.6</td><td>4.4</td><td>-4.5</td><td class=tdred>-7.5</td><td bgcolor='#f0f0f0'>104</td><td>1.25</td><td>1.081</td><td>1.195</td><td>-5.096</td><td>-10.137</td><td>5</td><td>1</td><td class=tdred>-21327</td><td>355</td><td>4526</td><td>5654</td><td>62.8</td><td>50.3</td><td>4259</td><td>-5570</td><td>9.5</td><td>1.9</td><td>48.4</td><td>44.0</td><td>13.4</td><td>17.9</td><td>28.7</td><td>36.2</td><td>4.44</td><td>1.3</td><td>-31.45</td><td>-0.140</td><td>2015-3-18</td></tr><tr height='24'><td>2015-3-17</td><td>16:13</td><td>600710</td><td class=tdred>常林股份</td><td>5.70</td><td class=tdred>3.64</td><td class=tdblue>-0.050</td><td>0.159</td><td>2.441</td>\t<td class=tdbgblue>-180</td>\t<td class=tdblue>-1061</td>\t<td class=tdred>881</td>\t<td class=tdblue>306</td>\t<td class=tdred>-126</td>\t<td class=tdbgblue>-1.20</td><td class=tdred>10.47</td><td class=tdblue>-1</td><td class=tdblue>-5.9</td><td>4.9</td><td>1.7</td><td class=tdred>-0.7</td><td bgcolor='#f0f0f0'>106</td><td>1.07</td><td>0.283</td><td>0.728</td><td>-6.685</td><td>-11.633</td><td>4</td><td>0</td><td class=tdred>-2227</td><td>405</td><td>6512</td><td>6947</td><td>48.9</td><td>45.8</td><td>4133</td><td>-5750</td><td>1.5</td><td>7.4</td><td>51.2</td><td>46.3</td><td>21.5</td><td>19.8</td><td>25.8</td><td>26.5</td><td>4.97</td><td>2.04</td><td>-30.54</td><td>-0.140</td><td>2015-3-17</td></tr><tr height='24'><td>2015-3-16</td><td>16:13</td><td>600710</td><td class=tdred>常林股份</td><td>5.50</td><td class=tdred>3.77</td><td class=tdred>0.408</td><td>0.554</td><td>28.421</td>\t<td class=tdbgred>1422</td>\t<td class=tdblue>-1070</td>\t<td class=tdred>2492</td>\t<td class=tdred>-225</td>\t<td class=tdred>-1197</td>\t<td class=tdbgred>12.12</td><td class=tdred>6.97</td><td class=tdred>10.1</td><td class=tdblue>-7.6</td><td>17.7</td><td>-1.6</td><td class=tdred>-8.5</td><td bgcolor='#f0f0f0'>117</td><td>1.36</td><td>0.549</td><td>0.694</td><td>-6.811</td><td>-12.351</td><td>4</td><td>0</td><td class=tdred>-21967</td><td>363</td><td>4237</td><td>5749</td><td>61.0</td><td>45.0</td><td>2936</td><td>-4328</td><td>1.6</td><td>9.2</td><td>61.8</td><td>44.1</td><td>17.8</td><td>19.4</td><td>18.8</td><td>27.3</td><td>4.04</td><td>1.97</td><td>-29.46</td><td>-0.140</td><td>2015-3-16</td></tr><tr height='24'><td>2015-3-13</td><td>16:12</td><td>600710</td><td class=tdred>常林股份</td><td>5.30</td><td class=tdred>0.76</td><td class=tdblue>-0.010</td><td>0.019</td><td>0.965</td>\t<td class=tdbgblue>-34</td>\t<td class=tdblue>-107</td>\t<td class=tdred>73</td>\t<td class=tdblue>146</td>\t<td class=tdred>-113</td>\t<td class=tdbgblue>-0.72</td><td class=tdblue>-5.18</td><td class=tdblue>-.6</td><td class=tdblue>-1.9</td><td>1.3</td><td>2.6</td><td class=tdred>-2.0</td><td bgcolor='#f0f0f0'>116</td><td>1.03</td><td>-0.195</td><td>-0.343</td><td>-7.871</td><td>-13.896</td><td>3</td><td>0</td><td class=tdred>-2130</td><td>148</td><td>1898</td><td>1950</td><td>56.1</td><td>54.6</td><td>2824</td><td>-4362</td><td>0.0</td><td>1.9</td><td>57.6</td><td>56.3</td><td>21.1</td><td>18.5</td><td>21.3</td><td>23.3</td><td>1.66</td><td>.71</td><td>-28.39</td><td>-0.140</td><td>2015-3-13</td></tr><tr height='24'><td>2015-3-12</td><td>16:13</td><td>600710</td><td class=tdred>常林股份</td><td>5.26</td><td class=tdred>0.38</td><td class=tdblue>-0.033</td><td>-0.051</td><td>-4.941</td>\t<td class=tdbgblue>-111</td>\t<td class=tdred>334</td>\t<td class=tdblue>-445</td>\t<td class=tdblue>31</td>\t<td class=tdblue>80</td>\t<td class=tdbgblue>-2.16</td><td class=tdblue>-3.48</td><td class=tdblue>-1.8</td><td class=tdred>5.4</td><td>-7.2</td><td>0.5</td><td class=tdblue>1.3</td><td bgcolor='#f0f0f0'>104</td><td>.94</td><td>-0.268</td><td>-0.562</td><td>-8.117</td><td>-14.405</td><td>3</td><td>0</td><td class=tdblue>1522</td><td>146</td><td>2382</td><td>2242</td><td>49.2</td><td>52.2</td><td>2904</td><td>-4473</td><td>7.4</td><td>2.0</td><td>43.5</td><td>50.7</td><td>23.0</td><td>22.5</td><td>26.1</td><td>24.8</td><td>1.83</td><td>.78</td><td>-28.18</td><td>-0.140</td><td>2015-3-12</td></tr><tr height='24'><td>2015-3-11</td><td>16:12</td><td>600710</td><td class=tdblue>常林股份</td><td>5.24</td><td class=tdblue>-1.87</td><td class=tdblue>-0.195</td><td>-0.379</td><td>-30.456</td>\t<td class=tdbgblue>-656</td>\t<td class=tdblue>-303</td>\t<td class=tdblue>-353</td>\t<td class=tdblue>14</td>\t<td class=tdblue>642</td>\t<td class=tdbgblue>-11.16</td><td class=tdblue>-28.1</td><td class=tdblue>-9.3</td><td class=tdblue>-4.3</td><td>-5.0</td><td>0.2</td><td class=tdblue>9.1</td><td bgcolor='#f0f0f0'>108</td><td>.69</td><td>-0.320</td><td>-0.714</td><td>-8.326</td><td>-14.789</td><td>3</td><td>0</td><td class=tdblue>12198</td><td>174</td><td>3280</td><td>2247</td><td>40.9</td><td>59.7</td><td>3546</td><td>-5129</td><td>1.6</td><td>5.9</td><td>47.5</td><td>52.5</td><td>20.4</td><td>20.2</td><td>30.5</td><td>21.4</td><td>2.09</td><td>.88</td><td>-28.07</td><td>-0.140</td><td>2015-3-11</td></tr><tr height='24'><td>2015-3-10</td><td>15:3</td><td>600710</td><td class=tdred>常林股份</td><td>5.34</td><td class=tdred>0.38</td><td class=tdred>0.025</td><td>-0.036</td><td>-0.812</td>\t<td class=tdbgred>85</td>\t<td class=tdred>67</td>\t<td class=tdred>18</td>\t<td class=tdred>-67</td>\t<td class=tdred>-18</td>\t<td class=tdbgred>1.68</td><td class=tdblue>-16.33</td><td class=tdred>1.4</td><td class=tdred>1.1</td><td>0.3</td><td>-1.1</td><td class=tdred>-0.3</td><td bgcolor='#f0f0f0'>105</td><td>.96</td><td>0.046</td><td>-0.156</td><td>-7.901</td><td>-14.124</td><td>4</td><td>2</td><td class=tdred>-342</td><td>144</td><td>2395</td><td>2296</td><td>47.6</td><td>49.7</td><td>3528</td><td>-5044</td><td>3.7</td><td>2.6</td><td>49.4</td><td>49.1</td><td>20.5</td><td>21.6</td><td>26.4</td><td>26.7</td><td>1.78</td><td>.75</td><td>-28.61</td><td>-0.140</td><td>2015-3-10</td></tr><tr height='24'><td>2015-3-9</td><td>16:12</td><td>600710</td><td class=tdblue>常林股份</td><td>5.32</td><td class=tdblue>-1.66</td><td class=tdred>0.012</td><td>-0.018</td><td>-0.305</td>\t<td class=tdbgred>42</td>\t<td class=tdblue>-428</td>\t<td class=tdred>470</td>\t<td class=tdred>-176</td>\t<td class=tdblue>134</td>\t<td class=tdbgred>0.60</td><td class=tdblue>-10.14</td><td class=tdred>.5</td><td class=tdblue>-5.1</td><td>5.6</td><td>-2.1</td><td class=tdblue>1.6</td><td bgcolor='#f0f0f0'>109</td><td>.99</td><td>0.007</td><td>-0.124</td><td>-8.212</td><td>-14.520</td><td>4</td><td>1</td><td class=tdblue>2541</td><td>208</td><td>3401</td><td>3351</td><td>46.7</td><td>47.4</td><td>3662</td><td>-5002</td><td>1.3</td><td>6.4</td><td>53.3</td><td>47.7</td><td>18.5</td><td>20.6</td><td>26.9</td><td>25.3</td><td>2.48</td><td>1.01</td><td>-28.50</td><td>-0.140</td><td>2015-3-9</td></tr><tr height='24'><td>2015-3-6</td><td>16:12</td><td>600710</td><td class=tdblue>常林股份</td><td>5.41</td><td class=tdblue>-0.55</td><td class=tdblue>-0.073</td><td>-0.127</td><td>-10.000</td>\t<td class=tdbgblue>-253</td>\t<td class=tdblue>-498</td>\t<td class=tdred>245</td>\t<td class=tdblue>0</td>\t<td class=tdblue>253</td>\t<td class=tdbgblue>-4.20</td><td class=tdblue>-9.88</td><td class=tdblue>-3.5</td><td class=tdblue>-6.9</td><td>3.4</td><td>0.0</td><td class=tdblue>3.5</td><td bgcolor='#f0f0f0'>104</td><td>.88</td><td>-0.021</td><td>-0.141</td><td>-8.515</td><td>-14.975</td><td>3</td><td>0</td><td class=tdblue>4692</td><td>167</td><td>2957</td><td>2612</td><td>45.3</td><td>51.3</td><td>3915</td><td>-5255</td><td>1.7</td><td>8.6</td><td>48.7</td><td>45.3</td><td>20.4</td><td>20.4</td><td>29.2</td><td>25.7</td><td>2.09</td><td>.83</td><td>-28.98</td><td>-0.140</td><td>2015-3-6</td></tr>\n" +
            "<tr bgcolor=\"#BA3E3C\">\n" +
            "<td width=\"70\">日期</td>\n" +
            "<td width=\"40\">更新<br>时间</td>\n" +
            "<td width=\"50\">股票<br>代码</td>\n" +
            "<td width=\"80\">股票名称</td>\n" +
            "<td width=\"40\">最新</td>\n" +
            "<td width=\"40\">涨幅</td>\n" +
            "<td width=\"45\">ddx</td>\n" +
            "<td width=\"45\">ddy</td>\n" +
            "<td  width=\"55\">ddz</td>\n" +
            "<td width=\"50\" >净额<br>(万元)<br></td>\n" +
            "<td width=\"40\" >特大<br>差量</td>\n" +
            "<td width=\"40\"  >大单<br>差量</td>\n" +
            "<td width=\"40\" >中单<br>差量</td>\n" +
            "<td width=\"40\">小单<br>差量</td>\n" +
            "<td width=\"40\" >强度<br></td>\n" +
            "<td width=\"40\">主动<br>率%</td>\n" +
            "<td width=\"40\">通吃<br>率%</td>\n" +
            "<td width=\"30\">特大<br>差%</td>\n" +
            "<td width=\"30\">大单<br>差%</td>\n" +
            "<td width=\"30\">中单<br>差%</td>\n" +
            "<td width=\"30\">小单<br>差%</td>\n" +
            "<td width=\"30\">活跃<br>度</td>\n" +
            "<td width=\"30\">单数<br>比</td>\n" +
            "<td width=\"45\">5日<br>ddx</td>\n" +
            "<td width=\"45\">5日<br>ddy</td>\n" +
            "<td width=\"45\">60日<br>ddx</td>\n" +
            "<td width=\"45\">60日<br>ddy</td>\n" +
            "<td width=\"18\">次</td>\n" +
            "<td width=\"18\">连</td>\n" +
            "<td width=\"40\">小单<br>差手</td>\n" +
            "<td width=\"40\">资金<br>强度</td>\n" +
            "<td width=\"40\">买入<br>单数</td>\n" +
            "<td width=\"40\">卖出<br>单数</td>\n" +
            "<td width=\"40\">买单<br>均手</td>\n" +
            "<td width=\"40\">卖单<br>均手</td>\n" +
            "<td width=\"40\">小单<br>累计</td>\n" +
            "<td width=\"60\">净额<br>累计</td>\n" +
            "<td width=\"30\">特大<br>买入</td>\n" +
            "<td width=\"30\">特大<br>卖出</td>\n" +
            "<td width=\"30\">大单<br>买入</td>\n" +
            "<td width=\"30\">大单<br>卖出</td>\n" +
            "<td width=\"30\">中单<br>买入</td>\n" +
            "<td width=\"30\">中单<br>卖出</td>\n" +
            "<td width=\"30\">小单<br>买入</td>\n" +
            "<td width=\"30\">小单<br>卖出</td>\n" +
            "<td width=\"40\">换手<br>率%</td>\n" +
            "<td width=\"40\">量比</td>\n" +
            "<td width=\"50\">市盈<br>率</td>\n" +
            "<td width=\"40\">每股<br>收益</td>\n" +
            "<td width=\"70\">日期</td>\n" +
            "</tr></table>\n" +
            "</div>\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "\t\t\n" +
            "\t</td>\n" +
            "</tr>\t\n" +
            "</table>\n" +
            "\n" +
            "<table class=\"tb2td1\" width=\"1140\" align=\"center\" id=\"table1\" cellpadding=\"0\" bordercolor=\"#BA3E3C\" bordercolorlight=\"#BA3E3C\" bordercolordark=\"#BA3E3C\" cellspacing=\"0\" style=\"border-collapse: collapse\">\n" +
            "\t<tr>\n" +
            "\t\t<td>\n" +
            "<script type=\"text/javascript\">BAIDU_CLB_fillSlot(\"914605\");</script>\n" +
            "\t\t\t</td>\n" +
            "\t</tr>\n" +
            "</table>\n" +
            "\n" +
            "\n" +
            "\n" +
            "<table class=\"tb2td1\" width=\"1140\" align=\"center\" id=\"table1\" cellpadding=\"0\" bordercolor=\"#BA3E3C\" bordercolorlight=\"#BA3E3C\" bordercolordark=\"#BA3E3C\" cellspacing=\"0\" style=\"border-collapse: collapse\">\n" +
            "\t<tr><td>\n" +
            "<table border=\"0\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" >\n" +
            "<tr bgcolor=\"#BA3E3C\" height=\"30\">\n" +
            "<td class=td1align=\"center\" colspan=\"2\"><b>常林股份实时走势图+日K线图</b>&nbsp;<a class=ahs2 href=\"javascript:location.reload()\">【手工刷新】</a></td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td width=\"520\">\n" +
            "<iframe marginwidth=\"0\" marginheight=\"0\"  frameborder=\"0\" bordercolor=\"#000000\" scrolling=\"no\" src=\"http://image2.sinajs.cn/newchart/min/n/sh600710.gif\" width=\"545\" height=\"314\"></iframe>\n" +
            "</td>\n" +
            "<td  width=\"520\">\n" +
            "<iframe marginwidth=\"0\" marginheight=\"0\"  frameborder=\"0\" bordercolor=\"#000000\" scrolling=\"no\" src=\"http://image2.sinajs.cn/newchart/daily/n/sh600710.gif\" width=\"545\" height=\"314\"></iframe>\n" +
            "</td></tr>\n" +
            "</table>\n" +
            "</td></tr></table>\n" +
            "<table border=\"0\" id=\"changejj\" cellspacing=\"0\" cellpadding=\"0\" height=\"2\">\n" +
            "\t<tr>\n" +
            "\t\t<td></td>\n" +
            "\t</tr>\n" +
            "</table>\n" +
            "\n" +
            "\n" +
            "<table><tr><td>\n" +
            "<a target=\"_blank\" href=\"http://www.miibeian.gov.cn\">赣ICP备13006910号</a>\n" +
            "[散户大家庭官方网站:www.shdjt.com] <a href=\"http://b.shdjt.com/dispbbs.asp?boardid=3&Id=62102\"><img border=\"0\" src=\"images/qq.gif\">联系我们</a><br>\n" +
            "<b>本站 所有广告请用户自行辨别，本站不负任何连带责任。</b><br>\n" +
            "Copyright 2014-2015 shdjt Corporation, All Rights Reserved\n" +
            "<script type=\"text/javascript\">\n" +
            "var _bdhmProtocol = ((\"https:\" == document.location.protocol) ? \" https://\" : \" http://\");\n" +
            "document.write(unescape(\"%3Cscript src='\" + _bdhmProtocol + \"hm.baidu.com/h.js%3Fc63de846e8823f696db1d63ebb9065f3' type='text/javascript'%3E%3C/script%3E\"));\n" +
            "</script>\n" +
            "\n" +
            "<script language=\"javascript\" type=\"text/javascript\" src=\"http://js.users.51.la/1827762.js\"></script>\n" +
            "<noscript><a href=\"http://www.51.la/?1827762\" target=\"_blank\"><img alt=\"&#x6211;&#x8981;&#x5566;&#x514D;&#x8D39;&#x7EDF;&#x8BA1;\" src=\"http://img.users.51.la/1827762.asp\" style=\"border:none\" /></a></noscript>\n" +
            "<script language=\"javascript\" type=\"text/javascript\" src=\"http://js.users.51.la/3398878.js\"></script>\n" +
            "<noscript><a href=\"http://www.51.la/?3398878\" target=\"_blank\"><img alt=\"&#x6211;&#x8981;&#x5566;&#x514D;&#x8D39;&#x7EDF;&#x8BA1;\" src=\"http://img.users.51.la/3398878.asp\" style=\"border:none\" /></a></noscript>\n" +
            "\n" +
            "</td></tr></table>\n" +
            "</div>\n" +
            "\n" +
            "</body>\n" +
            "</html> \n";
}
