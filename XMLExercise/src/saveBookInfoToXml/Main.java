package saveBookInfoToXml;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhuxinquan on 16-2-17.
 */
public class Main {
    private static List<String> pageUrl = new LinkedList<>();           //书籍详情页链接
    private List<Book> booksInfo = new LinkedList<>();    //书籍介绍集合

    public static void main(String[] args) throws IOException, InterruptedException {
        GetPageUrl getUrl = new GetPageUrl();
        System.out.println(pageUrl);
//        System.out.println(pageUrl.size());
        for (int i = 0; i < pageUrl.size(); i++) {
            GetBookInfo getBookInfo = new GetBookInfo(pageUrl.get(i));
            Thread t = new Thread(getBookInfo);
            t.start();
        }
    }

    public void addPageUrl(String url){
        pageUrl.add(url);
    }

    public void addBookInfo(Book b){
        booksInfo.add(b);
    }
}
