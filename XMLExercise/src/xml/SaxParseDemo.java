package xml;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by zhuxinquan on 16-1-22.
 */
public class SaxParseDemo {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        //创建SAX解析器工厂
        SAXParserFactory factory = SAXParserFactory.newInstance();
        //根据工厂创建解析器对象
        SAXParser sax = factory.newSAXParser();

        PersonHandler ph = new PersonHandler();
        //开始解析
        sax.parse((InputStream) new FileInputStream("teacher.xml"), ph);
        List<Teacher> list = ph.getTeachers();
        System.out.println(list);
    }
}
