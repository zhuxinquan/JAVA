package com.blog;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by zhuxinquan on 16-4-14.
 */
public class Main {
    public static void main(String[] args) {
        java.sql.Connection conn = DBUtils.getConnection();
        PreparedStatement ps = null;
        GetContentInfo getInfo = null;
        String queryUrl = "select * from user";
        ResultSet rs = null;
        String urlRss = null;
        try {
            ps = conn.prepareStatement(queryUrl);
            rs = ps.executeQuery();
            while(rs.next()){
                urlRss = rs.getString("rssUrl");
                getInfo = new GetContentInfo(urlRss);
                getInfo.getContentInfo();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
