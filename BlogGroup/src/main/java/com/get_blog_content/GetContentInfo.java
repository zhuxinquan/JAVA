package com.get_blog_content;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.omg.CORBA.TIMEOUT;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * Created by zhuxinquan on 16-4-14.
 */
public class GetContentInfo {
    public static void main(String[] args) {
        GetContentInfo info = new GetContentInfo(new User("刘", "http://feed.cnblogs.com/blog/u/39275/rss", "cnblogs", "2014", Time.getStandardTime("2009-09-08T07:50:00Z")),
                Tag.getTag("cnblog"));
        Collection<BlogContentInfo> bs = info.getContentInfo();
        for(BlogContentInfo b : bs){
            System.out.println(b);
        }
    }
    private String url;
    private String blogType;
    private String updateTime;
    private Tag tag = null;
    private User u = null;
    private BlogContentInfo blogContentInfo = null;
    private List<BlogContentInfo> blogContentInfos = new ArrayList<BlogContentInfo>();

    public GetContentInfo(User user, Tag t) {
        this.u = user;
        this.url = user.getBlogAddress();
        this.blogType = user.getBlogType();
        tag = t;
        this.updateTime = user.getUpdateTime();
    }

    /**
     * 文档解析
     * @param inputStream
     * @return
     */
    public List<BlogContentInfo> doDocumentBuild(InputStream inputStream){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        org.w3c.dom.Document document = null;
        try {
            document = builder.parse(inputStream);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Element element = document.getDocumentElement();
        NodeList items = element.getElementsByTagName(tag.getItem());
        //System.out.println(items.getLength());
        for (int i = 0; i < items.getLength(); i++) {
            //System.out.println("============================================");
            blogContentInfo = new BlogContentInfo();
            Element item = (Element) items.item(i);
            NodeList itemChildNode = item.getChildNodes();
            for(int j = 0; j < itemChildNode.getLength(); j++){
                if(tag.getTitle().equals(itemChildNode.item(j).getNodeName())) {
                    //System.out.println("title: " + itemChildNode.item(j).getFirstChild().getNodeValue());
                    blogContentInfo.setTitle(itemChildNode.item(j).getFirstChild().getNodeValue());
                }else if(tag.getBlogArticleLink().equals(itemChildNode.item(j).getNodeName())) {
                    //System.out.println("link: " + itemChildNode.item(j).getFirstChild().getNodeValue());
                    blogContentInfo.setBlogArticleLink(itemChildNode.item(j).getFirstChild().getNodeValue());
                }else if(tag.getAuthor().equals(itemChildNode.item(j).getNodeName())) {
                    if("feed".equals(tag.getRss())){
                        NodeList authorList = itemChildNode.item(j).getChildNodes();
                        for(int k = 0; k < authorList.getLength(); k++){
                            if("name".equals(authorList.item(k).getNodeName())){
                                //System.out.println("author: " + authorList.item(k).getFirstChild().getNodeValue());
                                blogContentInfo.setAuthor(authorList.item(k).getFirstChild().getNodeValue());
                            }
                        }
                    }
                }else if(tag.getPublished().equals(itemChildNode.item(j).getNodeName())) {
                    //System.out.println("pubDate: " + Time.getStandardTime(itemChildNode.item(j).getFirstChild().getNodeValue()));
                    if(Time.getStandardTime(u.getUpdateTime()).compareTo(Time.getStandardTime(itemChildNode.item(j).getFirstChild().getNodeValue())) < 0){
                        blogContentInfo.setPubDate(Time.getStandardTime(itemChildNode.item(j).getFirstChild().getNodeValue()));
                    }else{
                        return blogContentInfos;
                    }
                }else if(itemChildNode.item(j).getNodeName().equals(tag.getSummary())) {
                    //System.out.println("description: " + itemChildNode.item(j).getFirstChild().getNodeValue());
                    blogContentInfo.setSummary(itemChildNode.item(j).getFirstChild().getNodeValue());
                }else if(tag.getContent().equals(itemChildNode.item(j).getNodeName())){
                    //System.out.println("content：" + itemChildNode.item(j).getFirstChild().getNodeValue());
                    blogContentInfo.setArticleDetail(itemChildNode.item(j).getFirstChild().getNodeValue());
                }else if(itemChildNode.item(j).getNodeName().equals(tag.getCategory())){
                    //System.out.println("Category：" + itemChildNode.item(j).getFirstChild().getNodeValue());
                    blogContentInfo.setCategory(itemChildNode.item(j).getFirstChild().getNodeValue());
                }
            }
            blogContentInfos.add(blogContentInfo);
        }
        return blogContentInfos;
    }

    public List<BlogContentInfo> getContentInfo() {
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpgets = new HttpGet(url);
        httpgets.setHeader("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.0.3) Gecko/2008092417 Firefox/3.0.3");
        HttpResponse response = null;
        try {
            response = httpclient.execute(httpgets);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpEntity entity = response.getEntity();
        Header hearder = entity.getContentType();
        String charsetName = "UTF-8";
        if(hearder != null){
            String s = hearder.getValue();
            if(s.matches("charset\\s?=\\s?(utf-?8)") || s.matches("charset\\s?=\\s?(UTF-?8)")){
                charsetName = "UTF-8";
            }else if(s.matches("(charset)\\s?=\\s?(gbk)") || s.matches("(charset)\\s?=\\s?(GBK)")){
                charsetName = "GBK";
            }else if(s.matches("(charset)\\s?=\\s?(gb2312)") || s.matches("(charset)\\s?=\\s?(GB2312)")){
                charsetName = "GB2312";
            }
        }
        String html = null;
        if (entity != null) {
            InputStream instreams = null;
            try {
                instreams = entity.getContent();
            } catch (IOException e) {
                e.printStackTrace();
            }
            html = convertStreamToString(instreams);
            httpgets.abort();
        }

//        System.out.println(html);

        //创建字节输入流
        Reader reader = new StringReader(html);
        InputStream inputStream = null;
//        System.out.println(html);
        try {
            inputStream = new ByteArrayInputStream(html.getBytes(charsetName));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doDocumentBuild(inputStream);
    }

    public static String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
