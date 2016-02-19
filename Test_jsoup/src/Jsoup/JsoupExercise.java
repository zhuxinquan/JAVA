package Jsoup;

import org.jsoup.*;
import org.jsoup.nodes.*;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhuxinquan on 16-2-17.
 */
public class JsoupExercise {
    public static void main(String[] args) throws IOException {

        Document doc = (Document) Jsoup.connect("http://www.douban.com/doulist/1264675/").get();
//        System.out.println(doc.toString());
        String html = doc.toString();
        List<String> pageLink = new LinkedList<>();
        Pattern reg_htm = Pattern.compile("<[^>]+>");  //匹配html标签
        Pattern reg_name_ = Pattern.compile("&middot;");       //匹配英文人名中间的点
        Pattern reg_nbsp = Pattern.compile("&nbsp;");           //匹配空格
        //匹配列表链接
        Pattern reg_link = Pattern.compile("<div class=\"post\"> \n" +
                "          <a href=\"http://book.douban.com/subject/.*/\" ?target=\"_blank\">");
        //匹配url
        Pattern reg_url = Pattern.compile("http://book.douban.com/subject/.*?/");
        Matcher m = reg_link.matcher(html);
        while(m.find()){
            String url;
//            System.out.println(m.group(0));
            Matcher m1 = reg_url.matcher(m.group());
            if(m1.find()){
                url = m1.group(0);
                pageLink.add(url);
//                System.out.println(url);
            }
        }

//        System.out.println(pageLink);

        for (String s:pageLink
             ) {
            System.out.println(s);
        }

    }
}
