package Jsoup;


import org.jsoup.*;
import org.jsoup.nodes.*;


import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhuxinquan on 15-12-15.
 */
public class Test {
    public static void main(String[] args) throws IOException {

        Document doc = Jsoup.connect("http://movie.douban.com/subject/11808948/?from=showing").timeout(10000).get();
        String html = doc.toString();
        File file = new File(doc.title());
        PrintStream ps = new PrintStream(new FileOutputStream(file));
        String s = "";
        Pattern reg_htm = Pattern.compile("<[^>]+>");  //匹配html标签
        Pattern reg_name_ = Pattern.compile("&middot;");       //匹配英文人名中间的点
        Pattern reg_nbsp = Pattern.compile("&nbsp;");           //匹配空格
        Pattern p = Pattern.compile("<span property=\"v:itemre.*</span>");  //匹配电影名
        Matcher m = p.matcher(html);
        while(m.find()){
            s = m.group(0);
        }
        m = reg_htm.matcher(s);
        s = m.replaceAll("");
        System.out.println(s);
        ps.append(s);

        p = Pattern.compile("(?s)<div id=\"info\">.*?</div>");          //匹配电影简介
        m = p.matcher(html);
        while (m.find()) {
            s = m.group(0);
            //s = s.replace("\n", "");
            Matcher m1 = reg_htm.matcher(s);
            s = m1.replaceAll("");
            m1 = reg_name_.matcher(s);
            s = m1.replaceAll("·");
            s = s.replaceAll("[^\n\\S]", "");
            System.out.println(s);
            ps.append(s);
        }
        p = Pattern.compile("(?s)<div class=\"related-info\".*?</div>");          //匹配剧情简介
        m = p.matcher(html);
        while (m.find()) {
            s = m.group(0);
            //s = s.replace("\n", "");
            Matcher m1 = reg_htm.matcher(s);
            s = m1.replaceAll("");
            m1 = reg_nbsp.matcher(s);
            s = m1.replaceAll("");
            m1 = reg_name_.matcher(s);
            s = m1.replaceAll("·");
            s = s.replaceAll("[^\n\\S]", "");
            System.out.println(s);
            ps.append(s);
        }
        ps.close();
    }
}
