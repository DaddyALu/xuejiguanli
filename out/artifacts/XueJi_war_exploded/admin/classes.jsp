<%--
  Created by IntelliJ IDEA.
  User: luchengsong
  Date: 2020/3/24
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../commons/adminFrag.jsp"%>
<html>
<head>
    <title>班级信息</title>
</head>
<body>

    <%-- 判断当前页 --%>
    <flag style="display: none" id="flag">classes</flag>

    <%--  主要内容  --%>
    <div style="width:85%; float: left; overflow:hidden;">
        <table class="table table-bordered">
            <tr>
                <td colspan="4"><a class="btn btn-success" href="classesAdd.jsp">添加</a></td>
            </tr>
            <tr>
                <td>班级编号</td>
                <td>年级</td>
                <td>班级</td>
                <td></td>
            </tr>
            <c:forEach var="get" items="${sessionScope.classesList}">
                <tr>
                    <td>${get.id}</td>
                    <td>${get.nianji}</td>
                    <td>${get.banji}</td>
                    <td>
                        <a class="btn btn-danger" href="../ClassesDelServlet?id=${get.id}">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

</body>
</html>
