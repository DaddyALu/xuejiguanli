<%--
  Created by IntelliJ IDEA.
  User: luchengsong
  Date: 2020/3/24
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../commons/adminFrag.jsp"%>
<html>
<head>
    <title>添加学生</title>
</head>
<body>
    <%-- 判断当前页 --%>
    <flag style="display: none" id="flag">student</flag>

    <%--  主要内容  --%>
    <div style="width:85%; float: left; overflow:hidden;">
        <form action="../StudentAddServlet" id="form1">
            <table class="table table-bordered" style="height: 700px">
                <c:if test="${sessionScope.flag == '1'}">
                    <tr>
                        <td colspan="2" style="text-align: center; font-size: 20px; color: purple">该学号已存在！</td>
                    </tr>
                </c:if>
                <%request.getSession().setAttribute("flag","0");%>
                <tr>
                    <td>学号</td>
                    <td><input type="text" name="id"> &emsp;<font style="color: red">(*请填写数字)</font></td>
                </tr>
                <tr>
                    <td>姓名</td>
                    <td><input type="text" name="name"></td>
                </tr>
                <tr>
                    <td>性别</td>
                    <td>
                        <%-- 设置name为一样值，实现单选 --%>
                        <input type="radio" name="gender" value="1">男
                        <input type="radio" name="gender" value="0">女
                    </td>
                </tr>
                <tr>
                    <td>出生日期</td>
                    <td><input type="text" name="birth"></td>
                </tr>
                <tr>
                    <td>班级</td>
                    <td>
                        <select name="banji">
                            <%-- 这里value的两个值要用空格隔开，方便在servlet中拆分 --%>
                            <c:forEach var="get1" items="${sessionScope.classesList}">
                                <option value="${get1.nianji} ${get1.banji}">${get1.nianji} ${get1.banji}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>籍贯</td>
                    <td><input type="text" name="birthPlace"></td>
                </tr>
                <tr>
                    <td>家庭地址</td>
                    <td><input type="text" name="address"></td>
                </tr>
                <tr>
                    <td>手机号码</td>
                    <td><input type="text" name="tel"></td>
                </tr>
                <tr>
                    <td>电子邮箱</td>
                    <td><input type="text" name="email"></td>
                </tr>
                <tr>
                    <td>头像</td>
                    <td name="img" value="0">0</td>
                </tr>
                <tr>
                    <td colspan="2">
                        <a id="btnA" role="button" class="btn btn-primary">确认提交</a>
                        <a class="btn btn-default" href="student.jsp">返回</a>
                        &emsp;&emsp;&emsp;&emsp;<font style="color: red">请填写完所有内容，否则将会添加失败</font>
                    </td>
                </tr>
            </table>
        </form>
    </div>

    <%--  绑定提交事件  --%>
    <script>
        $(function () {
            $("#btnA").click(function () {
                $("#form1").submit();
            })
        })
    </script>

</body>
</html>
