package com.blog;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by zhuxinquan on 16-4-14.
 */
public class GetContentInfo {
    private String url;
    private List<ContentInfo> contentInfos = new ArrayList<ContentInfo>();

    public GetContentInfo() {
    }

    public GetContentInfo(String url) {
        this.url = url;
    }

    public List<ContentInfo> getContentInfo() {

        HttpClient httpclient = new DefaultHttpClient();
//        httpclient.getParams().setParameter("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.64 Safari/537.11");
//        httpclient.getParams().setParameter("Accept-Charset", "zh_cn");
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


        System.out.println(html);
        //

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

        //得到item标签及其中的内容
        NodeList items = element.getElementsByTagName("entry");
        for (int i = 0; i < items.getLength(); i++) {
            ContentInfo contentInfo = new ContentInfo();
            Element item = (Element) items.item(i);
            NodeList childNodes = item.getChildNodes();
            for (int j = 0; j < childNodes.getLength(); j++) {
                //Dom将最小标签中的内容仍然当做一个子结点
                if("title".equals(childNodes.item(j).getNodeName())) {
                    System.out.println("title: " + childNodes.item(j).getFirstChild().getNodeValue());
                    contentInfo.setTitle(childNodes.item(j).getFirstChild().getNodeValue());
                }else if("link".equals(childNodes.item(j).getNodeName())) {
                    System.out.println("link: " + childNodes.item(j).getFirstChild().getNodeValue());
                    contentInfo.setLink(childNodes.item(j).getFirstChild().getNodeValue());
                }else if("guid".equals(childNodes.item(j).getNodeName())) {
                    System.out.println("guid: " +childNodes.item(j).getFirstChild().getNodeValue());
                    contentInfo.setGuid(childNodes.item(j).getFirstChild().getNodeValue());
                }else if("author".equals(childNodes.item(j).getNodeName())) {
                    System.out.println("author: " + childNodes.item(j).getFirstChild().getNodeValue());
                    contentInfo.setAuthor(childNodes.item(j).getFirstChild().getNodeValue());
                }else if("pubDate".equals(childNodes.item(j).getNodeName())) {
                    System.out.println("pubDate: " + childNodes.item(j).getFirstChild().getNodeValue());
                    contentInfo.setPubDate(childNodes.item(j).getFirstChild().getNodeValue());
                }else if("description".equals(childNodes.item(j).getNodeName())) {
                    System.out.println("description: " + childNodes.item(j).getFirstChild().getNodeValue());
                    contentInfo.setPubDate(childNodes.item(j).getFirstChild().getNodeValue());
                }else if("content:encoded".equals(childNodes.item(j).getNodeName())){
                    System.out.println("content：" + childNodes.item(j).getFirstChild().getNodeValue());
//                    contentInfo.setPubDate(childNodes.item(j).getFirstChild().getNodeValue());
                }
//                }else if("category".equals(childNodes.item(j).getNodeName())) {
//                    System.out.println(childNodes.item(j).getFirstChild().getNodeValue());
//                    contentInfo.set(childNodes.item(j).getFirstChild().getNodeValue());
//                }
            }
            System.out.println("------------------");
        }

        System.out.println("----------------");
        return contentInfos;
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
