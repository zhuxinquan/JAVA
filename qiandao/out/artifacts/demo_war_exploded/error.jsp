<%@ page import="java.util.List" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>失败页面</title>
    <style type="text/css">
        body {
            text-align:center;
            margin-top:150px;
            background-color:#eee;
        }
    </style>
</head>
<body>
<h1>！注册失败！</h1>
<div style="text-align: center;color:rgb(255,0,0)">
    <%--<ul style='color:rgb(255,0,0);'>--%>
    <%
        List<String> errors = (List<String>) request.getAttribute("errors");
        for(String error:errors)
        {
    %>
    <%= error %>
    <%
        }
    %>
        <br/><br/>
</div>    <%--</ul>--%>
   <span style="text-align: center; font-size: 20px;"><a href="index.jsp">返回注册页面</a></span>

</body>
</html>
