import com.douglas.stock.proxyservice.bean.EnhancedProxy;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wgz on 15/4/2.
 */

@RunWith(SpringJUnit4ClassRunner.class)
public class TestSubClass {

    public static void main(String[] args) {
        String content = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "  <title>国内高匿免费HTTP代理IP_国内高匿</title>\n" +
                "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/>\n" +
                "  <meta name=\"Description\" content=\"国内高匿免费HTTP代理\" />\n" +
                "  <meta name=\"Keywords\" content=\"国内高匿,免费高匿代理,免费匿名代理,隐藏IP\" />\n" +
                "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0\">\n" +
                "  　　<meta name=\"applicable-device\"content=\"pc,mobile\">\n" +
                "  <link rel=\"stylesheet\" media=\"screen\" href=\"http://fs.xicidaili.com/assets/application-4728aa2f37533ff25a1eeae72984c5387819c191fef7145110152eb7bd6bb266.css\" />\n" +
                "  <meta name=\"csrf-param\" content=\"authenticity_token\" />\n" +
                "<meta name=\"csrf-token\" content=\"aXQa50zJpgdD0lhos797dKm0Fqx/f8AFnex4/OEJYBIcb7ovMVPVMweY+5W5w6bIVcS4e8REb84a2FDax8x/9w==\" />\n" +
                "</head>\n" +
                "<body>\n" +
                "  <div id=\"wrapper\">\n" +
                "    <div id=\"header\">\n" +
                "      <h1>国内高匿代理IP</h1>\n" +
                "      <img alt=\"免费http代理\" id=\"logo\" src=\"http://fs.xicidaili.com/images/logo.png\" />\n" +
                "      <div id=\"myurl\">\n" +
                "        XiciDaili.com\n" +
                "      </div>\n" +
                "      <ul id=\"nav\">\n" +
                "        <li><a class=\"false\" href=\"/\">首页</a></li>\n" +
                "        <li><a class=\"active\" href=\"/nn/\">国内高匿代理</a></li>\n" +
                "        <li><a class=\"false\" href=\"/nt/\">国内普通代理</a></li>\n" +
                "        <li><a class=\"false\" href=\"/wn/\">国外高匿代理</a></li>\n" +
                "        <li><a class=\"false\" href=\"/wt/\">国外普通代理</a></li>\n" +
                "        <li><a class=\"false\" href=\"/qq/\">SOCKS代理</a></li>\n" +
                "        <li><a class=\"false\" href=\"/articles/\">代理小百科</a></li>\n" +
                "      </ul>\n" +
                "    </div>\n" +
                "    <div id=\"body\" class=\"clearfix proxies\">\n" +
                "      \n" +
                "\n" +
                "\n" +
                "<div id=\"bread\">\n" +
                "  当前位置: \n" +
                "  <a href=\"/\">首页</a>\n" +
                "   &gt; 国内高匿代理 \n" +
                "</div>\n" +
                "\n" +
                "\n" +
                "<a target=\"_blank\" class=\"sideimg\" href=\"http://www.daili666.net/\"><img src=\"http://fs.xicidaili.com/images/side2.png\" alt=\"Side2\" /></a>\n" +
                "\n" +
                "\n" +
                "  <table id=\"ip_list\">\n" +
                "    <tr>\n" +
                "      <th class=\"country\">国家</th>\n" +
                "      <th>IP地址</th>\n" +
                "      <th>端口</th>\n" +
                "      <th>服务器地址</th>\n" +
                "      <th class=\"country\">是否匿名</th>\n" +
                "      <th>类型</th>\n" +
                "      <th class=\"country\">速度</th>\n" +
                "      <th class=\"country\">连接时间</th>\n" +
                "      <th width=\"8%\">存活时间</th>\n" +
                "      \n" +
                "      <th width=\"20%\">验证时间</th>\n" +
                "    </tr>\n" +
                "  \n" +
                "    <tr class=\"odd\">\n" +
                "      <td class=\"country\"><img src=\"http://fs.xicidaili.com/images/flag/cn.png\" alt=\"Cn\" /></td>\n" +
                "      <td>123.185.109.86</td>\n" +
                "      <td>8888</td>\n" +
                "      <td>\n" +
                "        <a href=\"/2016-06-20/liaoning\">辽宁大连</a>\n" +
                "      </td>\n" +
                "      <td class=\"country\">高匿</td>\n" +
                "      <td>HTTP</td>\n" +
                "      <td class=\"country\">\n" +
                "        <div title=\"1.494秒\" class=\"bar\">\n" +
                "          <div class=\"bar_inner fast\" style=\"width:92%\">\n" +
                "            \n" +
                "          </div>\n" +
                "        </div>\n" +
                "      </td>\n" +
                "      <td class=\"country\">\n" +
                "        <div title=\"0.298秒\" class=\"bar\">\n" +
                "          <div class=\"bar_inner fast\" style=\"width:98%\">\n" +
                "            \n" +
                "          </div>\n" +
                "        </div>\n" +
                "      </td>\n" +
                "      \n" +
                "      <td>4天</td>\n" +
                "      <td>16-06-25 00:30</td>\n" +
                "    </tr>\n" +
                "  \n" +
                "    <tr class=\"\">\n" +
                "      <td class=\"country\"><img src=\"http://fs.xicidaili.com/images/flag/cn.png\" alt=\"Cn\" /></td>\n" +
                "      <td>36.248.171.112</td>\n" +
                "      <td>8888</td>\n" +
                "      <td>\n" +
                "        <a href=\"/2016-06-15/fujian\">福建福州</a>\n" +
                "      </td>\n" +
                "      <td class=\"country\">高匿</td>\n" +
                "      <td>HTTP</td>\n" +
                "      <td class=\"country\">\n" +
                "        <div title=\"7.974秒\" class=\"bar\">\n" +
                "          <div class=\"bar_inner slow\" style=\"width:59%\">\n" +
                "            \n" +
                "          </div>\n" +
                "        </div>\n" +
                "      </td>\n" +
                "      <td class=\"country\">\n" +
                "        <div title=\"1.594秒\" class=\"bar\">\n" +
                "          <div class=\"bar_inner medium\" style=\"width:90%\">\n" +
                "            \n" +
                "          </div>\n" +
                "        </div>\n" +
                "      </td>\n" +
                "      \n" +
                "      <td>9天</td>\n" +
                "      <td>16-06-25 00:30</td>\n" +
                "    </tr>\n" +
                "  \n" +
                "    <tr class=\"odd\">\n" +
                "      <td class=\"country\"><img src=\"http://fs.xicidaili.com/images/flag/cn.png\" alt=\"Cn\" /></td>\n" +
                "      <td>112.111.203.174</td>\n" +
                "      <td>8888</td>\n" +
                "      <td>\n" +
                "        <a href=\"/2016-06-14/fujian\">福建宁德</a>\n" +
                "      </td>\n" +
                "      <td class=\"country\">高匿</td>\n" +
                "      <td>HTTP</td>\n" +
                "      <td class=\"country\">\n" +
                "        <div title=\"7.29秒\" class=\"bar\">\n" +
                "          <div class=\"bar_inner slow\" style=\"width:53%\">\n" +
                "            \n" +
                "          </div>\n" +
                "        </div>\n" +
                "      </td>\n" +
                "      <td class=\"country\">\n" +
                "        <div title=\"1.458秒\" class=\"bar\">\n" +
                "          <div class=\"bar_inner medium\" style=\"width:88%\">\n" +
                "            \n" +
                "          </div>\n" +
                "        </div>\n" +
                "      </td>\n" +
                "      \n" +
                "      <td>10天</td>\n" +
                "      <td>16-06-25 00:30</td>\n" +
                "    </tr>\n" +
                "  \n" +
                "    <tr class=\"\">\n" +
                "      <td class=\"country\"><img src=\"http://fs.xicidaili.com/images/flag/cn.png\" alt=\"Cn\" /></td>\n" +
                "      <td>125.33.120.28</td>\n" +
                "      <td>8888</td>\n" +
                "      <td>\n" +
                "        <a href=\"/2016-06-21/beijing\">北京</a>\n" +
                "      </td>\n" +
                "      <td class=\"country\">高匿</td>\n" +
                "      <td>HTTP</td>\n" +
                "      <td class=\"country\">\n" +
                "        <div title=\"7.064秒\" class=\"bar\">\n" +
                "          <div class=\"bar_inner slow\" style=\"width:57%\">\n" +
                "            \n" +
                "          </div>\n" +
                "        </div>\n" +
                "      </td>\n" +
                "      <td class=\"country\">\n" +
                "        <div title=\"1.412秒\" class=\"bar\">\n" +
                "          <div class=\"bar_inner medium\" style=\"width:83%\">\n" +
                "            \n" +
                "          </div>\n" +
                "        </div>\n" +
                "      </td>\n" +
                "      \n" +
                "      <td>3天</td>\n" +
                "      <td>16-06-25 00:30</td>\n" +
                "    </tr>\n" +
                "  \n" +
                "    <tr class=\"odd\">\n" +
                "      <td class=\"country\"><img src=\"http://fs.xicidaili.com/images/flag/cn.png\" alt=\"Cn\" /></td>\n" +
                "      <td>182.36.175.179</td>\n" +
                "      <td>8888</td>\n" +
                "      <td>\n" +
                "        <a href=\"/2016-06-21/shandong\">山东东营</a>\n" +
                "      </td>\n" +
                "      <td class=\"country\">高匿</td>\n" +
                "      <td>HTTP</td>\n" +
                "      <td class=\"country\">\n" +
                "        <div title=\"3.117秒\" class=\"bar\">\n" +
                "          <div class=\"bar_inner medium\" style=\"width:83%\">\n" +
                "            \n" +
                "          </div>\n" +
                "        </div>\n" +
                "      </td>\n" +
                "      <td class=\"country\">\n" +
                "        <div title=\"0.623秒\" class=\"bar\">\n" +
                "          <div class=\"bar_inner fast\" style=\"width:90%\">\n" +
                "            \n" +
                "          </div>\n" +
                "        </div>\n" +
                "      </td>\n" +
                "      \n" +
                "      <td>3天</td>\n" +
                "      <td>16-06-25 00:28</td>\n" +
                "    </tr>\n" +
                "  \n" +
                "    <tr class=\"\">\n" +
                "      <td class=\"country\"><img src=\"http://fs.xicidaili.com/images/flag/cn.png\" alt=\"Cn\" /></td>\n" +
                "      <td>144.52.144.154</td>\n" +
                "      <td>8888</td>\n" +
                "      <td>\n" +
                "        <a href=\"/2016-06-03/shandong\">山东</a>\n" +
                "      </td>\n" +
                "      <td class=\"country\">高匿</td>\n" +
                "      <td>HTTP</td>\n" +
                "      <td class=\"country\">\n" +
                "        <div title=\"1.099秒\" class=\"bar\">\n" +
                "          <div class=\"bar_inner fast\" style=\"width:99%\">\n" +
                "            \n" +
                "          </div>\n" +
                "        </div>\n" +
                "      </td>\n" +
                "      <td class=\"country\">\n" +
                "        <div title=\"0.219秒\" class=\"bar\">\n" +
                "          <div class=\"bar_inner fast\" style=\"width:98%\">\n" +
                "            \n" +
                "          </div>\n" +
                "        </div>\n" +
                "      </td>\n" +
                "      \n" +
                "      <td>21天</td>\n" +
                "      <td>16-06-25 00:28</td>\n" +
                "    </tr>\n" +
                "  \n" +
                "    <tr class=\"odd\">\n" +
                "      <td class=\"country\"><img src=\"http://fs.xicidaili.com/images/flag/cn.png\" alt=\"Cn\" /></td>\n" +
                "      <td>119.186.227.241</td>\n" +
                "      <td>8888</td>\n" +
                "      <td>\n" +
                "        <a href=\"/2016-06-15/shandong\">山东枣庄</a>\n" +
                "      </td>\n" +
                "      <td class=\"country\">高匿</td>\n" +
                "      <td>HTTP</td>\n" +
                "      <td class=\"country\">\n" +
                "        <div title=\"7.119秒\" class=\"bar\">\n" +
                "          <div class=\"bar_inner slow\" style=\"width:65%\">\n" +
                "            \n" +
                "          </div>\n" +
                "        </div>\n" +
                "      </td>\n" +
                "      <td class=\"country\">\n" +
                "        <div title=\"1.423秒\" class=\"bar\">\n" +
                "          <div class=\"bar_inner medium\" style=\"width:88%\">\n" +
                "            \n" +
                "          </div>\n" +
                "        </div>\n" +
                "      </td>\n" +
                "      \n" +
                "      <td>9天</td>\n" +
                "      <td>16-06-25 00:28</td>\n" +
                "    </tr>\n" +
                "  \n" +
                "    <tr class=\"\">\n" +
                "      <td class=\"country\"><img src=\"http://fs.xicidaili.com/images/flag/cn.png\" alt=\"Cn\" /></td>\n" +
                "      <td>39.78.132.255</td>\n" +
                "      <td>8888</td>\n" +
                "      <td>\n" +
                "        <a href=\"/2016-06-19/shandong\">山东</a>\n" +
                "      </td>\n" +
                "      <td class=\"country\">高匿</td>\n" +
                "      <td>HTTP</td>\n" +
                "      <td class=\"country\">\n" +
                "        <div title=\"7.073秒\" class=\"bar\">\n" +
                "          <div class=\"bar_inner slow\" style=\"width:70%\">\n" +
                "            \n" +
                "          </div>\n" +
                "        </div>\n" +
                "      </td>\n" +
                "  \n" +
                "  \n" +
                "  </table>  \n" +
                "  \n" +
                "  <div class=\"pagination\"><span class=\"previous_page disabled\">&lsaquo; 上一页</span> <em class=\"current\">1</em> <a rel=\"next\" href=\"/nn/2\">2</a> <a href=\"/nn/3\">3</a> <a href=\"/nn/4\">4</a> <a href=\"/nn/5\">5</a> <a href=\"/nn/6\">6</a> <a href=\"/nn/7\">7</a> <a href=\"/nn/8\">8</a> <a href=\"/nn/9\">9</a> <span class=\"gap\">...</span> <a href=\"/nn/907\">907</a> <a href=\"/nn/908\">908</a> <a class=\"next_page\" rel=\"next\" href=\"/nn/2\">下一页 &rsaquo;</a></div>\n" +
                "\n" +
                "    </div>\n" +
                "    \n" +
                "    \n" +
                "    <div id=\"footer\">\n" +
                "     <span class=\"site_name\">西刺免费代理IP</span> \n" +
                "     <span class=\"copy\">&copy;</span>\n" +
                "     <span class=\"site_url\">XiciDaili.com </span>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "  <div style=\"display:none\">\n" +
                "    <script src=\"http://s11.cnzz.com/stat.php?id=1256960793&web_id=1256960793\" language=\"JavaScript\"></script>\n" +
                "  </div>\n" +
                "</body>\n" +
                "</html>";



        Pattern p = Pattern.compile("(\\d{1,3}\\.\\d{1,3}.\\d{1,3}.\\d{1,3})</td>[\\S\\s]+<td>(\\d+)(</td>[\\s\\S]+){2}(HTTP|HTTPS|socks)");

        synchronized (p) {
            Matcher m = p.matcher(content);
            while (m.find()) {
                String host = m.group(1);
                int port = Integer.valueOf(m.group(2));
                String sType = m.group(4);
                Proxy.Type type = sType.indexOf("HTTP") == 0 ? Proxy.Type.HTTP : Proxy.Type.SOCKS;
                EnhancedProxy proxy = new EnhancedProxy(type, new InetSocketAddress(host, port), 0);
//                proxies.add(proxy);
            }
        }
    }
}

