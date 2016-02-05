package JdbcConnect;

import java.sql.*;

/**
 * Created by zhuxinquan on 16-2-4.
 */
public class JdbaQueryDemo {
    public final static String URL = "jdbc:mysql://localhost:3306/test?characterEncoding=utf-8";
    public final static String USERNAME = "root";
    public final static String PASSWD = "2737353904";
    public final static String Driver = "com.mysql.jdbc.Driver";

    public static void query(){
        try {
            Class.forName(Driver);
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWD);
            String sql = "select id, name, age, description from person";
            Statement state = conn.createStatement();
            //返回sql操作影响的行数
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()){
                int id = rs.getInt(1);
                System.out.println(id);
            }
            rs.close();
            state.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        query();
    }
}
