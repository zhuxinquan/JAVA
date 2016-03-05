package JdbcConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Jdbc事物处理
 * 设置手动提交
 * 出错则回滚
 * Created by zhuxinquan on 16-3-5.
 */
public class JdbcTransaction {
    public static void transactionTest(){
        Connection conn = DBUtils.getConnection();
        try {
            //设置为手动提交
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql1 = "insert into person values(?, ?)";
        String sql2 = "update person set name = ? where age = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql1);
            ps.setString(1, "test1");
            ps.setInt(2, 1);
            ps.executeUpdate();

            ps = conn.prepareStatement(sql2);
            ps.setInt(2, 22);;
            ps.setString(1, "testtest2");
            ps.executeUpdate();

            //提交
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                //事物回滚
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

    }
    public static void main(String[] args) {
        transactionTest();
    }
}
