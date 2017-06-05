<%@ page import="java.sql.*" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.ResourceBundle" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <link rel="icon" href="http://7xs8o3.com1.z0.glb.clouddn.com/sign1.png" type="image/x-icon" />
    <link rel="shortcut icon" href="http://7xs8o3.com1.z0.glb.clouddn.com/sign1.png">
    <link rel="Bookmark" href="http://7xs8o3.com1.z0.glb.clouddn.com/sign1.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Xiyou Linux Group Sign In</title>
    <link href="http://cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    < script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style type="text/css">
        a{
            line-height: 20px;
            text-decoration: none;
            height:56px;
            width:200px;
            font-size: 15px;
            color: #F08080;
        }

        th{
            text-align: center;
        }

        .row1{
            float: left;
            margin-left: 0px;
            margin-top: 150px;
            width:400px;
        }

        *{
            margin:0px;
            padding:0px;

        }

        #table{
            width:400px;
            height:330px;
            padding:0px;
            margin:0px;
            margin-left: 30px;
        }

        #table1{
            width: auto;
            margin-right: 30px;
            float:right;
        }

        .col-md-71{
            margin-top: 150px;
            width:700px;
            float: right;
        }

        .sp1{
            display:inline-block;
            margin-right:20px;
            font-size: 20px;
        }

        .sp2{
            display:inline-block;
        }

        .hz{
            font-size: 15px;
            margin-left:50px;
            margin-top:30px;
        }

        .hs{
            font-size:15px;
            margin-left:36px;
            margin-top:30px;
        }

        .btn{
            margin-left:120px;
            margin-top:-25px;
        }


        .sc{
            font-size:15px;
            margin-left:50px;
        }


        #table ul{
            list-style:none;
            height:30px;
            line-height:30px;
            display:block;
        }

        #table ul li{
            width:90px;
            height:30px;
            border:1px solid #BEBEBE;
            text-align:center;
            line-height:28px;
            float:left;
            border-bottom:none;
            background:#fff;
            cursor:pointer;
        }

        #table ul li.on{
            border-top:2px solid saddlebrown;
            border-bottom:2px solid #fff;
        }

        #table div{
            height:200px;
            border:1px solid #BEBEBE;
            line-height:25px;
            border-top:2px solid saddlebrown;
            padding:5px;
            background-color:#eee;
        }

        .hide{
            display:none;
        }

    </style>
    <script type="text/javascript">

        // JS实现选项卡切换
        window.onload=function(){
            var table=document.getElementById("table");
            var li=document.getElementsByTagName("li");
            var div=table.getElementsByTagName("div");
            for(var i=0;i<li.length;i++){
                li[i].index=i;
                li[i].onclick=function(){
                    for(var j=0;j<li.length;j++){
                        li[j].className="";
                        div[j].className="hide";
                    }
                    this.className="on";
                    div[this.index].className="";
                }
            }
        }

    </script>
</head>
<body style="background-color: #F2F4F8">
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <h3 class="text-center">
                Xiyou Linux Group 签到系统
            </h3>
        </div>
    </div>
    <div class="row1">
        <div class="col-md-5">
            <div id="table">
                <ul>
                    <li class="on">签到</li>
                    <li>注册</li>
                </ul>
                <div>
                    <form action="login1.do" method="post">
                        <label class="hz"><span>学号:</span><input type="text" name="Number"  placeholder="input your student id"></label>
                        <br/>
                        <%--<label class="hs"><span>验证码:</span><input type="text" name="check_num"/> <img src="./image.show"/></label>--%>
                        <%--<br/>--%>
                        <br/>
                        <br/>
                        <button class="btn" type="submit">提交</button>
                    </form>
                </div>
                <div class="hide">
                    <form action="register.do" method="post">
                        <label class="hz"><span>名字：</span><input type="text" name="Name" placeholder="please input your name"/> </label>
                        <br/>
                        <br/>
                        <label class="sc"><span>学号：</span><input type="text" name="Number" placeholder="please input student id"/> </label>
                        <br/>
                        <br/>
                        <br/>
                        <button class="btn" type="submit">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div id="table1">
        <div class="col-md-71">
            <div class="sp1">已签到</div>
            <div class="sp2"><a style="color:cadetblue;" href="norgs.jsp" target="_self">未签到</a></div>
            <div style="margin-left: 20px" class="sp2"><a style="color:cadetblue;" href="selectdata.html" target="_self">历史查询</a></div>
            <table style="text-align: center" class="table table-bordered table-hover table-condensed">
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
                    ResourceBundle rb = ResourceBundle.getBundle("test.db-config");
                    String URL = rb.getString("jdbc.URL");
                    String USERNAME = rb.getString("jdbc.USERNAME");
                    String PASSWD = rb.getString("jdbc.PASSWD");
                    String Driver = rb.getString("jdbc.Driver");
                    Connection conn = null;
                    Statement stml = null;
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
                        if(hour < 19){
                            int i=1;
                            Calendar c1 = Calendar.getInstance();
                            c1.set(year,month,day,0,0,0);
                            long datetime1 = c1.getTimeInMillis();
                            c1.set(year,month,day,19,0,0);
                            long datetime2 = c1.getTimeInMillis();
                            String sql = " select * from T_finish,T_person where T_finish.uid = T_person.id  && datetimes between '"+datetime1+"'and '"+datetime2+"';";
                            ResultSet rs = stml.executeQuery(sql);
                            while(rs.next()){
                                String num = rs.getString("number");
                                String dates = rs.getString("datetime");
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
                }  %>
                <%
                    if (hour >= 19 && hour < 24){
                        int i = 1;
                        Calendar c1 = Calendar.getInstance();
                        c1.set(year,month,day,19,0,1);
                        long datetime1 = c1.getTimeInMillis();
                        c1.set(year,month,day,23,59,0);
                        long datetime2 = c1.getTimeInMillis();
                        String sql = " select * from T_finish,T_person where T_finish.uid = T_person.id  && datetimes between '"+datetime1+"'and '"+datetime2+"';";
                        ResultSet rs = stml.executeQuery(sql);
                        while(rs.next()){
                            String num = rs.getString("number");
                            String dates = rs.getString("datetime");
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
                    } catch (SQLException e){
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
<script src="http://cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>
