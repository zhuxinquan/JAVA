import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.apache.commons.io.FileUtils.*;

/**
 * Created by zhuxinquan on 15-12-4.
 */
public class Test_jsoup {
    public  Document getDocument (String url){
        try {
            return Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) throws Exception{
        File doubanvideo = new File("doubanvideo");
        Document doc = Jsoup.connect("http://movie.douban.com/subject/26411409/?from=showing").timeout(10000).get();
        Elements element1 = doc.select("[id=content]");
        Elements element2 = element1.select("[ property=v:itemreviewed]");
        String title = "title" + element2.text();
        FileOutputStream(title, append);
        System.out.println(element2.text());
    }
}
