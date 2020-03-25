<%--
  Created by IntelliJ IDEA.
  User: luchengsong
  Date: 2020/3/25
  Time: 01:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../commons/adminFrag.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%-- 判断当前页 --%>
    <flag style="display: none" id="flag">accS</flag>

    <%--  主要内容  --%>
    <%--  主要内容  --%>
    <div style="width:85%; float: left; overflow:hidden;">
        <table class="table table-bordered">
            <tr>
                <td colspan="4"><a class="btn btn-success" href="accStudentAdd.jsp">添加</a></td>
            </tr>
            <tr>
                <td>id</td>
                <td>学生账号</td>
                <td>密码</td>
                <td>对应学生学号</td>
                <td></td>
            </tr>
            <c:forEach var="get" items="${sessionScope.userList}">
                <tr>
                    <td>${get.id}</td>
                    <td>${get.username}</td>
                    <td>${get.password}</td>
                    <td>${get.sno}</td>
                    <td>
                        <a class="btn btn-danger" href="../AccountDelServlet?role=student&id=${get.id}">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

</body>
</html>
