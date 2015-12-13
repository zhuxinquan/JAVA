package Jsoup;

import org.jsoup.Jsoup;

import javax.swing.text.Document;
import javax.swing.text.Element;
import java.io.File;

/**
 * Created by zhuxinquan on 15-12-4.
 */
public class Test_jsoup {
    public static void main(String[] args) {
        File input = new File("input.html");
        Document doc = Jsoup.parse(input, "UTF-8", "http://movie.douban.com/subject/26320029/?from=showing");
        //Document  doc = Jsoup.connect("http://movie.douban.com/subject/26320029/?from=showing").get();
        Element content =
    }
}
