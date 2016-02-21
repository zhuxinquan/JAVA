package saveBookInfoToXml;

/**
 * Created by zhuxinquan on 16-2-16.
 */
public class Book {
    private String name;    //书名
    private String author;  //作者
    private String publishing;  //出版社
    private String publishDate;         //出版日期
    private String pages;               //页数
    private String price;               //定价
    private String contentInfo;        //内容简介
    private String authorInfo;          //作者简介


    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publishing='" + publishing + '\'' +
                ", contentInfo='" + contentInfo + '\'' +
                ", authorInfo='" + authorInfo + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", pages='" + pages + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishing() {
        return publishing;
    }

    public void setPublishing(String publishing) {
        this.publishing = publishing;
    }

    public String getContentInfo() {
        return contentInfo;
    }

    public void setContentInfo(String contentInfo) {
        this.contentInfo = contentInfo;
    }

    public String getAuthorInfo() {
        return authorInfo;
    }

    public void setAuthorInfo(String authorInfo) {
        this.authorInfo = authorInfo;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
