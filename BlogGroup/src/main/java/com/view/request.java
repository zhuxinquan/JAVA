package com.view;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by zhuxinquan on 16-4-14.
 */
@WebServlet("/request")
public class request extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print("<html><head><meta charset=utf-8><title>a</title></head><body>");
        out.print("\n" +
                "            <p>上一篇简单介绍了dom解析xml文件的用法，但是dom解析有一个缺点，就是dom解析前需要将xml文件一次性的读入内存当中，而SAX解析则解决了这个问题。</p>\n" +
                "\n" +
                "\n" +
                "\n" +
                "<h3 id=\"sax是simple-api-for-xml的简写既是一种接口也是一种软件包\">SAX：是Simple API for XML的简写，既是一种接口，也是一种软件包。</h3>\n" +
                "\n" +
                "<p>SAX是一种XML解析的替代方法。SAX不同于DOM解析，它逐行扫描文档，一边扫描一边解析，所以它内存占用少，对于大型文档的解析是个很好的优势。</p>\n" +
                "\n" +
                "\n" +
                "\n" +
                "<h4 id=\"首先是解析的步骤\">首先是解析的步骤：</h4>\n" +
                "\n" +
                "<ol>\n" +
                "<li>创建SAX解析器工厂对象； SAXParseFactory spf = SAXParserFactory.newInstance();</li>\n" +
                "<li>使用解析器工厂创建解析器实例；SAXParse saxParser = spf.newSAXParser();</li>\n" +
                "<li>创建xml内容解析器对象；PersonHandler ph = new PersonHandler(); <br>\n" +
                "<ol><li>开始解析文档调用的方法</li>\n" +
                "<li>结束解析文档调用的方法</li>\n" +
                "<li>解析开始元素调用的方法</li>\n" +
                "<li>解析结束元素调用的方法</li>\n" +
                "<li>解析文本内容调用的方法</li></ol></li>\n" +
                "<li>创建xml文件输入流，开始解析xml文件：</li>\n" +
                "</ol>\n" +
                "\n" +
                "<p>SAX是从上往下依次解析xml文档的，所以解析的过程并不具备层次性，从输入流开始的地方解析，根据解析到的不同的元素、内容回调合适的方法进行解析，下面是一个以teacher.xml文件为例的解析实例， 将从xml文件中解析出来的teacher的id、name以及desc存入一个Teacher对象中，病输出：</p>\n" +
                "\n" +
                "\n" +
                "\n" +
                "<h4 id=\"teacherxml文件如下\"><strong>teacher.xml文件如下：</strong></h4>\n" +
                "\n" +
                "\n" +
                "\n" +
                "<pre class=\"prettyprint\"><code class=\" hljs xml\"><span class=\"hljs-pi\">&lt;?xml version=\"1.0\" encoding=\"UTF-8\"?&gt;</span>\n" +
                "<span class=\"hljs-tag\">&lt;<span class=\"hljs-title\">person</span>&gt;</span>\n" +
                "    <span class=\"hljs-tag\">&lt;<span class=\"hljs-title\">teacher</span> <span class=\"hljs-attribute\">id</span>=<span class=\"hljs-value\">\"1\"</span>&gt;</span>\n" +
                "        <span class=\"hljs-tag\">&lt;<span class=\"hljs-title\">name</span>&gt;</span>小白<span class=\"hljs-tag\">&lt;/<span class=\"hljs-title\">name</span>&gt;</span>\n" +
                "        <span class=\"hljs-tag\">&lt;<span class=\"hljs-title\">desc</span>&gt;</span>小白人<span class=\"hljs-tag\">&lt;/<span class=\"hljs-title\">desc</span>&gt;</span>\n" +
                "    <span class=\"hljs-tag\">&lt;/<span class=\"hljs-title\">teacher</span>&gt;</span>\n" +
                "    <span class=\"hljs-tag\">&lt;<span class=\"hljs-title\">teacher</span> <span class=\"hljs-attribute\">id</span>=<span class=\"hljs-value\">\"2\"</span>&gt;</span>\n" +
                "        <span class=\"hljs-tag\">&lt;<span class=\"hljs-title\">name</span>&gt;</span>小黑<span class=\"hljs-tag\">&lt;/<span class=\"hljs-title\">name</span>&gt;</span>\n" +
                "        <span class=\"hljs-tag\">&lt;<span class=\"hljs-title\">desc</span>&gt;</span>小黑人<span class=\"hljs-tag\">&lt;/<span class=\"hljs-title\">desc</span>&gt;</span>\n" +
                "    <span class=\"hljs-tag\">&lt;/<span class=\"hljs-title\">teacher</span>&gt;</span>\n" +
                "<span class=\"hljs-tag\">&lt;/<span class=\"hljs-title\">person</span>&gt;</span></code></pre>\n" +
                "\n" +
                "\n" +
                "\n" +
                "<h4 id=\"要存入的teacher类定义如下\">要存入的Teacher类定义如下：</h4>\n" +
                "\n" +
                "\n" +
                "\n" +
                "<pre class=\"prettyprint\"><code class=\" hljs java\"><span class=\"hljs-keyword\">package</span> xml;\n" +
                "<span class=\"hljs-javadoc\">/**\n" +
                " * Created by zhuxinquan on 16-1-20.\n" +
                " */</span>\n" +
                "<span class=\"hljs-keyword\">public</span> <span class=\"hljs-class\"><span class=\"hljs-keyword\">class</span> <span class=\"hljs-title\">Teacher</span> {</span>\n" +
                "    <span class=\"hljs-keyword\">private</span> <span class=\"hljs-keyword\">int</span> id;\n" +
                "    <span class=\"hljs-keyword\">private</span> String name;\n" +
                "    <span class=\"hljs-keyword\">private</span> String desc;\n" +
                "\n" +
                "    <span class=\"hljs-annotation\">@Override</span>\n" +
                "    <span class=\"hljs-keyword\">public</span> String <span class=\"hljs-title\">toString</span>() {\n" +
                "        <span class=\"hljs-keyword\">return</span> <span class=\"hljs-string\">\"Teacher{\"</span> +\n" +
                "                <span class=\"hljs-string\">\"id=\"</span> + id +\n" +
                "                <span class=\"hljs-string\">\", name='\"</span> + name + <span class=\"hljs-string\">'\\''</span> +\n" +
                "                <span class=\"hljs-string\">\", desc='\"</span> + desc + <span class=\"hljs-string\">'\\''</span> +\n" +
                "                <span class=\"hljs-string\">'}'</span>;\n" +
                "    }\n" +
                "\n" +
                "    <span class=\"hljs-keyword\">public</span> <span class=\"hljs-title\">Teacher</span>() {\n" +
                "    }\n" +
                "\n" +
                "    <span class=\"hljs-keyword\">public</span> <span class=\"hljs-title\">Teacher</span>(<span class=\"hljs-keyword\">int</span> id, String name, String desc) {\n" +
                "\n" +
                "        <span class=\"hljs-keyword\">this</span>.id = id;\n" +
                "        <span class=\"hljs-keyword\">this</span>.name = name;\n" +
                "        <span class=\"hljs-keyword\">this</span>.desc = desc;\n" +
                "    }\n" +
                "\n" +
                "    <span class=\"hljs-keyword\">public</span> <span class=\"hljs-keyword\">int</span> <span class=\"hljs-title\">getId</span>() {\n" +
                "\n" +
                "        <span class=\"hljs-keyword\">return</span> id;\n" +
                "    }\n" +
                "\n" +
                "    <span class=\"hljs-keyword\">public</span> <span class=\"hljs-keyword\">void</span> <span class=\"hljs-title\">setId</span>(<span class=\"hljs-keyword\">int</span> id) {\n" +
                "        <span class=\"hljs-keyword\">this</span>.id = id;\n" +
                "    }\n" +
                "\n" +
                "    <span class=\"hljs-keyword\">public</span> String <span class=\"hljs-title\">getName</span>() {\n" +
                "        <span class=\"hljs-keyword\">return</span> name;\n" +
                "    }\n" +
                "\n" +
                "    <span class=\"hljs-keyword\">public</span> <span class=\"hljs-keyword\">void</span> <span class=\"hljs-title\">setName</span>(String name) {\n" +
                "        <span class=\"hljs-keyword\">this</span>.name = name;\n" +
                "    }\n" +
                "\n" +
                "    <span class=\"hljs-keyword\">public</span> String <span class=\"hljs-title\">getDesc</span>() {\n" +
                "        <span class=\"hljs-keyword\">return</span> desc;\n" +
                "    }\n" +
                "\n" +
                "    <span class=\"hljs-keyword\">public</span> <span class=\"hljs-keyword\">void</span> <span class=\"hljs-title\">setDesc</span>(String desc) {\n" +
                "        <span class=\"hljs-keyword\">this</span>.desc = desc;\n" +
                "    }\n" +
                "}</code></pre>\n" +
                "\n" +
                "\n" +
                "\n" +
                "<h4 id=\"下面是sax解析xml文件的源代码\">下面是SAX解析xml文件的源代码：</h4>\n" +
                "\n" +
                "\n" +
                "\n" +
                "<pre class=\"prettyprint\"><code class=\" hljs java\"><span class=\"hljs-keyword\">package</span> xml;\n" +
                "\n" +
                "<span class=\"hljs-keyword\">import</span> org.xml.sax.InputSource;\n" +
                "<span class=\"hljs-keyword\">import</span> org.xml.sax.SAXException;\n" +
                "\n" +
                "<span class=\"hljs-keyword\">import</span> javax.xml.parsers.ParserConfigurationException;\n" +
                "<span class=\"hljs-keyword\">import</span> javax.xml.parsers.SAXParser;\n" +
                "<span class=\"hljs-keyword\">import</span> javax.xml.parsers.SAXParserFactory;\n" +
                "<span class=\"hljs-keyword\">import</span> java.io.FileInputStream;\n" +
                "<span class=\"hljs-keyword\">import</span> java.io.FileNotFoundException;\n" +
                "<span class=\"hljs-keyword\">import</span> java.io.IOException;\n" +
                "<span class=\"hljs-keyword\">import</span> java.io.InputStream;\n" +
                "<span class=\"hljs-keyword\">import</span> java.util.List;\n" +
                "\n" +
                "<span class=\"hljs-javadoc\">/**\n" +
                " * Created by zhuxinquan on 16-1-22.\n" +
                " */</span>\n" +
                "<span class=\"hljs-keyword\">public</span> <span class=\"hljs-class\"><span class=\"hljs-keyword\">class</span> <span class=\"hljs-title\">SaxParseDemo</span> {</span>\n" +
                "    <span class=\"hljs-keyword\">public</span> <span class=\"hljs-keyword\">static</span> <span class=\"hljs-keyword\">void</span> <span class=\"hljs-title\">main</span>(String[] args) <span class=\"hljs-keyword\">throws</span> ParserConfigurationException, SAXException, IOException {\n" +
                "        <span class=\"hljs-comment\">//创建SAX解析器工厂</span>\n" +
                "        SAXParserFactory factory = SAXParserFactory.newInstance();\n" +
                "        <span class=\"hljs-comment\">//根据工厂创建解析器对象</span>\n" +
                "        SAXParser sax = factory.newSAXParser();\n" +
                "\n" +
                "        PersonHandler ph = <span class=\"hljs-keyword\">new</span> PersonHandler();\n" +
                "        <span class=\"hljs-comment\">//开始解析</span>\n" +
                "        sax.parse((InputStream) <span class=\"hljs-keyword\">new</span> FileInputStream(<span class=\"hljs-string\">\"teacher.xml\"</span>), ph);\n" +
                "        List&lt;Teacher&gt; list = ph.getTeachers();\n" +
                "        System.out.println(list);\n" +
                "    }\n" +
                "}</code></pre>\n" +
                "\n" +
                "\n" +
                "\n" +
                "<h4 id=\"如同上面介绍的步骤一样该文件主要定义解析器工厂解析器对象以及声明内容解析对象xml文件的主要解析在与定义的内容解析内容如下\">如同上面介绍的步骤一样，该文件主要定义解析器工厂、解析器对象以及声明内容解析对象，xml文件的主要解析在与定义的内容解析内容，如下：</h4>\n" +
                "\n" +
                "\n" +
                "\n" +
                "<pre class=\"prettyprint\"><code class=\" hljs java\"><span class=\"hljs-keyword\">package</span> xml;\n" +
                "\n" +
                "<span class=\"hljs-keyword\">import</span> org.xml.sax.Attributes;\n" +
                "<span class=\"hljs-keyword\">import</span> org.xml.sax.SAXException;\n" +
                "<span class=\"hljs-keyword\">import</span> org.xml.sax.helpers.DefaultHandler;\n" +
                "\n" +
                "<span class=\"hljs-keyword\">import</span> java.util.ArrayList;\n" +
                "<span class=\"hljs-keyword\">import</span> java.util.List;\n" +
                "\n" +
                "<span class=\"hljs-javadoc\">/**\n" +
                " * SAX解析的内容处理器\n" +
                " * 进行回调使用\n" +
                " * Created by zhuxinquan on 16-1-22.\n" +
                " */</span>\n" +
                "<span class=\"hljs-keyword\">public</span> <span class=\"hljs-class\"><span class=\"hljs-keyword\">class</span> <span class=\"hljs-title\">PersonHandler</span> <span class=\"hljs-keyword\">extends</span> <span class=\"hljs-title\">DefaultHandler</span> {</span>\n" +
                "\n" +
                "    <span class=\"hljs-keyword\">private</span> List&lt;Teacher&gt; teachers = <span class=\"hljs-keyword\">null</span>;\n" +
                "    <span class=\"hljs-keyword\">private</span> Teacher teacher;\n" +
                "    <span class=\"hljs-keyword\">private</span> String tag;\n" +
                "\n" +
                "\n" +
                "    <span class=\"hljs-comment\">//开始解析文档时调用的方法</span>\n" +
                "\n" +
                "    <span class=\"hljs-keyword\">public</span> List&lt;Teacher&gt; <span class=\"hljs-title\">getTeachers</span>() {\n" +
                "        <span class=\"hljs-keyword\">return</span> teachers;\n" +
                "    }\n" +
                "\n" +
                "    <span class=\"hljs-keyword\">public</span> <span class=\"hljs-keyword\">void</span> <span class=\"hljs-title\">setTeachers</span>(List&lt;Teacher&gt; teachers) {\n" +
                "        <span class=\"hljs-keyword\">this</span>.teachers = teachers;\n" +
                "    }\n" +
                "\n" +
                "    <span class=\"hljs-annotation\">@Override</span>\n" +
                "    <span class=\"hljs-keyword\">public</span> <span class=\"hljs-keyword\">void</span> <span class=\"hljs-title\">startDocument</span>() <span class=\"hljs-keyword\">throws</span> SAXException {\n" +
                "        teachers = <span class=\"hljs-keyword\">new</span> ArrayList&lt;Teacher&gt;();\n" +
                "    }\n" +
                "\n" +
                "\n" +
                "    <span class=\"hljs-javadoc\">/**\n" +
                "     * 解析开始标签时调用的方法\n" +
                "     *<span class=\"hljs-javadoctag\"> @param</span> uri:命名空间\n" +
                "     *<span class=\"hljs-javadoctag\"> @param</span> localName：元素的本地名称，即元素名（标签名），不带前缀\n" +
                "     *<span class=\"hljs-javadoctag\"> @param</span> qName：带前缀的元素名称\n" +
                "     *<span class=\"hljs-javadoctag\"> @param</span> attributes：存储标签元素的属性\n" +
                "     *<span class=\"hljs-javadoctag\"> @throws</span> SAXException\n" +
                "     */</span>\n" +
                "    <span class=\"hljs-annotation\">@Override</span>\n" +
                "    <span class=\"hljs-keyword\">public</span> <span class=\"hljs-keyword\">void</span> <span class=\"hljs-title\">startElement</span>(String uri, String localName, String qName, Attributes attributes) <span class=\"hljs-keyword\">throws</span> SAXException {\n" +
                "        <span class=\"hljs-keyword\">if</span>(<span class=\"hljs-string\">\"teacher\"</span>.equals(qName)){\n" +
                "            teacher = <span class=\"hljs-keyword\">new</span> Teacher();\n" +
                "            <span class=\"hljs-comment\">//取出属性并添加到teacher中</span>\n" +
                "            teacher.setId(Integer.parseInt(attributes.getValue(<span class=\"hljs-string\">\"id\"</span>)));\n" +
                "        }\n" +
                "        tag = qName;\n" +
                "    }\n" +
                "\n" +
                "    <span class=\"hljs-comment\">//解析结束标签时调用的方法</span>\n" +
                "    <span class=\"hljs-annotation\">@Override</span>\n" +
                "    <span class=\"hljs-keyword\">public</span> <span class=\"hljs-keyword\">void</span> <span class=\"hljs-title\">endElement</span>(String uri, String localName, String qName) <span class=\"hljs-keyword\">throws</span> SAXException {\n" +
                "        <span class=\"hljs-keyword\">if</span>(<span class=\"hljs-string\">\"teacher\"</span>.equals(qName)){\n" +
                "            teachers.add(teacher);\n" +
                "        }\n" +
                "        tag = <span class=\"hljs-keyword\">null</span>;\n" +
                "    }\n" +
                "\n" +
                "    <span class=\"hljs-comment\">//xml文档解析完成调用的方法</span>\n" +
                "    <span class=\"hljs-annotation\">@Override</span>\n" +
                "    <span class=\"hljs-keyword\">public</span> <span class=\"hljs-keyword\">void</span> <span class=\"hljs-title\">endDocument</span>() <span class=\"hljs-keyword\">throws</span> SAXException {\n" +
                "        System.out.println(<span class=\"hljs-string\">\"XML解析完毕！\"</span>);\n" +
                "    }\n" +
                "\n" +
                "    <span class=\"hljs-comment\">//解析文本内容时调用的方法</span>\n" +
                "    <span class=\"hljs-annotation\">@Override</span>\n" +
                "    <span class=\"hljs-keyword\">public</span> <span class=\"hljs-keyword\">void</span> <span class=\"hljs-title\">characters</span>(<span class=\"hljs-keyword\">char</span>[] ch, <span class=\"hljs-keyword\">int</span> start, <span class=\"hljs-keyword\">int</span> length) <span class=\"hljs-keyword\">throws</span> SAXException {\n" +
                "        <span class=\"hljs-keyword\">if</span>(tag != <span class=\"hljs-keyword\">null</span>){\n" +
                "            <span class=\"hljs-comment\">//取出属性并添加到teacher中</span>\n" +
                "            <span class=\"hljs-keyword\">if</span>(<span class=\"hljs-string\">\"name\"</span>.equals(tag)){\n" +
                "                teacher.setName(<span class=\"hljs-keyword\">new</span> String(ch, start, length));\n" +
                "            }<span class=\"hljs-keyword\">else</span> <span class=\"hljs-keyword\">if</span>(<span class=\"hljs-string\">\"desc\"</span>.equals(tag)){\n" +
                "                teacher.setDesc(<span class=\"hljs-keyword\">new</span> String(ch, start, length));\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}</code></pre>\n" +
                "\n" +
                "\n" +
                "\n" +
                "<h4 id=\"sax解析的内容处理器一般继承defaulthandler类该类中包含了处理xml文档的元素以及文本的许多处理方法在实际应用中需要使用什么方法时再去实现它\">SAX解析的内容处理器一般继承DefaultHandler类，该类中包含了处理xml文档的元素以及文本的许多处理方法，在实际应用中需要使用什么方法时，再去实现它。</h4>\n" +
                "\n" +
                "\n" +
                "\n" +
                "<h4 id=\"上面几个源代码可以在这里找到\">上面几个源代码可以在<a href=\"https://github.com/zhuxinquan/JAVA/tree/master/XMLExercise\" target=\"&quot;_blank\">这里找到</a>;</h4>\n" +
                "\n" +
                "<h5 id=\"初次学习错误之处还望指正\">！！初次学习，错误之处还望指正～～～</h5>\n" +
                "            <div>\n" +
                "                作者：zhuxinquan61 发表于2016/1/22 16:54:19 <a href=\"http://get_blog_content.csdn.net/zhuxinquan61/article/details/50562312\">原文链接</a>\n" +
                "            </div>\n" +
                "            <div>\n" +
                "            阅读：52 评论：1 <a href=\"http://get_blog_content.csdn.net/zhuxinquan61/article/details/50562312#comments\" target=\"_blank\">查看评论</a>\n" +
                "            </div>");
        out.print("</body>");
        out.print("</html>");
    }
}
