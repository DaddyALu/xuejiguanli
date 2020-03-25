<%--
  Created by IntelliJ IDEA.
  User: luchengsong
  Date: 2020/3/24
  Time: 16:35
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
    <flag style="display: none" id="flag">classes</flag>

    <%--  主要内容  --%>
    <div style="width:85%; float: left; overflow:hidden;">
        <table class="table table-bordered">
            <form action="../ClassesAddSerlvet" id="form1">
                <tr>
                    <td>班级编号</td>
                    <td>年级</td>
                    <td>班级</td>
                </tr>
                <tr>
                    <td><input type="text" name="id"></td>
                    <td><input type="text" name="nianji"></td>
                    <td><input type="text" name="banji"></td>
                </tr>
                <tr>
                    <td colspan="3">
                        <a id="btnA" class="btn btn-primary" role="button">确认添加</a>
                        <a class="btn btn-default" href="classes.jsp">返回</a>
                    </td>
                </tr>
                <c:if test="${sessionScope.flag == '1'}">
                    <tr>
                        <td colspan="2" style="text-align: center; font-size: 20px; color: purple">该班级编号已存在！</td>
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
