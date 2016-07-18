package test;
import java.sql.*;
import java.util.ResourceBundle;

public class JdbcCnt {

    static Connection conn = null;
    private JdbcCnt(){}

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/qiandao?" + "user=root&&password=2737353904&&useUnicode=true&&characterEncoding=UTF8";
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("获取链接失败");
        }
        return conn;
    }


    public static void close(ResultSet rs, Statement stml, Connection conn) {
        try {
            if(rs != null)  rs.close();
            if(stml != null) stml.close();
            if(conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}