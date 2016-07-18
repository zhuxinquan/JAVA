<html>
<head>
    <title>Welcome</title>
    <meta charset="utf-8">
</head>
<body>

<p>上一篇简单介绍了dom解析xml文件的用法，但是dom解析有一个缺点，就是dom解析前需要将xml文件一次性的读入内存当中，而SAX解析则解决了这个问题。</p>



<h3 id="sax是simple-api-for-xml的简写既是一种接口也是一种软件包">SAX：是Simple API for XML的简写，既是一种接口，也是一种软件包。</h3>

<p>SAX是一种XML解析的替代方法。SAX不同于DOM解析，它逐行扫描文档，一边扫描一边解析，所以它内存占用少，对于大型文档的解析是个很好的优势。</p>



<h4 id="首先是解析的步骤">首先是解析的步骤：</h4>

<ol>
    <li>创建SAX解析器工厂对象； SAXParseFactory spf = SAXParserFactory.newInstance();</li>
    <li>使用解析器工厂创建解析器实例；SAXParse saxParser = spf.newSAXParser();</li>
    <li>创建xml内容解析器对象；PersonHandler ph = new PersonHandler(); <br>
        <ol><li>开始解析文档调用的方法</li>
            <li>结束解析文档调用的方法</li>
            <li>解析开始元素调用的方法</li>
            <li>解析结束元素调用的方法</li>
            <li>解析文本内容调用的方法</li></ol></li>
    <li>创建xml文件输入流，开始解析xml文件：</li>
</ol>

<p>SAX是从上往下依次解析xml文档的，所以解析的过程并不具备层次性，从输入流开始的地方解析，根据解析到的不同的元素、内容回调合适的方法进行解析，下面是一个以teacher.xml文件为例的解析实例， 将从xml文件中解析出来的teacher的id、name以及desc存入一个Teacher对象中，病输出：</p>



<h4 id="teacherxml文件如下"><strong>teacher.xml文件如下：</strong></h4>



<pre class="prettyprint"><code class=" hljs xml"><span class="hljs-pi">&lt;?xml version="1.0" encoding="UTF-8"?&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-title">person</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-title">teacher</span> <span class="hljs-attribute">id</span>=<span class="hljs-value">"1"</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-title">name</span>&gt;</span>小白<span class="hljs-tag">&lt;/<span class="hljs-title">name</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-title">desc</span>&gt;</span>小白人<span class="hljs-tag">&lt;/<span class="hljs-title">desc</span>&gt;</span>
    <span class="hljs-tag">&lt;/<span class="hljs-title">teacher</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-title">teacher</span> <span class="hljs-attribute">id</span>=<span class="hljs-value">"2"</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-title">name</span>&gt;</span>小黑<span class="hljs-tag">&lt;/<span class="hljs-title">name</span>&gt;</span>
    <span class="hljs-tag">&lt;<span class="hljs-title">desc</span>&gt;</span>小黑人<span class="hljs-tag">&lt;/<span class="hljs-title">desc</span>&gt;</span>
    <span class="hljs-tag">&lt;/<span class="hljs-title">teacher</span>&gt;</span>
    <span class="hljs-tag">&lt;/<span class="hljs-title">person</span>&gt;</span></code></pre>



<h4 id="要存入的teacher类定义如下">要存入的Teacher类定义如下：</h4>



<pre class="prettyprint"><code class=" hljs java"><span class="hljs-keyword">package</span> xml;
<span class="hljs-javadoc">/**
 * Created by zhuxinquan on 16-1-20.
 */</span>
    <span class="hljs-keyword">public</span> <span class="hljs-class"><span class="hljs-keyword">class</span> <span class="hljs-title">Teacher</span> {</span>
    <span class="hljs-keyword">private</span> <span class="hljs-keyword">int</span> id;
    <span class="hljs-keyword">private</span> String name;
    <span class="hljs-keyword">private</span> String desc;

    <span class="hljs-annotation">@Override</span>
    <span class="hljs-keyword">public</span> String <span class="hljs-title">toString</span>() {
    <span class="hljs-keyword">return</span> <span class="hljs-string">"Teacher{"</span> +
    <span class="hljs-string">"id="</span> + id +
    <span class="hljs-string">", name='"</span> + name + <span class="hljs-string">'\''</span> +
    <span class="hljs-string">", desc='"</span> + desc + <span class="hljs-string">'\''</span> +
    <span class="hljs-string">'}'</span>;
    }

    <span class="hljs-keyword">public</span> <span class="hljs-title">Teacher</span>() {
    }

    <span class="hljs-keyword">public</span> <span class="hljs-title">Teacher</span>(<span class="hljs-keyword">int</span> id, String name, String desc) {

    <span class="hljs-keyword">this</span>.id = id;
    <span class="hljs-keyword">this</span>.name = name;
    <span class="hljs-keyword">this</span>.desc = desc;
    }

    <span class="hljs-keyword">public</span> <span class="hljs-keyword">int</span> <span class="hljs-title">getId</span>() {

    <span class="hljs-keyword">return</span> id;
    }

    <span class="hljs-keyword">public</span> <span class="hljs-keyword">void</span> <span class="hljs-title">setId</span>(<span class="hljs-keyword">int</span> id) {
    <span class="hljs-keyword">this</span>.id = id;
    }

    <span class="hljs-keyword">public</span> String <span class="hljs-title">getName</span>() {
    <span class="hljs-keyword">return</span> name;
    }

    <span class="hljs-keyword">public</span> <span class="hljs-keyword">void</span> <span class="hljs-title">setName</span>(String name) {
    <span class="hljs-keyword">this</span>.name = name;
    }

    <span class="hljs-keyword">public</span> String <span class="hljs-title">getDesc</span>() {
    <span class="hljs-keyword">return</span> desc;
    }

    <span class="hljs-keyword">public</span> <span class="hljs-keyword">void</span> <span class="hljs-title">setDesc</span>(String desc) {
    <span class="hljs-keyword">this</span>.desc = desc;
    }
    }</code></pre>



<h4 id="下面是sax解析xml文件的源代码">下面是SAX解析xml文件的源代码：</h4>



<pre class="prettyprint"><code class=" hljs java"><span class="hljs-keyword">package</span> xml;

    <span class="hljs-keyword">import</span> org.xml.sax.InputSource;
    <span class="hljs-keyword">import</span> org.xml.sax.SAXException;

    <span class="hljs-keyword">import</span> javax.xml.parsers.ParserConfigurationException;
    <span class="hljs-keyword">import</span> javax.xml.parsers.SAXParser;
    <span class="hljs-keyword">import</span> javax.xml.parsers.SAXParserFactory;
    <span class="hljs-keyword">import</span> java.io.FileInputStream;
    <span class="hljs-keyword">import</span> java.io.FileNotFoundException;
    <span class="hljs-keyword">import</span> java.io.IOException;
    <span class="hljs-keyword">import</span> java.io.InputStream;
    <span class="hljs-keyword">import</span> java.util.List;

<span class="hljs-javadoc">/**
 * Created by zhuxinquan on 16-1-22.
 */</span>
    <span class="hljs-keyword">public</span> <span class="hljs-class"><span class="hljs-keyword">class</span> <span class="hljs-title">SaxParseDemo</span> {</span>
    <span class="hljs-keyword">public</span> <span class="hljs-keyword">static</span> <span class="hljs-keyword">void</span> <span class="hljs-title">main</span>(String[] args) <span class="hljs-keyword">throws</span> ParserConfigurationException, SAXException, IOException {
    <span class="hljs-comment">//创建SAX解析器工厂</span>
    SAXParserFactory factory = SAXParserFactory.newInstance();
    <span class="hljs-comment">//根据工厂创建解析器对象</span>
    SAXParser sax = factory.newSAXParser();

    PersonHandler ph = <span class="hljs-keyword">new</span> PersonHandler();
    <span class="hljs-comment">//开始解析</span>
    sax.parse((InputStream) <span class="hljs-keyword">new</span> FileInputStream(<span class="hljs-string">"teacher.xml"</span>), ph);
    List&lt;Teacher&gt; list = ph.getTeachers();
    System.out.println(list);
    }
    }</code></pre>



<h4 id="如同上面介绍的步骤一样该文件主要定义解析器工厂解析器对象以及声明内容解析对象xml文件的主要解析在与定义的内容解析内容如下">如同上面介绍的步骤一样，该文件主要定义解析器工厂、解析器对象以及声明内容解析对象，xml文件的主要解析在与定义的内容解析内容，如下：</h4>



<pre class="prettyprint"><code class=" hljs java"><span class="hljs-keyword">package</span> xml;

    <span class="hljs-keyword">import</span> org.xml.sax.Attributes;
    <span class="hljs-keyword">import</span> org.xml.sax.SAXException;
    <span class="hljs-keyword">import</span> org.xml.sax.helpers.DefaultHandler;

    <span class="hljs-keyword">import</span> java.util.ArrayList;
    <span class="hljs-keyword">import</span> java.util.List;

<span class="hljs-javadoc">/**
 * SAX解析的内容处理器
 * 进行回调使用
 * Created by zhuxinquan on 16-1-22.
 */</span>
    <span class="hljs-keyword">public</span> <span class="hljs-class"><span class="hljs-keyword">class</span> <span class="hljs-title">PersonHandler</span> <span class="hljs-keyword">extends</span> <span class="hljs-title">DefaultHandler</span> {</span>

    <span class="hljs-keyword">private</span> List&lt;Teacher&gt; teachers = <span class="hljs-keyword">null</span>;
    <span class="hljs-keyword">private</span> Teacher teacher;
    <span class="hljs-keyword">private</span> String tag;


    <span class="hljs-comment">//开始解析文档时调用的方法</span>

    <span class="hljs-keyword">public</span> List&lt;Teacher&gt; <span class="hljs-title">getTeachers</span>() {
    <span class="hljs-keyword">return</span> teachers;
    }

    <span class="hljs-keyword">public</span> <span class="hljs-keyword">void</span> <span class="hljs-title">setTeachers</span>(List&lt;Teacher&gt; teachers) {
    <span class="hljs-keyword">this</span>.teachers = teachers;
    }

    <span class="hljs-annotation">@Override</span>
    <span class="hljs-keyword">public</span> <span class="hljs-keyword">void</span> <span class="hljs-title">startDocument</span>() <span class="hljs-keyword">throws</span> SAXException {
    teachers = <span class="hljs-keyword">new</span> ArrayList&lt;Teacher&gt;();
    }


    <span class="hljs-javadoc">/**
     * 解析开始标签时调用的方法
     *<span class="hljs-javadoctag"> @param</span> uri:命名空间
     *<span class="hljs-javadoctag"> @param</span> localName：元素的本地名称，即元素名（标签名），不带前缀
     *<span class="hljs-javadoctag"> @param</span> qName：带前缀的元素名称
     *<span class="hljs-javadoctag"> @param</span> attributes：存储标签元素的属性
     *<span class="hljs-javadoctag"> @throws</span> SAXException
     */</span>
    <span class="hljs-annotation">@Override</span>
    <span class="hljs-keyword">public</span> <span class="hljs-keyword">void</span> <span class="hljs-title">startElement</span>(String uri, String localName, String qName, Attributes attributes) <span class="hljs-keyword">throws</span> SAXException {
    <span class="hljs-keyword">if</span>(<span class="hljs-string">"teacher"</span>.equals(qName)){
    teacher = <span class="hljs-keyword">new</span> Teacher();
    <span class="hljs-comment">//取出属性并添加到teacher中</span>
    teacher.setId(Integer.parseInt(attributes.getValue(<span class="hljs-string">"id"</span>)));
    }
    tag = qName;
    }

    <span class="hljs-comment">//解析结束标签时调用的方法</span>
    <span class="hljs-annotation">@Override</span>
    <span class="hljs-keyword">public</span> <span class="hljs-keyword">void</span> <span class="hljs-title">endElement</span>(String uri, String localName, String qName) <span class="hljs-keyword">throws</span> SAXException {
    <span class="hljs-keyword">if</span>(<span class="hljs-string">"teacher"</span>.equals(qName)){
    teachers.add(teacher);
    }
    tag = <span class="hljs-keyword">null</span>;
    }

    <span class="hljs-comment">//xml文档解析完成调用的方法</span>
    <span class="hljs-annotation">@Override</span>
    <span class="hljs-keyword">public</span> <span class="hljs-keyword">void</span> <span class="hljs-title">endDocument</span>() <span class="hljs-keyword">throws</span> SAXException {
    System.out.println(<span class="hljs-string">"XML解析完毕！"</span>);
    }

    <span class="hljs-comment">//解析文本内容时调用的方法</span>
    <span class="hljs-annotation">@Override</span>
    <span class="hljs-keyword">public</span> <span class="hljs-keyword">void</span> <span class="hljs-title">characters</span>(<span class="hljs-keyword">char</span>[] ch, <span class="hljs-keyword">int</span> start, <span class="hljs-keyword">int</span> length) <span class="hljs-keyword">throws</span> SAXException {
    <span class="hljs-keyword">if</span>(tag != <span class="hljs-keyword">null</span>){
    <span class="hljs-comment">//取出属性并添加到teacher中</span>
    <span class="hljs-keyword">if</span>(<span class="hljs-string">"name"</span>.equals(tag)){
    teacher.setName(<span class="hljs-keyword">new</span> String(ch, start, length));
    }<span class="hljs-keyword">else</span> <span class="hljs-keyword">if</span>(<span class="hljs-string">"desc"</span>.equals(tag)){
    teacher.setDesc(<span class="hljs-keyword">new</span> String(ch, start, length));
    }
    }
    }
    }</code></pre>



<h4 id="sax解析的内容处理器一般继承defaulthandler类该类中包含了处理xml文档的元素以及文本的许多处理方法在实际应用中需要使用什么方法时再去实现它">SAX解析的内容处理器一般继承DefaultHandler类，该类中包含了处理xml文档的元素以及文本的许多处理方法，在实际应用中需要使用什么方法时，再去实现它。</h4>



<h4 id="上面几个源代码可以在这里找到">上面几个源代码可以在<a href="https://github.com/zhuxinquan/JAVA/tree/master/XMLExercise" target="&quot;_blank">这里找到</a>;</h4>

<h5 id="初次学习错误之处还望指正">！！初次学习，错误之处还望指正～～～</h5>
<div>
    作者：zhuxinquan61 发表于2016/1/22 16:54:19 <a href="http://blog.csdn.net/zhuxinquan61/article/details/50562312">原文链接</a>
</div>
<div>
    阅读：52 评论：1 <a href="http://blog.csdn.net/zhuxinquan61/article/details/50562312#comments" target="_blank">查看评论</a>
</div>
</body>
</html>
