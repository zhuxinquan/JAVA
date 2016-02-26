package saveBookInfoToXml;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by zhuxinquan on 16-2-26.
 */
public class SaveDatabase {

    public final static String URL = "jdbc:mysql://localhost:3306/book?characterEncoding=utf-8";
    public final static String USERNAME = "root";
    public final static String PASSWD = "2737353904";
    public final static String Driver = "com.mysql.jdbc.Driver";

    public SaveDatabase(Book b){
        try {
            Class.forName(Driver);
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWD);
            String sql = "insert into bookinfo(name, author, publishing, publishDate, pages, price, contentInfo, authorInfo) values(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            try{
                ps.setString(1, b.getName());
                ps.setString(2, b.getAuthor());
                ps.setString(3, b.getPublishing());
                ps.setString(4, b.getPublishDate());
                ps.setInt(5, Integer.parseInt(b.getPages()));
                ps.setFloat(6, Float.parseFloat(b.getPrice()));
                ps.setString(7, b.getContentInfo());
                ps.setString(8, b.getAuthorInfo());
            }catch (NullPointerException e){
                //
            }


            ps.executeUpdate();
            ps.close();
            conn.close();

        } catch (SQLException e) {
//            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            //e.printStackTrace();
        }
    }
}
