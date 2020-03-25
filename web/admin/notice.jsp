<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: luchengsong
  Date: 2020/3/24
  Time: 04:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../commons/adminFrag.jsp"%>
<html>
<head>
    <title>教务公告</title>
</head>
<body>

    <%-- 判断当前页 --%>
    <flag style="display: none" id="flag">notice</flag>

    <%--  主要内容  --%>
    <div style="width:85%; float: left; overflow:hidden;">
        <table class="table table-bordered">
            <tr>
                <td colspan="4"><a class="btn btn-success" href="noticeAdd.jsp">添加</a></td>
            </tr>
            <tr>
                <td>公告编号</td>
                <td>公告主题</td>
                <td>发布时间</td>
                <td></td>
            </tr>
            <c:forEach var="get" items="${sessionScope.notices}">
                <tr>
                    <td>${get.id}</td>
                    <td>${get.title}</td>
                    <td>${get.time}</td>
                    <td>
                        <a class="btn btn-default" href="noticeContent.jsp?id=${get.id}">查看详情</a>
                        <a class="btn btn-danger" href="../NoticeDelServlet?id=${get.id}">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>

</body>
</html>
