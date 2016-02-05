package JdbcConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by zhuxinquan on 16-2-5.
 */
public class PreparedStatementDemo {

    public final static String URL = "jdbc:mysql://localhost:3306/test?characterEncoding=utf-8";
    public final static String USERNAME = "root";
    public final static String PASSWD = "2737353904";
    public final static String Driver = "com.mysql.jdbc.Driver";


    public static void insert(Person p){
        try {
            Class.forName(Driver);
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWD);
            String sql = "insert into person(name, age, description) values(?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getName());
            ps.setInt(2, p.getAge());
            ps.setString(3, p.getDescription());

            ps.executeUpdate();
            ps.close();
            conn.close();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Person p = new Person("测试3", 23, "ceshi 3");
        insert(p);
    }
}