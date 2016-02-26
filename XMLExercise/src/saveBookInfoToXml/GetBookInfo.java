package saveBookInfoToXml;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhuxinquan on 16-2-17.
 */

public class GetBookInfo extends Thread{
    private static String url;

    public GetBookInfo(String url){
        this.url = url;
    }

    public void run(){
        System.out.println(Thread.currentThread().getName());
        Main main = new Main();
        Book b = new Book();
        Document doc = null;
        try {
            doc = (Document) Jsoup.connect(url).timeout(10000).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        System.out.println(doc.toString());
        String html = doc.toString();
        Pattern reg_htm = Pattern.compile("<[^>]+>");  //匹配html标签
        Pattern reg_name_ = Pattern.compile("&middot;");       //匹配英文人名中间的点
        Pattern reg_nbsp = Pattern.compile("&nbsp;");           //匹配空格
        Pattern reg_nbsp1 = Pattern.compile(" ");               //匹配实际空格
        Pattern reg_br = Pattern.compile("\n");                 //匹配换行符
        //匹配书名
        Pattern reg_name = Pattern.compile("<span property=\"v:itemreviewed\".*?</span>");
        //匹配作者
        Pattern reg_author = Pattern.compile("<span> <span class=\"pl\"> 作者</span>: <a class=\"\" href=\".*?</a>");
        //匹配译者
        Pattern reg_translator = Pattern.compile("<span class=\"pl\"> 译者</span>: <a class=\"\" href=.*?</a>");
        //匹配出版社
        Pattern reg_publishing = Pattern.compile(" <span class=\"pl\">出版社:</span> .*?\n" +
                "          <br />");
        //得到书名
        Matcher m = reg_name.matcher(html);
        while(m.find()){
//            System.out.println(m.group(0));
            Matcher m1 = reg_htm.matcher(m.group(0));
            String name = m1.replaceAll("");
            m1 = reg_nbsp1.matcher(name);
            if(m1.find()){
                name =  m1.replaceAll("");
            }
            m1 = reg_br.matcher(name);
            if(m1.find()){
                name = m1.replaceAll("");
            }
//            System.out.println("书名：" + name);
            b.setName(name);
        }
        //得到作者
        m = reg_author.matcher(html);
        while(m.find()){
            String author = m.group(0);
//            System.out.println(m.group(0));
            //去除“作者”
            Pattern reg_au = Pattern.compile(" 作者</span>: ");
            Matcher m1 = reg_au.matcher(author);
            if(m1.find()){
                author = m1.replaceAll("");
            }
            //去除html标签
            m1 = reg_htm.matcher(author);
            if(m1.find()){
                author = m1.replaceAll("");
            }
            //改变英文作者名称中的点
            m1 = reg_name_.matcher(author);
            if(m1.find()){
                author = m1.replaceAll("·");
            }
            m1 = reg_nbsp1.matcher(author);
            if(m1.find()){
                author =  m1.replaceAll("");
            }
            m1 = reg_br.matcher(author);
            if(m1.find()){
                author = m1.replaceAll("");
            }
//            System.out.println("作者：" + author);
            b.setAuthor(author);
        }
        //得到出版社
        m = reg_publishing.matcher(html);
        while(m.find()){
            String publishing = m.group(0);
            Pattern reg_pub = Pattern.compile("出版社:");
            Matcher m1 = reg_pub.matcher(publishing);
            if(m1.find()){
                publishing = m1.replaceAll("");
            }
            m1 = reg_htm.matcher(publishing);
            if(m1.find()){
                publishing = m1.replaceAll("");
            }
            m1 = reg_nbsp1.matcher(publishing);
            if(m1.find()){
                publishing =  m1.replaceAll("");
            }
            m1 = reg_br.matcher(publishing);
            if(m1.find()){
                publishing = m1.replaceAll("");
            }
//            System.out.println("出版社：" + publishing);
            b.setPublishing(publishing);
        }
        //得到出版日期
        Pattern reg_category = Pattern.compile("<span class=\"pl\">出版年:</span>.*?\n" +
                "          <br />");
        m = reg_category.matcher(html);
        while(m.find()){
            String publishDate = m.group(0);
            Pattern reg_publishDate = Pattern.compile("出版年:");
            Matcher m1 = reg_publishDate.matcher(publishDate);
            if(m1.find()){
                publishDate = m1.replaceAll("");
            }
            m1 = reg_htm.matcher(publishDate);
            if(m1.find()){
                publishDate = m1.replaceAll("");
            }
            m1 = reg_nbsp1.matcher(publishDate);
            if(m1.find()){
                publishDate =  m1.replaceAll("");
            }
            m1 = reg_br.matcher(publishDate);
            if(m1.find()){
                publishDate = m1.replaceAll("");
            }
//            System.out.println("出版年：" + publishDate);
            b.setPublishDate(publishDate);
        }

        //得到定价
        Pattern reg_price = Pattern.compile("<span class=\"pl\">定价:</span>(.*?)\n" +
                "          <br />");
        m = reg_price.matcher(html);
        String price;
        if(m.find()){
            price = m.group(0);
            Pattern reg_price1 = Pattern.compile("定价:");
            Matcher m1 = reg_nbsp1.matcher(price);
            if(m1.find()){
                price = m1.replaceAll("");
            }
            m1 = reg_price1.matcher(price);
            if(m1.find()){
                price = m1.replaceAll("");
            }
            reg_price1 = Pattern.compile("元");
            m1 = reg_price1.matcher(price);
            if(m1.find()){
                price = m1.replaceAll("");
            }
            m1 = reg_htm.matcher(price);
            if(m1.find()){
                price = m1.replaceAll("");
            }
            m1 = reg_br.matcher(price);
            if(m1.find()){
                price = m1.replaceAll("");
            }
//            System.out.println("定价：" + price);
            b.setPrice(price);
        }

        //得到页数
        Pattern reg_pagenum = Pattern.compile("<span class=\"pl\">页数:</span>(.*?)\n" +
                "          <br />");
        m = reg_pagenum.matcher(html);
        String pagenum;
        if(m.find()){
            pagenum = m.group(0);
            Pattern reg_page1 = Pattern.compile("页数:");
            Matcher m1 = reg_nbsp1.matcher(pagenum);
            if(m1.find()){
                pagenum = m1.replaceAll("");
            }
            m1 = reg_page1.matcher(pagenum);
            if(m1.find()){
                pagenum = m1.replaceAll("");
            }
            m1 = reg_htm.matcher(pagenum);
            if(m1.find()){
                pagenum = m1.replaceAll("");
            }
            m1 = reg_br.matcher(pagenum);
            if(m1.find()){
                pagenum = m1.replaceAll("");
            }
//            System.out.println("页数：" + pagenum);
            b.setPages(pagenum);
        }


        //得到内容简介
        String contentInfo;
        String authorInfo;
        Pattern reg_content = Pattern.compile("(?s)<span class=\"\">内容简介</span>(.*?)</div>");
        m = reg_content.matcher(html);
        while(m.find()){
            contentInfo = m.group(0);
//            System.out.println(m.group(0));
            Pattern reg_intro = Pattern.compile("(?s)<div class=\"intro\">(.*?)</div>");
            m = reg_intro.matcher(contentInfo);
            if(m.find()){
                contentInfo = m.group(0);
                Matcher m1 = reg_htm.matcher(contentInfo);
                if(m1.find()){
                    contentInfo = m1.replaceAll("");
                }
                //替换英文名中的间隔点
                Matcher m2 = reg_name_.matcher(contentInfo);
                if(m2.find()){
                    contentInfo = m2.replaceAll("·");
                }
                m1 = reg_nbsp1.matcher(contentInfo);
                if(m1.find()) {
                    contentInfo = m1.replaceAll("");
                }
                m1 = reg_br.matcher(contentInfo);
                if(m1.find()){
                    contentInfo = m1.replaceAll("");
                }
//                System.out.println("内容简介：" + contentInfo);
                b.setContentInfo(contentInfo);
            }
        }

        //得到作者简介
        Pattern reg_authorInfo = Pattern.compile("(?s)<span class=\"\">作者简介</span>(.*?)</div>");
        m = reg_authorInfo.matcher(html);
        while(m.find()){
            authorInfo = m.group(0);
//            System.out.println(m.group(0));
            Pattern reg_intro = Pattern.compile("(?s)<div class=\"intro\">(.*?)</div>");
            m = reg_intro.matcher(authorInfo);
            if(m.find()){
                authorInfo = m.group(0);
                Matcher m1 = reg_htm.matcher(authorInfo);
                if(m1.find()){
                    authorInfo = m1.replaceAll("");
                }
                //替换英文名中的间隔点
                Matcher m2 = reg_name_.matcher(authorInfo);
                if(m2.find()){
                    authorInfo = m2.replaceAll("·");
                }
                m1 = reg_nbsp1.matcher(authorInfo);
                if(m1.find()) {
                    authorInfo = m1.replaceAll("");
                }
                m1 = reg_br.matcher(authorInfo);
                if(m1.find()){
                    authorInfo = m1.replaceAll("");
                }
//                System.out.println("作者简介：" + authorInfo);
                b.setAuthorInfo(authorInfo);
            }
        }



        System.out.println(b);
        synchronized (main){
            System.out.println("执行中");
            main.addBookInfo(b);
        }
        SaveDatabase sd = new SaveDatabase(b);
        WriteXmlFile w = new WriteXmlFile(b);
    }
}

class test{
    public static void main(String[] args) {
        GetBookInfo getBookInfo = new GetBookInfo("http://book.douban.com/subject/26376603/");
        Thread t = new Thread(getBookInfo);
        t.start();
    }
}
