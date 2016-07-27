package com.get_blog_content;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by zhuxinquan on 16-7-26.
 */
public class BlogContentCrud {

    public static void storeBlogContentCollection(Collection<BlogContentInfo> c){
        PreparedStatement ps = null;
        Connection conn = null;
        conn = DBUtils.getConnection();
        String sql = "insert into T_blog(BlogAddress, BlogArticleLink, Title, Author, PubDate, ArticleDetail, Summary, Category) values(?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = conn.prepareStatement(sql);
            for(BlogContentInfo blog: c){
                ps.setString(1, blog.getBlogAddress());
                ps.setString(2, blog.getBlogArticleLink());
                ps.setString(3, blog.getTitle());
                ps.setString(4, blog.getAuthor());
                ps.setString(5, blog.getPubDate());
                ps.setString(6, blog.getArticleDetail());
                ps.setString(7, blog.getSummary());
                ps.setString(8, blog.getCategory());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(null, ps, conn);
        }
    }

    public static void insert(BlogContentInfo blog) {
        PreparedStatement ps = null;
        Connection conn = null;

        conn = DBUtils.getConnection();
        try {
            String sql = "insert into T_blog(BlogAddress, BlogArticleLink, Title, Author, PubDate, ArticleDetail, Summary, Category) values(?, ?, ?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, blog.getBlogAddress());
            ps.setString(2, blog.getBlogArticleLink());
            ps.setString(3, blog.getTitle());
            ps.setString(4, blog.getAuthor());
            ps.setString(5, blog.getPubDate());
            ps.setString(6, blog.getArticleDetail());
            ps.setString(7, blog.getSummary());
            ps.setString(8, blog.getCategory());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(null, ps, conn);
        }
    }
}
