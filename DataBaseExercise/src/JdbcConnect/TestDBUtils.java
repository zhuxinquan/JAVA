package JdbcConnect;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by zhuxinquan on 16-3-5.
 */
public class TestDBUtils {

    public static void findAll(){
        //通过工具类获取数据库链接
        Connection conn = DBUtils.getConnection();
        String sql = "select * from movie_data where id < 10";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                System.out.println("id = " +rs.getInt(1));
                System.out.println("name = " + rs.getString(2));
                System.out.println("picture = " + rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(rs, ps, conn);
        }
    }

    public static void main(String[] args) {
        findAll();
    }
}
