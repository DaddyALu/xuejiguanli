<%--
  Created by IntelliJ IDEA.
  User: luchengsong
  Date: 2020/3/24
  Time: 05:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../commons/adminFrag.jsp"%>
<html>
<head>
    <title>公告内容</title>
</head>
<body>

    <%-- 判断当前页 --%>
    <flag style="display: none" id="flag">notice</flag>

    <%--  主要内容  --%>
    <div style="width:85%; float: left; overflow:hidden;">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Panel title</h3>
            </div>
            <div class="panel-body">
                <%-- 先得到当前想要查看内容的id --%>
                <%
                    String id = request.getParameter("id");
                    request.getSession().setAttribute("currentId",id);
                %>
                <c:forEach var="get" items="${sessionScope.notices}">
                    <c:if test="${sessionScope.currentId == get.id}">
                        ${get.content}
                    </c:if>
                </c:forEach>
            </div>
            <div>
                <a class="btn btn-default" href="notice.jsp">返回</a>
            </div>
        </div>
    </div>

</body>
</html>
