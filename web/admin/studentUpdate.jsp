<%--
  Created by IntelliJ IDEA.
  User: luchengsong
  Date: 2020/3/24
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../commons/adminFrag.jsp"%>
<html>
<head>
    <title>学生信息修改</title>
</head>
<body>

    <%-- 判断当前页 --%>
    <flag style="display: none" id="flag">student</flag>

    <%--  主要内容  --%>
    <div style="width:85%; float: left; overflow:hidden;">
        <form action="../StudentUpdateServlet" id="form1">
            <table class="table table-bordered" style="height: 700px">
                <%-- 先得到当前想要查看内容的id --%>
                <%
                    String id = request.getParameter("id");
                    request.getSession().setAttribute("currentId",id);
                %>
                <c:forEach var="get" items="${sessionScope.studentList}">
                    <c:if test="${sessionScope.currentId == get.id}">
                        <c:if test="${sessionScope.flag == '1'}">
                            <tr>
                                <td colspan="2" style="text-align: center; font-size: 20px; color: purple">该学号已存在！</td>
                            </tr>
                        </c:if>
                        <%request.getSession().setAttribute("flag","0");%>
                        <tr>
                            <td>学号</td>
                            <td><input type="text" value="${get.id}" name="id" style="display: none">${get.id}</td>
                        </tr>
                        <tr>
                            <td>姓名</td>
                            <td><input type="text" value="${get.name}" name="name"></td>
                        </tr>
                        <tr>
                            <td>性别</td>
                            <td>
                                <c:if test="${get.gender == 0}">
                                    <input type="radio" name="gender" value="1">男
                                    <input type="radio" name="gender" value="0" checked="checked">女
                                </c:if>
                                <c:if test="${get.gender == 1}">
                                    <input type="radio" name="gender" value="1" checked="checked">男
                                    <input type="radio" name="gender" value="0">女
                                </c:if>
                            </td>
                        </tr>
                        <tr>
                            <td>出生日期</td>
                            <td><input type="text" value="${get.birth}" name="birth"></td>
                        </tr>
                        <tr>
                            <td>班级</td>
                            <td>
                                <select name="banji">
                                    <%-- 这里value的两个值要用空格隔开，方便在servlet中拆分 --%>
                                    <option value="${get.nianji} ${get.banji}">原班级：${get.nianji}&emsp;${get.banji}</option>
                                    <%-- 这里的var值不能用get，var的值会影响定义之后的所有引用，不只是这一个forEach中 --%>
                                    <c:forEach var="get1" items="${sessionScope.classesList}">
                                        <option value="${get1.nianji} ${get1.banji}">${get1.nianji}&emsp;${get1.banji}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>籍贯</td>
                            <td><input type="text" value="${get.birthPlace}" name="birthPlace"></td>
                        </tr>
                        <tr>
                            <td>家庭地址</td>
                            <td><input type="text" value="${get.address}" name="address"></td>
                        </tr>
                        <tr>
                            <td>手机号码</td>
                            <td><input type="text" value="${get.tel}" name="tel"></td>
                        </tr>
                        <tr>
                            <td>电子邮箱</td>
                            <td><input type="text" value="${get.address}" name="email"></td>
                        </tr>
                        <tr>
                            <td>头像</td>
                            <td><input type="text" value="${get.img}" name="img"></td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <a id="btnA" role="button" class="btn btn-primary">确认提交</a>
                                <a class="btn btn-default" href="student.jsp">返回</a>
                            </td>
                        </tr>
                    </c:if>
                </c:forEach>
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
