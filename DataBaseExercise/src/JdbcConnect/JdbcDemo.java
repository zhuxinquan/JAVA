package JdbcConnect;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC增删改操作
 * Created by zhuxinquan on 16-2-3.
 */
public class JdbcDemo {

    public final static String URL = "jdbc:mysql://localhost:3306/test?characterEncoding=utf-8";
    public final static String USERNAME = "root";
    public final static String PASSWD = "2737353904";
    public final static String Driver = "com.mysql.jdbc.Driver";

    /**
     * 更新操作
     */
    public static void update(){
        try {
            Class.forName(Driver);
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWD);
            String sql = "update person set age = 19 where id = 3";
            Statement state = conn.createStatement();
            //返回sql操作影响的行数
            int num = state.executeUpdate(sql);
            System.out.println(num);
            state.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 插入操作
     */
    public static void insert(){
        try {
            //加载数据库驱动程序
            Class.forName(Driver);
            //获取数据库连接对象
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWD);
            //构造sql语句
            String sql = " insert into person(name, age, description) values('测试', 20, '测试1');";
            //构造statment实例（用来发送SQL语句的载体）
            Statement stat = conn.createStatement();
            //执行sql语句（发送给数据库）
            int num = stat.executeUpdate(sql);
            System.out.println(num);
            //关闭连接
            stat.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        update();
    }
}
