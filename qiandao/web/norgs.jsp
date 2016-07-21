<%@ page import="java.sql.*" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.ResourceBundle" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>签到</title>

    <!-- Bootstrap -->
    <link href="http://cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:http:// -->
    <!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    < script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style type="text/css">
        *{
            margin:0px;
            padding:0px;

        }

        .success{
            background-color: #dff0d8;
        }

        .warning{
            background-color: #faf2cc;
        }


        th,tr{
            text-align: center;
        }

        /*#table1{*/
            /*margin-left: 290px;*/
            /*margin-right: 20px;*/
            /*float:none;*/
        /*}*/

        .col-md-71{
            margin-top: 100px;
            width:700px;
        }

        .sp1{
            display:inline-block;
            margin-right:20px;
            font-size: 20px;
        }

    </style>
</head>
<body style="background-color: #eee">
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <h3 class="text-center">
                Xiyou Linux Group 签到系统
            </h3>
        </div>
    </div>
    <div id="table1">
        <div class="col-md-6 col-md-offset-3">
            <div class="sp1"></div>
            <table style="text-align: center" class="table table-bordered table-hover table-condensed">
                <thead style="text-align: center">
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
                    ResourceBundle rb = ResourceBundle.getBundle("test.db-config");
                    String URL = rb.getString("jdbc.URL");
                    String USERNAME = rb.getString("jdbc.USERNAME");
                    String PASSWD = rb.getString("jdbc.PASSWD");
                    String Driver = rb.getString("jdbc.Driver");
                    Connection conn = null;
                    Statement stml = null;
//                    String url = "jdbc:mysql://localhost:3306/qiandao?" +"user=root&&password=2737353904&&useUnicode=true&&characterEncoding=UTF8";
                    try {
                        Class.forName(Driver);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    try {
                        conn = DriverManager.getConnection(URL, USERNAME, PASSWD);
                        stml = conn.createStatement();

                        Calendar c = Calendar.getInstance();
                        int year = c.get(Calendar.YEAR);
                        int month = c.get(Calendar.MONTH);
                        int day = c.get(Calendar.DATE);
                        int hour = c.get(Calendar.HOUR_OF_DAY);


                    if (hour < 19){
                        int i = 1;
                        Calendar c1 = Calendar.getInstance();
                        c1.set(year,month,day,0,0,0);
                        long datetime1 = c1.getTimeInMillis();
                        c1.set(year,month,day,19,0,0);
                        long datetime2 = c1.getTimeInMillis();

                        String sql =  "select name,number from T_person where id not in (select uid from T_finish where datetimes between '"+datetime1+"'and '"+datetime2+"');";
                        ResultSet rs = stml.executeQuery(sql);
                        while(rs.next()){
                            String num = rs.getString("number");
                            String dates = "未签到";
                            String names = rs.getString("name");

                            String choice="";
                            int color = i%3;
                            switch(color){
                                case 0: choice = "#"; break;
                                case 1: choice = "success"; break;
                                case 2: choice = "warning"; break;

                            }
                %>
                <tr class="<%= choice%>">
                    <td><%= i++ %></td>
                    <td><%= num %></td>
                    <td><%= names %></td>
                    <td><%= dates%></td>
                </tr>

                <% }
                } %>


                <%
                    if (hour >= 19 && hour < 24){
                        int i = 1;
                        Calendar c1 = Calendar.getInstance();
                        c1.set(year,month,day,19,0,1);
                        long datetime1 = c1.getTimeInMillis();
                        c1.set(year,month,day,23,59,0);
                        long datetime2 = c1.getTimeInMillis();

                        String sql =  "select name,number from T_person where id not in (select uid from T_finish where datetimes between '"+datetime1+"'and '"+datetime2+"');";
                        ResultSet rs = stml.executeQuery(sql);
                        while(rs.next()){
                            String num = rs.getString("number");
                            String dates = "未签到";
                            String names = rs.getString("name");

                            String choice="";
                            int color = i%3;
                            switch(color){
                                case 0: choice = "#"; break;
                                case 1: choice = "success"; break;
                                case 2: choice = "warning"; break;

                            }
                %>
                <tr class="<%= choice%>">
                    <td><%= i++ %></td>
                    <td><%= num %></td>
                    <td><%= names %></td>
                    <td><%= dates%></td>
                </tr>

                <% }
                } %>


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
