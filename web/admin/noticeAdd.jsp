<%--
  Created by IntelliJ IDEA.
  User: luchengsong
  Date: 2020/3/24
  Time: 05:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../commons/adminFrag.jsp"%>
<html>
<head>
    <title>添加公告</title>
</head>
<body>

    <%-- 判断当前页 --%>
    <flag style="display: none" id="flag">notice</flag>

    <%--  主要内容  --%>
    <div style="width:85%; float: left; overflow:hidden;">
        <table class="table table-bordered">
            <form action="../NoticeAddSerlvet" id="form1">
                <tr>
                    <td>公告编号</td>
                    <td>公告标题</td>
                </tr>
                <tr>
                    <td><input type="text" name="id"></td>
                    <td><input type="text" name="title"></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <textarea cols="30" rows="10" name="content"></textarea>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <a id="btnA" class="btn btn-primary" role="button">确认发布</a>
                        <a class="btn btn-default" href="notice.jsp">返回</a>
                    </td>
                </tr>
                <c:if test="${sessionScope.flag == '1'}">
                    <tr>
                        <td colspan="2" style="text-align: center; font-size: 20px; color: purple">该公告编号已存在！</td>
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
