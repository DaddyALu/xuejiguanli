<%--
  Created by IntelliJ IDEA.
  User: luchengsong
  Date: 2020/3/24
  Time: 03:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>教师登陆</title>
    <script type="text/javascript" src="../static/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="../static/js/bootstrap.min.js" ></script>
    <link rel="stylesheet" href="../static/css/bootstrap.min.css">
    <style>
        .div_title{
            float: left;
            width: 200px;
            height: 90px;
            margin-top: 20px;
            line-height: 90px;
            text-align: center;
        }
    </style>
</head>
<body>

    <%--  标题栏  --%>
    <div style="width: 100%; height: 130px; background-color: #cee9ea">
        <div class="div_title"><img src="../static/img/logo.png" style="width: 120px; height: 100px"></div>
        <div class="div_title" style="font-size: 24px">学 籍 管 理 系 统</div>
        <div class="div_title" style="float: right">
            欢迎登陆，${sessionScope.username}
            <span class="glyphicon glyphicon-user"></span> &emsp;
            <a href="../LogoutServlet">登出</a>
        </div>
    </div>

    <%--  菜单栏  --%>
    <div style="width: 15%; height: 750px; float: left; background-color: #f5f5f5">
        <ul class="nav nav-pills nav-stacked">
            <li id="home" role="presentation"><a href="home.jsp">首页</a></li>
            <li id="notice" role="presentation"><a href="../NoticeServlet?aaa=teacher">教务公告</a></li>
            <li id="student" role="presentation"><a href="../StudentServlet?aaa=teacher">学籍查看</a></li>
            <li id="accT" role="presentation"><a href="accUpdate.jsp">修改密码</a></li>
        </ul>
    </div>

    <%--  判断当前页，导航显示高亮  --%>
    <script>
        $(function () {
            var t = $("#flag").text();
            // console.log(t);
            if (t == "home" ){
                $("#home").attr("class","active")
                $("#notice").attr("class","")
                $("#student").attr("class","")
                $("#accT").attr("class","")
            }else if (t == "notice"){
                $("#home").attr("class","")
                $("#notice").attr("class","active")
                $("#student").attr("class","")
                $("#accT").attr("class","")
            }else if (t == "student"){
                $("#home").attr("class","")
                $("#notice").attr("class","")
                $("#student").attr("class","active")
                $("#classes").attr("class","")
            }else if (t == "accT"){
                $("#home").attr("class","")
                $("#notice").attr("class","")
                $("#student").attr("class","")
                $("#accT").attr("class","active")
            }
        })
    </script>

</body>
</html>
