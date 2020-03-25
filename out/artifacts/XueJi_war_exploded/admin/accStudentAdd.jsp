<%--
  Created by IntelliJ IDEA.
  User: luchengsong
  Date: 2020/3/25
  Time: 01:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../commons/adminFrag.jsp"%>
<html>
<head>
    <title>添加学生账号</title>
</head>
<body>

    <%-- 判断当前页 --%>
    <flag style="display: none" id="flag">accS</flag>

    <%--  主要内容  --%>
    <div style="width:85%; float: left; overflow:hidden;">
        <table class="table table-bordered">
            <form action="../AccountAddServlet" id="form1">
                <%-- 用以传递参数判断当前要操作的角色 --%>
                <input type="text" style="display: none" name="role" value="student">
                <tr>
                    <td>用户名</td>
                    <td>密码</td>
                    <td>学号</td>
                    <td></td>
                </tr>
                <tr>
                    <td><input type="text" name="username"></td>
                    <td><input type="text" name="password"></td>
                    <td>
                        <select name="sno">
                            <%-- 已分配的学号不显示 --%>
                            <c:forEach var="get" items="${sessionScope.studentList}">

                                <c:set var="flag" value="0"></c:set>

                                <c:forEach var="get1" items="${sessionScope.userList}">
                                    <c:if test="${get.id == get1.sno}" >
                                        <c:set var="flag" value="1"></c:set>
                                    </c:if>
                                </c:forEach>

                                <c:if test="${flag == '0'}">
                                    <option value="${get.id}">${get.id}</option>
                                </c:if>

                            </c:forEach>
                        </select>
                    </td>
                    <td>
                        <a id="btnA" class="btn btn-primary" role="button">确认添加</a>
                        <a class="btn btn-default" href="accStudent.jsp">返回</a>
                    </td>
                </tr>
                <c:if test="${sessionScope.flag == '1'}">
                    <tr>
                        <td colspan="4" style="text-align: center; font-size: 20px; color: purple">该用户名已存在！</td>
                    </tr>
                </c:if>
                <%request.getSession().setAttribute("flag","0");%>
            </form>
        </table>
    </div>

    <script>
        $(function () {
            $("#btnA").click(function () {
                $("#form1").submit();
            })
        })
    </script>

</body>
</html>
