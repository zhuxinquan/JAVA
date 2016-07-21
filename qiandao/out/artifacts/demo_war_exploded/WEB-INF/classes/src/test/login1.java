package test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet("/login1.do")
public class login1 extends HttpServlet {

    private final String SUCCESS_VIEW = "lsuccess.jsp";
    private final String ERROR_VIEW  = "lerror.jsp";

    List<String> errorss = new ArrayList<String>();

    protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String number = request.getParameter("Number");
        String checknum = request.getParameter("check_num");
        response.setContentType("text/html;charset=UTF-8");

        String ip = request.getHeader(" x-forwarded-for ");
        if (ip == null || ip.length() == 0 || " unknown ".equalsIgnoreCase(ip)) {
            ip = request.getHeader(" Proxy-Client-IP ");
        }
        if (ip == null || ip.length() == 0 || " unknown ".equalsIgnoreCase(ip)) {
            ip = request.getHeader(" WL-Proxy-Client-IP ");
        }
        if (ip == null || ip.length() == 0 || " unknown ".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        if (getCheckNum(checknum)) {
            if (selectData(number)) {
                request.getRequestDispatcher(SUCCESS_VIEW).forward(request, response);
            } else {
                request.setAttribute("errorss", errorss);
                request.getRequestDispatcher(ERROR_VIEW).forward(request, response);
                errorss.clear();
            }
        }
        else{
            request.setAttribute("errorss", errorss);
            request.getRequestDispatcher(ERROR_VIEW).forward(request, response);
            errorss.clear();
        }
    }

    public boolean getCheckNum(String checknum){
        boolean result = false;
        if(checknum.equals(Check_num.check_num) && checknum != null && checknum.trim().length() != 0){
            result = true;
        }
        else{
            errorss.add("验证码不正确！");
        }
        return result;
    }

    public  boolean  getIpAddr(String ip)  {
        boolean result = false;
        if(ip.startsWith("192.168.30")){
            result = true;
        }
        else{
            errorss.add("ip地址不正确！");
        }
        return result;
    }

    private boolean selectData(String number){
        ResourceBundle rb = ResourceBundle.getBundle("test.db-config");
        String URL = rb.getString("jdbc.URL");
        String USERNAME = rb.getString("jdbc.USERNAME");
        String PASSWD = rb.getString("jdbc.PASSWD");
        String Driver = rb.getString("jdbc.Driver");
        Connection conn = null;
        Statement stml = null;
        Statement stml1 = null;
        boolean result = false;
//        String url = "jdbc:mysql://localhost:3306/qiandao?" + "user=root&&password=2737353904&&useUnicode=true&&characterEncoding=UTF8";
        if (number != null) {
            try {
                Class.forName(Driver);
                conn = DriverManager.getConnection(URL, USERNAME, PASSWD);
                stml = conn.createStatement();
                stml1 = conn.createStatement();
                String sql = "select * from T_person where number='" + number + "'";
                ResultSet rs = stml.executeQuery(sql);
                if (rs.next()) {
                    String inode = rs.getString("id");

                   // Date dates = new Date();
                    //long datem= dates.getTime();
                    // create a new calendar
                    Calendar cal2 = Calendar.getInstance();

                    // print the next time in milliseconds
                    long datem = cal2.getTimeInMillis();

                    SimpleDateFormat formats = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String time = formats.format(cal2.getTime());

                    Calendar c = Calendar.getInstance();
                    int year = c.get(Calendar.YEAR);
                    int month = c.get(Calendar.MONTH);
                    int day = c.get(Calendar.DATE);
                    int hour = c.get(Calendar.HOUR_OF_DAY);


                    if(hour < 19){
                        Calendar c1 = Calendar.getInstance();
                        c1.set(year,month,day,0,0,0);
                        long datetime1 = c1.getTimeInMillis();
//                        System.out.println(datetime1);
                        c1.set(year,month,day,19,0,0);
                        long datetime2 = c1.getTimeInMillis();
//                        System.out.println(datetime2);


                        String sql1 = "select uid from T_finish where uid='"+inode+"' && datetimes between '"+datetime1+"' and '"+datetime2+"'";
                        ResultSet rs1 = stml1.executeQuery(sql1);
                        if(rs1.next()){
                            errorss.add("您已经签到，不能重复签到！");
                        }
                        else{
                            String sql2 = "insert into T_finish(uid,number,datetime,datetimes) values('"+inode+"','"+number+"','"+time+"','"+datem+"')";
                            PreparedStatement pstam = conn.prepareStatement(sql2);
                            pstam.executeUpdate();
                            result = true;
                        }

                    }
                    else {
                        Calendar c1 = Calendar.getInstance();
                        c1.set(year,month,day,19,0,1);
                        long datetime1 = c1.getTimeInMillis();
                        c1.set(year,month,day,23,59,0);
                        long datetime2 = c1.getTimeInMillis();
                        String sql1 = "select uid from T_finish where uid ='"+inode+"' && datetimes between '"+datetime1+"' and '"+datetime2+"'";
                        ResultSet rs1 = stml1.executeQuery(sql1);
                        if (rs1.next()) {
                            errorss.add("您已经签到，不能重复签到！");
                        }
                        else{
                            String sql2 = "insert into T_finish(uid,number,datetime,datetimes) values('"+inode+"','"+number+"','"+time+"','"+datem+"')";
                            PreparedStatement pstam = conn.prepareStatement(sql2);
                            pstam.executeUpdate();
                            result = true;
                        }
                    }

                }
                else{
                    errorss.add("请先进行注册！");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
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
                if (stml1 != null) {
                    try {
                        stml1.close();
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
        return result;
    }
}




