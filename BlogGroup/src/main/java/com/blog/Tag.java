package com.blog;

/**
 * Created by zhuxinquan on 16-4-25.
 */
public class Tag {
    private String type;
    private String author;
    private String authorInner;
    private String pubDate;
    private String title;
    private String content;
    private String link;
    private String category;

    public Tag() {
    }

    public Tag(String type, String author, String authorInner, String pubDate, String title, String content, String link, String category) {
        this.type = type;
        this.author = author;
        this.authorInner = authorInner;
        this.pubDate = pubDate;
        this.title = title;
        this.content = content;
        this.link = link;
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthorInner() {
        return authorInner;
    }

    public void setAuthorInner(String authorInner) {
        this.authorInner = authorInner;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
