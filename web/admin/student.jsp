<%--
  Created by IntelliJ IDEA.
  User: luchengsong
  Date: 2020/3/24
  Time: 04:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../commons/adminFrag.jsp"%>
<html>
<head>
    <title>学籍管理</title>
</head>
<body>

    <%-- 判断当前页 --%>
    <flag style="display: none" id="flag">student</flag>

    <%--  主要内容  --%>
    <div style="width:85%; float: left; overflow:hidden;">
        <table class="table table-bordered">
            <tr>
                <td colspan="5">
                    <a class="btn btn-success" href="studentAdd.jsp">添加</a>
                    <%-- 搜索功能 --%>
                    <div style="float: right">
                        <form class="navbar-form navbar-left" action="../SearchServlet?aaa=admin">
                            <%-- 用以传递参数判断当前登陆的角色 --%>
                            <input type="text" style="display: none" name="aaa" value="admin">

                            搜索条件：
                            <select name="select">
                                <option value="1">学号</option>
                                <option value="2">姓名</option>
                                <option value="3">年级</option>
                                <option value="4">班级</option>
                            </select>
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Search" name="keyword">
                            </div>
                            <button type="submit" class="btn btn-default">搜索</button>
                        </form>
                    </div>
                </td>
            </tr>
            <tr>
                <td>学号</td>
                <td>姓名</td>
                <td>年级</td>
                <td>班级</td>
                <td>操作</td>
            </tr>
            <c:forEach var="get" items="${sessionScope.studentList}">
                <tr>
                    <td>${get.id}</td>
                    <td>${get.name}</td>
                    <td>${get.nianji}</td>
                    <td>${get.banji}</td>
                    <td>
                        <a class="btn btn-default" href="studentDetail.jsp?id=${get.id}">详情</a>
                        <a class="btn btn-primary" href="studentUpdate.jsp?id=${get.id}">修改</a>
                        <a class="btn btn-danger" href="../StudentDelServlet?id=${get.id}">删除</a>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td>
                    <a class="btn btn-info" href="../StudentUpgradeServlet">全体升级</a>
                    <a class="btn btn-warning" href="../StudentDegradeServlet">全体降级</a>
                </td>
            </tr>
        </table>
    </div>

</body>
</html>
