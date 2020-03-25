<%--
  Created by IntelliJ IDEA.
  User: luchengsong
  Date: 2020/3/25
  Time: 02:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../commons/studentFrag.jsp"%>
<html>
<head>
    <title>修改密码</title>
</head>
<body>

    <%-- 判断当前页 --%>
    <flag style="display: none" id="flag">accT</flag>

    <%--  主要内容  --%>
    <div style="width:85%; float: left; overflow:hidden;">
        <form action="../AccountUpServlet" id="form1">
            <table class="table table-bordered">
                <%-- 用以传递参数判断当前登陆的角色 --%>
                <input type="text" style="display: none" name="role" value="student">
                <tr>
                    <td colspan="2">
                        <h1>密码修改</h1>
                    </td>
                </tr>
                <tr>
                    <td>旧密码：</td>
                    <td>
                        <input type="text" name="passwordOld">
                    </td>
                </tr>
                <tr>
                    <td>新密码：</td>
                    <td>
                        <input type="text" name="passwordNew" id="password">
                    </td>
                </tr>
                <tr>
                    <td>确认新密码：</td>
                    <td>
                        <input type="text" id="checkPassword">
                    </td>
                </tr>
                <td colspan="2">
                    <a id="btnA" class="btn btn-primary" role="button">确认修改</a>
                </td>
                <c:if test="${sessionScope.flag == '1'}">
                    <tr>
                        <td colspan="2" style="text-align: center; font-size: 20px; color: purple">请输入正确的旧密码！</td>
                    </tr>
                </c:if>
                <%request.getSession().setAttribute("flag","0");%>
                <tr>
                    <td colspan="2" style="text-align: center; font-size: 20px; color: purple">
                        <div id="divError"></div>
                    </td>
                </tr>
            </table>
        </form>
    </div>

    <script>
        $(function () {

            //绑定a标签点击事件
            $("#btnA").click(function () {
                $("#form1").submit()
            })

            //绑定表单提交事件
            $('#form1').submit(function () {
                var a = $("#password").val();
                var b = $("#checkPassword").val();
                if (a != b){
                    $('#divError').html('两次输入新密码不一致！');
                    return false;
                } else {
                    return true
                }
                return false;
            })

        })
    </script>

</body>
</html>
