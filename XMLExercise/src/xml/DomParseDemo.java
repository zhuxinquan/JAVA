package xml;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuxinquan on 16-1-20.
 */
public class DomParseDemo {
    /**
     * 一个解析类对应一个xml文件
     * @throws IOException
     * @throws ParserConfigurationException
     * @throws SAXException
     */
    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
        //创建Dom解析器工厂
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        //通过解析器工厂创建解析器
        DocumentBuilder builder = dbf.newDocumentBuilder();
        //构造一个输入流
        InputStream is = new FileInputStream("teacher.xml");
        //开始解析，创建Document对象
        Document doc = builder.parse(is);

        //存储Teacher的集合
        List<Teacher> teachers = new ArrayList<Teacher>();
        Teacher t = null;

        //根据文档的结点获取数据，返回一个NodeList列表
        NodeList nodelist =  doc.getElementsByTagName("teacher");
        for (int i = 0; i < nodelist.getLength(); i++) {
            t = new Teacher();
            //item返回值为一个结点，返回一个Node对象
            Node teachernode =  nodelist.item(i);
            //getAttributes取得当前结点下的所有属性,getNameItem根据属性名称获取当前属性
            String id = teachernode.getAttributes().getNamedItem("id").getNodeValue();
//            System.out.println(id);
            t.setId(Integer.parseInt(id));
            //获取当前节点下的所有子节点列表
            NodeList childNodeList = teachernode.getChildNodes();
            for (int j = 0; j < childNodeList.getLength(); j++) {
                //获取teacher节点下的其中一个子节点
                Node childNode = childNodeList.item(j);
                String tagName = childNode.getNodeName();
                if("name".equals(tagName)){
                    //获取teacher节点下的name节点的值
                    t.setName(childNode.getFirstChild().getNodeValue());
                }else if("desc".equals(tagName)){
                    //获取teacher节点下的desc值
                    t.setDesc(childNode.getFirstChild().getNodeValue());
                }else{
                    System.out.println(tagName);
                }
            }
            teachers.add(t);
        }
        System.out.println(teachers);
    }
}
