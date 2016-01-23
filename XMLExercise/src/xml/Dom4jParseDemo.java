package xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zhuxinquan on 16-1-22.
 */
public class Dom4jParseDemo {
    public static void main(String[] args) throws FileNotFoundException, DocumentException {
        //创建解析器
        SAXReader reader = new SAXReader();
        Document doc = reader.read((InputStream)new FileInputStream("teacher.xml"));
        Element root = doc.getRootElement();
        //获取根元素的所有子元素
        Iterator<Element> iters = root.elementIterator();

        List<Teacher> list = new ArrayList<Teacher>();

        while(iters.hasNext()){
            Teacher t = new Teacher();
            Element e = iters.next();
            t.setId(Integer.parseInt(e.attributeValue("id")));
            t.setName(e.elementText("name"));
            t.setDesc(e.elementText("desc"));
            list.add(t);
        }
        System.out.println(list);
    }
}
