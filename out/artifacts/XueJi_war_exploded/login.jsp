<%--
  Created by IntelliJ IDEA.
  User: luchengsong
  Date: 2020/3/16
  Time: 02:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>登陆页面</title>
    <script type="text/javascript" src="static/js/jquery-3.3.1.min.js"></script>
    <link rel="stylesheet" href="static/css/login.css">
</head>
<body>

    <!-- 整体部分 -->
    <div id="main" style="background: url('static/img/login.jpeg') no-repeat; background-size: 100% 100%;">
        <!-- 学校logo -->
        <div id="div_logo" style="background: url('static/img/login.jpeg') no-repeat;">
            <img class="img1" src="static/img/logo.png">
        </div>
        <!-- 页面标题 -->
        <div id="div_title">
            <font style="color: black"><b><i>学 籍 管 理 系 统</i></b></font>
        </div>
    </div>

    <!-- 登陆框 -->
    <div id="div_sheet">
        <!-- 标题/注册 -->
        <div id="div_sheet_title">
            <h1>&emsp;欢迎登陆</h1>
        </div>
        <br>
        <!-- 登陆表单 -->
        <div id="div_form">
            <form action="LoginServlet" method="post">
                <!-- 用户名 -->
                <div class="div_input">
                    &emsp;&emsp;用户名
                    <input class="input_text" id="username" name="username" type="text" placeholder="请输入用户名">
                </div>
                <!-- 密码 -->
                <div class="div_input">
                    &emsp;&emsp;密&emsp;码
                    <input class="input_text" id="password" name="password" type="password" placeholder="请输入密码">
                </div>
                <!-- 角色 -->
                <div class="div_input">
                    &emsp;&emsp;角&emsp;色&emsp;
                    <select name="role">
                        <option value="admin">管理员</option>
                        <option value="teacher">教师</option>
                        <option value="student">学生</option>
                    </select>
                </div>
                <!-- 验证码 -->
                <div class="div_input">
                    &emsp;&emsp;验证码
                    <input class="input_text" id="check" type="text" placeholder="请输入验证码">
                    <!--验证图片-->
                    <div id="div_checkImg">
                        <img src="static/img/1.png" class="img1" id="checkimg"><br>
                    </div>
                </div>
                <div id="div_tip">
                    <c:if test="${cookie.error.value == 1}" var="flag">
                        用户名或密码错误！
                        <%
                            Cookie cookie = new Cookie("error","0");
                            response.addCookie(cookie);
                        %>
                    </c:if>
                </div>
                <!-- 登陆按钮 -->
                <input id="input_submit" type="submit" value="登&emsp;&emsp;陆">
            </form>
        </div>
    </div>

    <%--  放在最后，加快页面加载速度  --%>
    <script type="text/javascript" src="static/js/login.js"></script>

</body>
</html>
