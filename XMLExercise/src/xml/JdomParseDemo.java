package xml;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用第三方组件jdom解析xml
 * Created by zhuxinquan on 16-1-22.
 */
public class JdomParseDemo {
    public static void main(String[] args) throws IOException, JDOMException {
        //创建解析器
        SAXBuilder builder = new SAXBuilder();
        //开始解析
        Document doc = builder.build((InputStream)new FileInputStream("teacher.xml"));
        //获取根元素（根标签）
        Element root =  doc.getRootElement();
        //获取根元素下的所有子元素列表
        List<Element> list = root.getChildren();

        List<Teacher> teachers = new ArrayList<Teacher>();
        //遍历元素
        for (int i = 0; i < list.size(); i++) {
            Teacher t = new Teacher();
            Element e =  list.get(i);
            String id = e.getAttributeValue("id");
            t.setId(Integer.parseInt(id));
            //获取当前元素的子元素的文本内容
            t.setName(e.getChildText("name"));
            t.setDesc(e.getChildText("desc"));
            teachers.add(t);
        }
        System.out.println(teachers);
    }
}
