<%--
  Created by IntelliJ IDEA.
  User: zhuxinquan
  Date: 16-8-4
  Time: 上午9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="com.get_blog_content.DBUtils" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.get_blog_content.Time" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Xiyou Linux Group博客系统</title>
    <meta charset="utf-8">
    <meta name="viewport"  content="width=device-width, initial-scale=1"/>
    <link rel="stylesheet" type="text/css" href="css/common.css">

</head>

<body>
<div id="all">

    <header id="header">
        <hgroup>
            <div id="nave">
                <div id="nave1">
                    <div id="pictures">
                        <img src="http://7xs8o3.com1.z0.glb.clouddn.com/sign1.png" height="100px" width="100px"></div>
                        <span id="nsize">
                            <h2>Xiyou Linux Group群博</h2>
                            <h4>open,free,share</h4>
                        </span>
                </div>
                <div id="seart">
                    <form action="search.jsp" method="post">
                        <label>
                            <input type="text" name="search"></label>
                        <button class="btn" type="submit">搜索</button>
                    </form>
                </div>
            </div>
        </hgroup>
        <nav></nav>
    </header>
    <article id="article">
        <div id="laside"></div>
        <%
            request.setCharacterEncoding("UTF-8");
            String id = request.getParameter("id");


            Statement stml = null;
            Connection conn = null;
            ResultSet rs = null;

            String articledetail = "";
            String title = "";
            String author = "";
            Long pubdate = 0L;
            String uid = "";


            try {
                conn = DBUtils.getConnection();
                stml = conn.createStatement();
                String sql = "select  uid, Name, Title, Author, PubDate, ArticleDetail from T_blog, T_user where T_blog.uid = T_user.Id and T_blog.id="+id+" " ;
                System.out.println(sql);
                rs = stml.executeQuery(sql);
                if(rs.next()){
                    uid = rs.getString("uid");
                    articledetail = rs.getString("ArticleDetail");
                    title = rs.getString("Title");
                    author = rs.getString("Name");
                    pubdate = rs.getLong("PubDate");
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }finally {
                DBUtils.close(rs,stml,conn);
            }
        %>

        <section>
            <div class="vbox">
                <div>
                    <p class="fsize">
                        <a  target="_blank" href="#" title="<%= title %>"><%= title %></a>
                    </p>
                </div>
                <div id="mbox">
                    <a href="##" class="afont"><%= author %></a>
                    <span class="time" style="color:#996600; margin-left:40px;"><%= Time.formatTime(new Date(pubdate)) %></span>
                </div>
                <div style="text-indent:3em;">
                        <span class="node">
                          <%= articledetail %>
                        </span>
                </div>
            </div>
        </section>

    </article>

    <footer>
        <div id="foot">
            <p>
                <a href="">
                    <span>Xiyou Linux Group群博</span>
                </a>
            </p>
            <p>
                <a href="">
                    <span>open,free,share</span>
                </a>
            </p>
            <p>
                <span><a href="http://www.xiyoulinux.org">西邮Linux兴趣小组</a> 版权所有 © 2016</span>
            </p>
        </div>
    </footer>
</div>
</body>
</html>
