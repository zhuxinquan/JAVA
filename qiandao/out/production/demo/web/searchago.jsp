<%@ page import="java.sql.*" %>
<%@ page import="java.util.Calendar" %>
<%@page import="java.lang.Integer"%>
<%@ page import="java.util.ResourceBundle" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Xiyou Linux Group Sign In</title>
    <link href="http://cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    < script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style type="text/css">
        *{
            margin:0px;
            padding:0px;

        }

        .sp1{
            display:inline-block;
            margin-right:20px;
            font-size: 20px;
        }

        th,tr{
            text-align:center;
        }

    </style>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <h3 class="text-center">
                Xiyou Linux Group 暑期签到系统
            </h3>
        </div>
    </div>
    <div id="table1">
        <div class="col-md-6 col-md-offset-3">
            <div class="sp1"></div>
            <table class="table table-bordered table-hover table-condensed">
                <thead>
                <tr>
                    <th>
                        编号
                    </th>
                    <th>
                        学号
                    </th>
                    <th>
                        姓名
                    </th>
                    <th>
                        签到时间
                    </th>
                </tr>
                </thead>
                <tbody>
                <%
                    request.setCharacterEncoding("UTF-8");
                    response.setContentType("text/html;charset=UTF-8");
                    String dates = request.getParameter("date");
                    String[] a = dates.split(",");
                    int tyear = Integer.parseInt(a[0]);
                    int tmonth = Integer.parseInt(a[1])-1;
                    int tday = Integer.parseInt(a[2]);
                    Calendar selctime = Calendar.getInstance();
                    selctime.set(tyear,tmonth,tday,0,0,0);
                    long tdatetime = selctime.getTimeInMillis();
                    Calendar selctime1 = Calendar.getInstance();
                    selctime1.set(tyear,tmonth,tday,23,59,0);
                    long tdatetime1 = selctime1.getTimeInMillis();
                    Calendar selctime2 = Calendar.getInstance();
                    selctime2.set(tyear,tmonth,tday,19,0,0);
                    long tdatetime2 = selctime2.getTimeInMillis();
                    ResourceBundle rb = ResourceBundle.getBundle("test.db-config");
                    String URL = rb.getString("jdbc.URL");
                    String USERNAME = rb.getString("jdbc.USERNAME");
                    String PASSWD = rb.getString("jdbc.PASSWD");
                    String Driver = rb.getString("jdbc.Driver");
                    Connection conn = null;
                    Statement stml = null;
                    String choice = "";
                    try {
                        Class.forName(Driver);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    try {
                        conn = DriverManager.getConnection(URL, USERNAME, PASSWD);
                        stml = conn.createStatement();
                        int i = 1;
                        String sql = "select name,T_person.number,datetime,datetimes from T_finish,T_person  where T_finish.uid = T_person.id  and  datetimes between '"+tdatetime+"' and '"+tdatetime1+"' order by datetime desc;";
                        ResultSet rs = stml.executeQuery(sql);
                        while(rs.next()){
                            String num = rs.getString("number");
                            String names = rs.getString("name");
                            String dttime = rs.getString("datetime");
                            String dttimes = rs.getString("datetimes");
                            long dtimes = Long.parseLong(dttimes);
                            if(dtimes <= tdatetime2)
                                choice = "success";
                            else
                                choice = "warning";
                %>
                <tr class="<%= choice%>">
                    <td><%= i++ %></td>
                    <td><%= num %></td>
                    <td><%= names %></td>
                    <td><%= dttime%></td>
                </tr>
                <% }
                %>
                <%
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
                %>

                </tbody>
            </table>
        </div>
    </div>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="http://cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="http://cdn.bootcss.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>


