import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


@WebServlet("/register.do")
public class register extends HttpServlet {
    private final String SUCCESS_VIEW = "success.jsp";
    private final String ERROR_VIEW = "error.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String number = request.getParameter("Number");
        String name = request.getParameter("Name");
        //System.out.println(name);
        String result = ERROR_VIEW;

        List<String> errors = new ArrayList<String>();
        response.setContentType("text/html;charset=UTF-8");


        if (isInvalidNumber(number)) {
            errors.add("学号格式不正确/已存在！");
        }

        if (isInvalidName(name)) {
            errors.add("姓名为空");
        }

        if(!errors.isEmpty()) {
            request.setAttribute("errors", errors);
        } else {
            result = SUCCESS_VIEW;
            createUserData(number, name);
        }
        request.getRequestDispatcher(result).forward(request, response);
    }

    private boolean isInvalidNumber(String number) {

        ResourceBundle rb = ResourceBundle.getBundle("test.db-config");
        String URL = rb.getString("jdbc.URL");
        String USERNAME = rb.getString("jdbc.USERNAME");
        String PASSWD = rb.getString("jdbc.PASSWD");
        String Driver = rb.getString("jdbc.Driver");

        boolean resultanswer = false;
        Connection conn = null;
        Statement stml = null;

        if(number == null || number.length() != 8){
            resultanswer = true;
        }

//        String url = "jdbc:mysql://localhost:3306/qiandao?" +"user=root&&password=2737353904&&useUnicode=true&&characterEncoding=UTF8";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("加载失败！");
        }
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWD);
            stml = conn.createStatement();
            String sql = "select id from T_person where number ='" + number + "'";
            ResultSet rs = stml.executeQuery(sql);
            if (rs.next()) {
                resultanswer = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stml != null) {
                try {
                    stml.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return resultanswer;


    }

    private boolean isInvalidName(String name) {

        boolean resultanswer = false;
        if(name == null || name.trim().length() == 0){
            resultanswer = true;
        }

        return resultanswer;
    }

    private void createUserData(String number, String name) {

        ResourceBundle rb = ResourceBundle.getBundle("test.db-config");
        String URL = rb.getString("jdbc.URL");
        String USERNAME = rb.getString("jdbc.USERNAME");
        String PASSWD = rb.getString("jdbc.PASSWD");
        String Driver = rb.getString("jdbc.Driver");

        Connection conn = null;
        Statement stml = null;
//        String url = "jdbc:mysql://localhost:3306/qiandao?" + "user=root&&password=2737353904&&useUnicode=true&&characterEncoding=UTF8";
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWD);
            stml = conn.createStatement();
            // System.out.println(name);
            String sql = "insert into T_person(number,name) values('" + number + "','" + name + "')";
            PreparedStatement pstam = conn.prepareStatement(sql);
            pstam.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stml != null) {
                try {
                    stml.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}