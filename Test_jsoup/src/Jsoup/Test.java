package Jsoup;


import org.jsoup.*;
import org.jsoup.nodes.*;

import javax.sound.midi.SysexMessage;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhuxinquan on 15-12-15.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect("http://movie.douban.com/subject/25809384/?from=showing").timeout(5000).get();
        String html = doc.toString();
        String s = "";
        Pattern reg_htm = Pattern.compile("<[^>]+>");  //匹配html标签
        Pattern reg_name_ = Pattern.compile("&middot;");       //匹配英文人名中间的点
        Pattern p = Pattern.compile("<span property=\"v:itemre.*</span>");
        Matcher m = p.matcher(html);
        while(m.find()){
            s = m.group(0);
        }
        m = reg_htm.matcher(s);
        s = m.replaceAll("");
        System.out.println(s);
        p = Pattern.compile("(?s)<span class=\"pl\">.*?</span></span>.*?<br />");
        m = p.matcher(html);
        while (m.find()) {
            s = m.group(0);
            Matcher m1 = reg_htm.matcher(s);
            s = m1.replaceAll("");
            m1 = reg_name_.matcher(s);
            s = m1.replaceAll("·");
            System.out.println(s);
        }
        //System.out.println(html);
        p = Pattern.compile("(?s)(<span class=\"pl\">.*?<span property=\"v:genre\">.*?</span>\n" +
                "          <br />)");
        m = p.matcher(html);
        while (m.find()) {
            s = m.group(0);
            Matcher m1 = reg_htm.matcher(s);
            s = m1.replaceAll("");
            m1 = reg_name_.matcher(s);
            s = m1.replaceAll("·");
            System.out.println(s);
        }
    }
}
