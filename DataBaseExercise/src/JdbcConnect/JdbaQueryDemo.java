package JdbcConnect;

import java.sql.*;

/**
 * Created by zhuxinquan on 16-2-4.
 */
public class JdbaQueryDemo {
    public final static String URL = "jdbc:mysql://localhost:3306/sfd-sign-up?characterEncoding=utf-8";
    public final static String USERNAME = "root";
    public final static String PASSWD = "2737353904";
    public final static String Driver = "com.mysql.jdbc.Driver";

    public static void query(){
        try {
            Class.forName(Driver);
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWD);
            String sql = "select email FROM `userinfo` WHERE `sno` LIKE '%16%'";
            PreparedStatement state = conn.prepareStatement(sql);
//            state.setInt(1, 9);
            //返回查询的结果集的引用
            ResultSet rs = state.executeQuery();
            while (rs.next()){
                System.out.print(rs.getString("email") + ";");
//                int id = rs.getInt(1);
//                System.out.println(id);
//                System.out.println(rs.getString(2) + rs.getInt(3) + rs.getString(4));
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
