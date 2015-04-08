import com.douglas.stock.common.Record;
import com.douglas.stock.crawler.pageprocess.shdjt.GeguPageProcess;

import java.util.List;

/**
 * Created by wgz on 15/3/31.
 */
public class TestShdjtPageProcessor {
    public static void main(String[] args) {
        GeguPageProcess pageProcess = new GeguPageProcess();
        List<Record> records = pageProcess.processHtml(html);
        for (Record record : records) {
            for (Float field : record.getFields()) {
                System.out.println(field);
            }
        }
        return;
    }

    public final static String html = "\n" +
            "\n" +
            "\n" +
            "\n" +
            "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
            "<html>\n" +
            "<head>\n" +
            "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\">\n" +
            "<meta name=\"GENERATOR\" content=\"Microsoft FrontPage 4.0\">\n" +
            "<meta name=\"ProgId\" content=\"FrontPage.Editor.Document\">\n" +
            "\n" +
            "<meta name=\"description\" content=\"新钢股份.600782_个股_资金流向(多日)_散户大家庭\">\n" +
            "<meta name=\"keywords\" content=\"新钢股份,600782,资金流,dde,小单差,单数比\">\n" +
            "<title>新钢股份.600782_个股_资金流向(多日)_散户大家庭</title>\n" +
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
            "\t\t<td><font color='#d17270'><b>我的最近查询:</b></font> <a href='gpdm.asp?gpdm=600782'><font color='#d17270'>新钢股份</font></a> <a href='gpdm.asp?gpdm=000596'><font color='#d17270'>古井贡酒</font></a> <a href='gpdm.asp?gpdm=000020'><font color='#d17270'>深华发A</font></a> <a href='gpdm.asp?gpdm=000001'><font color='#d17270'>平安银行</font></a> <a href='gpdm.asp?gpdm=000667'><font color='#d17270'>美好集团</font></a> <a href='gpdm.asp?gpdm=300315'><font color='#d17270'>掌趣科技</font></a> <a href='gpdm.asp?gpdm=993597'><font color='#d17270'>[智能电网]</font></a> <a href='gpdm.asp?gpdm=993952'><font color='#d17270'>[充电桩]</font></a> <a href='gpdm.asp?gpdm=600710'><font color='#d17270'>常林股份</font></a> <a href='gpdm.asp?gpdm=600500'><font color='#d17270'>中化国际</font></a> <a href='gpdm.asp?gpdm=993064'><font color='#d17270'>[医疗器械]</font></a> <a href='gpdm.asp?gpdm=600608'><font color='#d17270'>上海科技</font></a> <a href='gpdm.asp?gpdm=603020'><font color='#d17270'>爱普股份</font></a> <a href='gpdm.asp?gpdm=600029'><font color='#d17270'>南方航空</font></a> <a href='gpdm.asp?gpdm=600122'><font color='#d17270'>宏图高科</font></a></td>\n" +
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
            "<td class=tdhelp  colspan=\"3\">&nbsp;<b>新钢股份.600782:最新股票新闻</b> &nbsp;<a target=\"_blank\" href='http://news.shdjt.com/newsgpdm.asp?gpdm=600782'>更多新钢股份新闻…</a></td>\n" +
            "</tr>\n" +
            "<tr height='25'><td class=tdleft><a class=\"anews\" target=\"_blank\" href='http://news.shdjt.com/gpnews.asp?newsid=600782-20150108194326'>[1].新余两大支柱性产业没落麻纺升级有望成新增长点</a>&nbsp;<font color=\"c0c0c0\">2015-1-9</font></td><td class=tdleft><a class=\"anews\" target=\"_blank\" href='http://news.shdjt.com/gpnews.asp?newsid=600782-20150108182230'>[2].新余两大支柱产业没落麻纺升级有望成新增长点</a>&nbsp;<font color=\"c0c0c0\">2015-1-9</font></td><td class=tdleft><a class=\"anews\" target=\"_blank\" href='http://news.shdjt.com/gpnews.asp?newsid=600782-20141208185615'>[3].新余钢铁股份有限公司关于董事会秘书辞职的公告</a>&nbsp;<font color=\"c0c0c0\">2015-1-9</font></td></tr><tr height='25'><td class=tdleft><a class=\"anews\" target=\"_blank\" href='http://news.shdjt.com/gpnews.asp?newsid=600782-20141121064500'>[4].(江西)新余钢铁股份公司筛网等配件招标公告</a>&nbsp;<font color=\"c0c0c0\">2014-11-21</font></td><td class=tdleft><a class=\"anews\" target=\"_blank\" href='http://news.shdjt.com/gpnews.asp?newsid=600782-20141119012810'>[5].账户多股票多一不小心买过了头</a>&nbsp;<font color=\"c0c0c0\">2014-11-21</font></td><td class=tdleft><a class=\"anews\" target=\"_blank\" href='http://news.shdjt.com/gpnews.asp?newsid=600782-20141106070535'>[6].周五机构一致最看好的10金股</a>&nbsp;<font color=\"c0c0c0\">2014-11-21</font></td></tr><tr height='25'><td class=tdleft><a class=\"anews\" target=\"_blank\" href='http://news.shdjt.com/gpnews.asp?newsid=600782-20141102231558'>[7].冀t8888的车_冀d是哪的车_冀r是哪的车_冀b是哪的车</a>&nbsp;<font color=\"c0c0c0\">2014-11-3</font></td><td class=tdleft><a class=\"anews\" target=\"_blank\" href='http://news.shdjt.com/gpnews.asp?newsid=600782-20141028001115'>[8].江西厅官预感苏荣要出事借口赝品向其妻讨名画</a>&nbsp;<font color=\"c0c0c0\">2014-11-3</font></td><td class=tdleft><a class=\"anews\" target=\"_blank\" href='http://news.shdjt.com/gpnews.asp?newsid=600782-20141027225230'>[9].李安泽被指不干正事：主政时干部不敢喝自来水</a>&nbsp;<font color=\"c0c0c0\">2014-11-3</font></td></tr>\n" +
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
            "&nbsp;<b>新钢股份.600782:每天的dde资金流指标</b> &nbsp;<a class=ahs2 href=\"javascript:location.reload()\">【手工刷新下方数据】</a>\n" +
            "\n" +
            "<input class=input2 style=\"width:170px;\"  onclick=\"javascript:document.getElementById('zxgid').src='zxg_cz.asp?cz=add&gpdm=600782'\" type=\"button\" value=\"添加.新钢股份.到自选股\" name=\"B1\">\n" +
            "\n" +
            "<input class=input2 onclick=\"location.href='zxg.asp'\" type=\"button\" style=\"width:100px;\"  value=\"我的自选股\" name=\"B1\">\n" +
            "\n" +
            "<input class=input3 style=\"width:70px;\" onclick=\"location.href='setwidth.asp?w=2&url=http://www.shdjt.com/gpdm.asp?gpdm=600782'\"  type=\"button\" value=\"切:宽表格\" name=\"B1\">\n" +
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
            "\t\t<td class=tdleft1>新钢股份：\n" +
            "<a class=\"ak\" title=\"新钢股份分时ddx资金流\" href=\"gpdmfs.asp?gpdm=600782\"><img border=\"0\" src=\"images/1.png\" align=\"texttop\"> 分时ddx</a>\n" +
            "<a class=\"ak\" title=\"新钢股份分日dde资金流趋势图\" href=\"gpdm_p.asp?gpdm=600782\"><img border=\"0\" src=\"images/2.png\" align=\"texttop\">  分日dde资金流.图 </a>\n" +
            "\n" +
            "<a target=\"_blank\" class=\"ak\" title=\"新钢股份专家点评\"  href=\"http://qgqp.shdjt.com/gpdm.asp?gpdm=600782\"><img border=\"0\" src=\"images/3.png\" align=\"texttop\"> 专家点评</a>\n" +
            "<a target=\"_blank\" class=\"ak\" title=\"新钢股份相关新闻\"  href=\"http://news.shdjt.com/newsgpdm.asp?gpdm=600782\"><img border=\"0\" src=\"images/4.png\" align=\"texttop\"> 新闻…</a>\n" +
            "\n" +
            "<a target=\"_blank\" class=\"ak\" title=\"新钢股份十大股东\"  href=\"http://cwzx.shdjt.com/gpdmgd.asp?gpdm=600782\"><img border=\"0\" src=\"images/5.png\" align=\"texttop\"> 十大股东</a>\n" +
            "<a target=\"_blank\" class=\"ak\" title=\"新钢股份异动坐席\" href=\"http://lhb.shdjt.com/gpdm.asp?gpdm=600782\"><img border=\"0\" src=\"images/6.png\" align=\"texttop\"> 异动坐席</a>\n" +
            "\n" +
            "</td>\n" +
            "\t</tr> \n" +
            "<tr height=\"25\">\n" +
            "<td class=tdhsleft>\n" +
            "<font color=\"BA3E3C\">历史数据：</font>[<a  class=azs href=\"gpdm.asp?page=1&gpdm=600782\">1</a>]\n" +
            "[<a  class=azs href=\"gpdm.asp?page=2&gpdm=600782\">2</a>]\n" +
            "[<a  class=azs href=\"gpdm.asp?page=3&gpdm=600782\">3</a>]\n" +
            "[<a  class=azs href=\"gpdm.asp?page=4&gpdm=600782\">4</a>]\n" +
            "[<a  class=azs href=\"gpdm.asp?page=5&gpdm=600782\">5</a>]\n" +
            "[<a  class=azs href=\"gpdm.asp?page=6&gpdm=600782\">6</a>]\n" +
            "[<a  class=azs href=\"gpdm.asp?page=7&gpdm=600782\">7</a>]\n" +
            "[<a  class=azs href=\"gpdm.asp?page=8&gpdm=600782\">8</a>]\n" +
            "[<a  class=azs href=\"gpdm.asp?page=9&gpdm=600782\">9</a>]\n" +
            "[<a  class=azs href=\"gpdm.asp?page=10&gpdm=600782\">10</a>]\n" +
            "[<a  class=azs href=\"gpdm.asp?page=11&gpdm=600782\">11</a>]\n" +
            "[<a  class=azs href=\"gpdm.asp?page=12&gpdm=600782\">12</a>]\n" +
            "[<a  class=azs href=\"gpdm.asp?page=13&gpdm=600782\">13</a>]\n" +
            "[<a  class=azs href=\"gpdm.asp?page=14&gpdm=600782\">14</a>]\n" +
            "[<a  class=azs href=\"gpdm.asp?page=15&gpdm=600782\">15</a>]\n" +
            "\n" +
            "\t\t\t</td>\n" +
            "\t</tr>\n" +
            "\n" +
            "<tr height=\"25\">\n" +
            "<td class=tdhsleft>\n" +
            "<font color='#737373'>相关板块概念：</font><a class='anews' target='_blank' href='flsort.asp?lb=991009'>钢铁<font color='9a9a9a'>[0.44%]</font></a>　<a class='anews' target='_blank' href='flsort.asp?lb=993386'>预盈预增<font color='9a9a9a'>[1.92%]</font></a>　<a class='anews' target='_blank' href='flsort.asp?lb=993613'>鄱阳湖<font color='9a9a9a'>[0.33%]</font></a><br><font color='#737373'>微主题：</font><a class='anews1' target='_blank' href='zt.asp?lb=%B8%D6%CC%FA%28%D6%D8%D7%E9%29'>钢铁(重组) <a class='anews1' target='_blank' href='zt.asp?lb=炼钢业'>炼钢业 <a class='anews1' target='_blank' href='zt.asp?lb=铁矿石资源'>铁矿石资源\n" +
            "</td>\n" +
            "</tr>\n" +
            "\n" +
            "<tr height=\"25\">\n" +
            "<td class=tdleft>\n" +
            "\t<font color=\"#CD6765\">\n" +
            "『今日数据』 最新:7.24(0.28%)　最高:7.31(1.25%)　最低:7.17(-0.69%)　日震幅:1.94%　流通市值:100.89亿元　流通股:13.93亿股　市盈率:54.3　每股收益:0.100<br>『多日统计』 3日震幅:3.56%　3日涨幅:-.82%　周涨幅:2.12%　月涨幅:11.71%　半年涨幅:85.9%　年涨幅:126.56%\n" +
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
            "<tr height='30'><td>2015-4-2</td><td>11:31</td><td>600782</td><td class=tdleft><a class=ared target='_blank' href='gpdm.asp?gpdm=600782'>新钢股份</a> <font color='#cc99ff'>金属材料</font><br><a target='_blank' title='新钢股份分时ddx资金流' class=ahs3 href='gpdmfs.asp?gpdm=600782'>分</a>.<a class=ahs3 target='_blank' title='新钢股份分日dde资金流' href='gpdm.asp?gpdm=600782'>日</a>.<a class=ahs3 target='_blank' title='新钢股份分日dde资金流趋势图' href='gpdm_p.asp?gpdm=600782'>图</a>.<a class=ahs3 title='新钢股份专家点评' target='_blank' href='http://qgqp.shdjt.com/gpdm.asp?gpdm=600782'>评</a>.<a class=ahs3 title='新钢股份异动坐席' target='_blank' href='http://lhb.shdjt.com/gpdm.asp?gpdm=600782'>异</a>.<a class=ahs3 title='新钢股份相关新闻' target='_blank' href='http://news.shdjt.com/newsgpdm.asp?gpdm=600782'>闻</a>.<a class=ahs3 title='新钢股份十大股东' target='_blank' href='http://cwzx.shdjt.com/gpdmgd.asp?gpdm=600782'>东</a></td><td>7.24</td><td class=tdred>0.28</td><td class=tdblue>-0.018</td><td>0.031</td><td>3.192</td>\t<td class=tdbgblue>-210</td>\t<td class=tdred>343</td>\t<td class=tdblue>-553</td>\t<td class=tdblue>51</td>\t<td class=tdblue>159</td>\t<td class=tdbgblue>-3.96</td><td class=tdred>4.94</td><td class=tdblue>-3.3</td><td class=tdred>5.4</td><td>-8.7</td><td>0.8</td><td class=tdblue>2.5</td><td bgcolor='#f0f0f0'>122</td><td>1.1</td><td>-0.226</td><td>-0.465</td><td>-3.313</td><td>-4.222</td><td>3</td><td>0</td><td class=tdblue>2196</td><td>129</td><td>2245</td><td>2477</td><td>39.1</td><td>35.5</td><td>159</td><td>-210</td><td>12.5</td><td>7.1</td><td>46.8</td><td>55.5</td><td>18.4</td><td>17.6</td><td>22.3</td><td>19.8</td><td>0.63</td><td>1.16</td><td>54.30</td><td>0.100</td><td>2015-4-2</td></tr><tr height='24'><td>2014-4-17</td><td>16:38</td><td>600782</td><td class=tdred>新钢股份</td><td>0.00</td><td class=tdred>0.00</td><td class=tdred>0.000</td><td>0.000</td><td>0.000</td>\t<td class=tdbgblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdbgred>0.00</td><td class=tdred></td><td class=tdred>0</td><td class=tdblue>0.0</td><td>0.0</td><td>0.0</td><td class=tdblue>0.0</td><td bgcolor='#f0f0f0'>0</td><td>0</td><td>0.000</td><td>0.000</td><td>0.000</td><td>0.000</td><td>0</td><td>0</td><td class=tdblue>0</td><td>0</td><td>0</td><td>0</td><td>0.0</td><td>0.0</td><td>0</td><td>0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.00</td><td>0</td><td>-20.50③</td><td>-0.120</td><td>2014-4-17</td></tr><tr height='24'><td>2014-4-16</td><td>16:12</td><td>600782</td><td class=tdred>新钢股份</td><td>0.00</td><td class=tdred>0.00</td><td class=tdred>0.000</td><td>0.000</td><td>0.000</td>\t<td class=tdbgblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdbgred>0.00</td><td class=tdred></td><td class=tdred>0</td><td class=tdblue>0.0</td><td>0.0</td><td>0.0</td><td class=tdblue>0.0</td><td bgcolor='#f0f0f0'>0</td><td>0</td><td>0.000</td><td>0.000</td><td>0.000</td><td>0.000</td><td>0</td><td>0</td><td class=tdblue>0</td><td>0</td><td>0</td><td>0</td><td>0.0</td><td>0.0</td><td>0</td><td>0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.00</td><td>0</td><td>-20.50③</td><td>-0.120</td><td>2014-4-16</td></tr><tr height='24'><td>2014-4-15</td><td>16:38</td><td>600782</td><td class=tdred>新钢股份</td><td>0.00</td><td class=tdred>0.00</td><td class=tdred>0.000</td><td>0.000</td><td>0.000</td>\t<td class=tdbgblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdbgred>0.00</td><td class=tdred></td><td class=tdred>0</td><td class=tdblue>0.0</td><td>0.0</td><td>0.0</td><td class=tdblue>0.0</td><td bgcolor='#f0f0f0'>0</td><td>0</td><td>0.000</td><td>0.000</td><td>0.000</td><td>0.000</td><td>0</td><td>0</td><td class=tdblue>0</td><td>0</td><td>0</td><td>0</td><td>0.0</td><td>0.0</td><td>0</td><td>0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.00</td><td>0</td><td>-20.50③</td><td>-0.120</td><td>2014-4-15</td></tr><tr height='24'><td>2014-4-14</td><td>16:12</td><td>600782</td><td class=tdred>新钢股份</td><td>0.00</td><td class=tdred>0.00</td><td class=tdred>0.000</td><td>0.000</td><td>0.000</td>\t<td class=tdbgblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdbgred>0.00</td><td class=tdred></td><td class=tdred>0</td><td class=tdblue>0.0</td><td>0.0</td><td>0.0</td><td class=tdblue>0.0</td><td bgcolor='#f0f0f0'>0</td><td>0</td><td>0.000</td><td>0.000</td><td>0.000</td><td>0.000</td><td>0</td><td>0</td><td class=tdblue>0</td><td>0</td><td>0</td><td>0</td><td>0.0</td><td>0.0</td><td>0</td><td>0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.00</td><td>0</td><td>-20.50③</td><td>-0.120</td><td>2014-4-14</td></tr><tr height='24'><td>2014-4-11</td><td>16:12</td><td>600782</td><td class=tdred>新钢股份</td><td>0.00</td><td class=tdred>0.00</td><td class=tdred>0.000</td><td>0.000</td><td>0.000</td>\t<td class=tdbgblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdbgred>0.00</td><td class=tdred></td><td class=tdred>0</td><td class=tdblue>0.0</td><td>0.0</td><td>0.0</td><td class=tdblue>0.0</td><td bgcolor='#f0f0f0'>0</td><td>0</td><td>0.000</td><td>0.000</td><td>0.000</td><td>0.000</td><td>0</td><td>0</td><td class=tdblue>0</td><td>0</td><td>0</td><td>0</td><td>0.0</td><td>0.0</td><td>0</td><td>0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.00</td><td>0</td><td>-20.50③</td><td>-0.120</td><td>2014-4-11</td></tr><tr height='24'><td>2014-4-10</td><td>16:12</td><td>600782</td><td class=tdred>新钢股份</td><td>0.00</td><td class=tdred>0.00</td><td class=tdred>0.000</td><td>0.000</td><td>0.000</td>\t<td class=tdbgblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdbgred>0.00</td><td class=tdred></td><td class=tdred>0</td><td class=tdblue>0.0</td><td>0.0</td><td>0.0</td><td class=tdblue>0.0</td><td bgcolor='#f0f0f0'>0</td><td>0</td><td>0.000</td><td>0.000</td><td>0.000</td><td>0.000</td><td>0</td><td>0</td><td class=tdblue>0</td><td>0</td><td>0</td><td>0</td><td>0.0</td><td>0.0</td><td>0</td><td>0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.00</td><td>0</td><td>-20.50③</td><td>-0.120</td><td>2014-4-10</td></tr><tr height='24'><td>2014-4-9</td><td>16:12</td><td>600782</td><td class=tdred>新钢股份</td><td>0.00</td><td class=tdred>0.00</td><td class=tdred>0.000</td><td>0.000</td><td>0.000</td>\t<td class=tdbgblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdbgred>0.00</td><td class=tdred></td><td class=tdred>0</td><td class=tdblue>0.0</td><td>0.0</td><td>0.0</td><td class=tdblue>0.0</td><td bgcolor='#f0f0f0'>0</td><td>0</td><td>0.000</td><td>0.000</td><td>0.000</td><td>0.000</td><td>0</td><td>0</td><td class=tdblue>0</td><td>0</td><td>0</td><td>0</td><td>0.0</td><td>0.0</td><td>0</td><td>0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.00</td><td>0</td><td>-20.50③</td><td>-0.120</td><td>2014-4-9</td></tr><tr height='24'><td>2014-4-8</td><td>16:12</td><td>600782</td><td class=tdred>新钢股份</td><td>0.00</td><td class=tdred>0.00</td><td class=tdred>0.000</td><td>0.000</td><td>0.000</td>\t<td class=tdbgblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdbgred>0.00</td><td class=tdred></td><td class=tdred>0</td><td class=tdblue>0.0</td><td>0.0</td><td>0.0</td><td class=tdblue>0.0</td><td bgcolor='#f0f0f0'>0</td><td>0</td><td>0.000</td><td>0.000</td><td>0.000</td><td>0.000</td><td>0</td><td>0</td><td class=tdblue>0</td><td>0</td><td>0</td><td>0</td><td>0.0</td><td>0.0</td><td>0</td><td>0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.00</td><td>0</td><td>-20.50③</td><td>-0.120</td><td>2014-4-8</td></tr><tr height='24'><td>2014-4-4</td><td>16:12</td><td>600782</td><td class=tdred>新钢股份</td><td>0.00</td><td class=tdred>0.00</td><td class=tdred>0.000</td><td>0.000</td><td>0.000</td>\t<td class=tdbgblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdbgred>0.00</td><td class=tdred></td><td class=tdred>0</td><td class=tdblue>0.0</td><td>0.0</td><td>0.0</td><td class=tdblue>0.0</td><td bgcolor='#f0f0f0'>0</td><td>0</td><td>0.000</td><td>0.000</td><td>0.000</td><td>0.000</td><td>0</td><td>0</td><td class=tdblue>0</td><td>0</td><td>0</td><td>0</td><td>0.0</td><td>0.0</td><td>0</td><td>0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.00</td><td>0</td><td>-20.50③</td><td>-0.120</td><td>2014-4-4</td></tr><tr height='24'><td>2014-4-3</td><td>16:12</td><td>600782</td><td class=tdred>新钢股份</td><td>0.00</td><td class=tdred>0.00</td><td class=tdred>0.000</td><td>0.000</td><td>0.000</td>\t<td class=tdbgblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdbgred>0.00</td><td class=tdred></td><td class=tdred>0</td><td class=tdblue>0.0</td><td>0.0</td><td>0.0</td><td class=tdblue>0.0</td><td bgcolor='#f0f0f0'>0</td><td>0</td><td>0.000</td><td>0.000</td><td>0.000</td><td>0.000</td><td>0</td><td>0</td><td class=tdblue>0</td><td>0</td><td>0</td><td>0</td><td>0.0</td><td>0.0</td><td>0</td><td>0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.00</td><td>0</td><td>-20.50③</td><td>-0.120</td><td>2014-4-3</td></tr><tr height='24'><td>2014-4-2</td><td>16:12</td><td>600782</td><td class=tdred>新钢股份</td><td>0.00</td><td class=tdred>0.00</td><td class=tdred>0.000</td><td>0.000</td><td>0.000</td>\t<td class=tdbgblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdbgred>0.00</td><td class=tdred></td><td class=tdred>0</td><td class=tdblue>0.0</td><td>0.0</td><td>0.0</td><td class=tdblue>0.0</td><td bgcolor='#f0f0f0'>0</td><td>0</td><td>0.000</td><td>0.000</td><td>0.000</td><td>0.000</td><td>0</td><td>0</td><td class=tdblue>0</td><td>0</td><td>0</td><td>0</td><td>0.0</td><td>0.0</td><td>0</td><td>0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.00</td><td>0</td><td>-20.50③</td><td>-0.120</td><td>2014-4-2</td></tr><tr height='24'><td>2014-4-1</td><td>16:12</td><td>600782</td><td class=tdred>新钢股份</td><td>0.00</td><td class=tdred>0.00</td><td class=tdred>0.000</td><td>0.000</td><td>0.000</td>\t<td class=tdbgblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdbgred>0.00</td><td class=tdred></td><td class=tdred>0</td><td class=tdblue>0.0</td><td>0.0</td><td>0.0</td><td class=tdblue>0.0</td><td bgcolor='#f0f0f0'>0</td><td>0</td><td>0.000</td><td>0.000</td><td>0.000</td><td>0.000</td><td>0</td><td>0</td><td class=tdblue>0</td><td>0</td><td>0</td><td>0</td><td>0.0</td><td>0.0</td><td>0</td><td>0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.00</td><td>0</td><td>-20.50③</td><td>-0.120</td><td>2014-4-1</td></tr><tr height='24'><td>2014-3-31</td><td>16:12</td><td>600782</td><td class=tdred>新钢股份</td><td>0.00</td><td class=tdred>0.00</td><td class=tdred>0.000</td><td>0.000</td><td>0.000</td>\t<td class=tdbgblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdbgred>0.00</td><td class=tdred></td><td class=tdred>0</td><td class=tdblue>0.0</td><td>0.0</td><td>0.0</td><td class=tdblue>0.0</td><td bgcolor='#f0f0f0'>0</td><td>0</td><td>0.000</td><td>0.000</td><td>0.000</td><td>0.000</td><td>0</td><td>0</td><td class=tdblue>0</td><td>0</td><td>0</td><td>0</td><td>0.0</td><td>0.0</td><td>0</td><td>0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.00</td><td>0</td><td>-20.50③</td><td>-0.120</td><td>2014-3-31</td></tr><tr height='24'><td>2014-3-28</td><td>16:12</td><td>600782</td><td class=tdred>新钢股份</td><td>0.00</td><td class=tdred>0.00</td><td class=tdred>0.000</td><td>0.000</td><td>0.000</td>\t<td class=tdbgblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdbgred>0.00</td><td class=tdred></td><td class=tdred>0</td><td class=tdblue>0.0</td><td>0.0</td><td>0.0</td><td class=tdblue>0.0</td><td bgcolor='#f0f0f0'>0</td><td>0</td><td>0.000</td><td>0.000</td><td>0.000</td><td>0.000</td><td>0</td><td>0</td><td class=tdblue>0</td><td>0</td><td>0</td><td>0</td><td>0.0</td><td>0.0</td><td>0</td><td>0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.00</td><td>0</td><td>-20.50③</td><td>-0.120</td><td>2014-3-28</td></tr><tr height='24'><td>2014-3-27</td><td>16:12</td><td>600782</td><td class=tdred>新钢股份</td><td>0.00</td><td class=tdred>0.00</td><td class=tdred>0.000</td><td>0.000</td><td>0.000</td>\t<td class=tdbgblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdbgred>0.00</td><td class=tdred></td><td class=tdred>0</td><td class=tdblue>0.0</td><td>0.0</td><td>0.0</td><td class=tdblue>0.0</td><td bgcolor='#f0f0f0'>0</td><td>0</td><td>0.000</td><td>0.000</td><td>0.000</td><td>0.000</td><td>0</td><td>0</td><td class=tdblue>0</td><td>0</td><td>0</td><td>0</td><td>0.0</td><td>0.0</td><td>0</td><td>0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.00</td><td>0</td><td>-20.50③</td><td>-0.120</td><td>2014-3-27</td></tr><tr height='24'><td>2014-3-26</td><td>16:12</td><td>600782</td><td class=tdred>新钢股份</td><td>0.00</td><td class=tdred>0.00</td><td class=tdred>0.000</td><td>0.000</td><td>0.000</td>\t<td class=tdbgblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdbgred>0.00</td><td class=tdred></td><td class=tdred>0</td><td class=tdblue>0.0</td><td>0.0</td><td>0.0</td><td class=tdblue>0.0</td><td bgcolor='#f0f0f0'>0</td><td>0</td><td>0.000</td><td>0.000</td><td>0.000</td><td>0.000</td><td>0</td><td>0</td><td class=tdblue>0</td><td>0</td><td>0</td><td>0</td><td>0.0</td><td>0.0</td><td>0</td><td>0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.00</td><td>0</td><td>-20.50③</td><td>-0.120</td><td>2014-3-26</td></tr><tr height='24'><td>2014-3-25</td><td>16:12</td><td>600782</td><td class=tdred>新钢股份</td><td>0.00</td><td class=tdred>0.00</td><td class=tdred>0.000</td><td>0.000</td><td>0.000</td>\t<td class=tdbgblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdbgred>0.00</td><td class=tdred></td><td class=tdred>0</td><td class=tdblue>0.0</td><td>0.0</td><td>0.0</td><td class=tdblue>0.0</td><td bgcolor='#f0f0f0'>0</td><td>0</td><td>0.000</td><td>0.000</td><td>0.000</td><td>0.000</td><td>0</td><td>0</td><td class=tdblue>0</td><td>0</td><td>0</td><td>0</td><td>0.0</td><td>0.0</td><td>0</td><td>0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.00</td><td>0</td><td>-20.50③</td><td>-0.120</td><td>2014-3-25</td></tr><tr height='24'><td>2014-3-24</td><td>16:12</td><td>600782</td><td class=tdred>新钢股份</td><td>0.00</td><td class=tdred>0.00</td><td class=tdred>0.000</td><td>0.000</td><td>0.000</td>\t<td class=tdbgblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdblue>0</td>\t<td class=tdbgred>0.00</td><td class=tdred></td><td class=tdred>0</td><td class=tdblue>0.0</td><td>0.0</td><td>0.0</td><td class=tdblue>0.0</td><td bgcolor='#f0f0f0'>0</td><td>0</td><td>0.000</td><td>0.000</td><td>0.000</td><td>0.000</td><td>0</td><td>0</td><td class=tdblue>0</td><td>0</td><td>0</td><td>0</td><td>0.0</td><td>0.0</td><td>0</td><td>0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.0</td><td>0.00</td><td>0</td><td>-20.50③</td><td>-0.120</td><td>2014-3-24</td></tr>\n" +
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
            "<td class=td1align=\"center\" colspan=\"2\"><b>新钢股份实时走势图+日K线图</b>&nbsp;<a class=ahs2 href=\"javascript:location.reload()\">【手工刷新】</a></td>\n" +
            "</tr>\n" +
            "<tr>\n" +
            "<td width=\"520\">\n" +
            "<iframe marginwidth=\"0\" marginheight=\"0\"  frameborder=\"0\" bordercolor=\"#000000\" scrolling=\"no\" src=\"http://image2.sinajs.cn/newchart/min/n/sh600782.gif\" width=\"545\" height=\"314\"></iframe>\n" +
            "</td>\n" +
            "<td  width=\"520\">\n" +
            "<iframe marginwidth=\"0\" marginheight=\"0\"  frameborder=\"0\" bordercolor=\"#000000\" scrolling=\"no\" src=\"http://image2.sinajs.cn/newchart/daily/n/sh600782.gif\" width=\"545\" height=\"314\"></iframe>\n" +
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
