package com.get_blog_content;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by zhuxinquan on 16-4-25.
 */
public class Tag {
    private String BlogType;
    private String Rss;
    private String Updated;
    private String Item;
    private String BlogArticleLink;
    private String Title;
    private String Published;
    private String Author;
    private String Content;
    private String Category;
    private String Summary;

    public static Tag getTag(String blogType){
        Tag tag = new Tag();
        Connection conn = DBUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from T_tags where BlogType = '" + blogType + "'";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                tag.setBlogType(rs.getString("BlogType"));
                tag.setRss(rs.getString("Rss"));
                tag.setUpdated(rs.getString("Updated"));
                tag.setItem(rs.getString("Item"));
                tag.setBlogArticleLink(rs.getString("BlogArticleLink"));
                tag.setTitle(rs.getString("Title"));
                tag.setPublished(rs.getString("Published"));
                tag.setAuthor(rs.getString("Author"));
                tag.setContent(rs.getString("Content"));
                tag.setCategory(rs.getString("Category"));
                tag.setSummary(rs.getString("Summary"));
            }else {
                DBUtils.close(rs, ps, conn);
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(rs, ps, conn);
        }
        return tag;
    }

    public String getBlogType() {
        return BlogType;
    }

    public void setBlogType(String blogType) {
        BlogType = blogType;
    }

    public String getRss() {
        return Rss;
    }

    public void setRss(String rss) {
        Rss = rss;
    }

    public String getUpdated() {
        return Updated;
    }

    public void setUpdated(String updated) {
        Updated = updated;
    }

    public String getItem() {
        return Item;
    }

    public void setItem(String item) {
        Item = item;
    }

    public String getBlogArticleLink() {
        return BlogArticleLink;
    }

    public void setBlogArticleLink(String blogArticleLink) {
        BlogArticleLink = blogArticleLink;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getPublished() {
        return Published;
    }

    public void setPublished(String published) {
        Published = published;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getSummary() {
        return Summary;
    }

    public void setSummary(String summary) {
        Summary = summary;
    }

    @Override
    public String toString() {
        return "Tags{" +
                "BlogType='" + BlogType + '\'' +
                ", Rss='" + Rss + '\'' +
                ", Updated='" + Updated + '\'' +
                ", Item='" + Item + '\'' +
                ", BlogArticleLink='" + BlogArticleLink + '\'' +
                ", Title='" + Title + '\'' +
                ", Published='" + Published + '\'' +
                ", Author='" + Author + '\'' +
                ", Content='" + Content + '\'' +
                ", Category='" + Category + '\'' +
                ", Summary='" + Summary + '\'' +
                '}';
    }
}
