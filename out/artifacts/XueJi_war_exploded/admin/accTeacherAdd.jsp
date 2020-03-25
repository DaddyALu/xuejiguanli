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
    <title>添加教师账号</title>
</head>
<body>

    <%-- 判断当前页 --%>
    <flag style="display: none" id="flag">accT</flag>

    <%--  主要内容  --%>
    <div style="width:85%; float: left; overflow:hidden;">
        <table class="table table-bordered">
            <form action="../AccountAddServlet" id="form1">
                <%-- 用以传递参数判断当前登陆的角色 --%>
                <input type="text" style="display: none" name="role" value="teacher">
                <tr>
                    <td>用户名</td>
                    <td>密码</td>
                    <td></td>
                </tr>
                <tr>
                    <td><input type="text" name="username"></td>
                    <td><input type="text" name="password"></td>
                    <td>
                        <a id="btnA" class="btn btn-primary" role="button">确认添加</a>
                        <a class="btn btn-default" href="accTeacher.jsp">返回</a>
                    </td>
                </tr>
                <c:if test="${sessionScope.flag == '1'}">
                    <tr>
                        <td colspan="3" style="text-align: center; font-size: 20px; color: purple">该用户名已存在！</td>
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
