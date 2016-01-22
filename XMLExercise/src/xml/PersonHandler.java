package xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * SAX解析的内容处理器
 * 进行回调使用
 * Created by zhuxinquan on 16-1-22.
 */
public class PersonHandler extends DefaultHandler {

    private List<Teacher> teachers = null;
    private Teacher teacher;
    private String tag;


    //开始解析文档时调用的方法

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    @Override
    public void startDocument() throws SAXException {
        teachers = new ArrayList<Teacher>();
    }


    /**
     * 解析开始标签时调用的方法
     * @param uri:命名空间
     * @param localName：元素的本地名称，即元素名（标签名），不带前缀
     * @param qName：带前缀的元素名称
     * @param attributes：存储标签元素的属性
     * @throws SAXException
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if("teacher".equals(qName)){
            teacher = new Teacher();
            //取出属性并添加到teacher中
            teacher.setId(Integer.parseInt(attributes.getValue("id")));
        }
        tag = qName;
    }

    //解析结束标签时调用的方法
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if("teacher".equals(qName)){
            teachers.add(teacher);
        }
        tag = null;
    }

    //xml文档解析完成调用的方法
    @Override
    public void endDocument() throws SAXException {
        System.out.println("XML解析完毕！");
    }

    //解析文本内容时调用的方法
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(tag != null){
            //取出属性并添加到teacher中
            if("name".equals(tag)){
                teacher.setName(new String(ch, start, length));
            }else if("desc".equals(tag)){
                teacher.setDesc(new String(ch, start, length));
            }
        }
    }
}
