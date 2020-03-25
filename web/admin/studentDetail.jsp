<%--
  Created by IntelliJ IDEA.
  User: luchengsong
  Date: 2020/3/24
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../commons/adminFrag.jsp"%>
<html>
<head>
    <title>完整学籍信息</title>
</head>
<body>

    <%-- 判断当前页 --%>
    <flag style="display: none" id="flag">student</flag>

    <%--  主要内容  --%>
    <div style="width:85%; float: left; overflow:hidden;">
        <table class="table table-bordered" style="height: 700px">
            <%-- 先得到当前想要查看内容的id --%>
            <%
                String id = request.getParameter("id");
                request.getSession().setAttribute("currentId",id);
            %>
            <c:forEach var="get" items="${sessionScope.studentList}">
                <c:if test="${sessionScope.currentId == get.id}">
                    <tr>
                        <td>学号</td>
                        <td>${get.id}</td>
                    </tr>
                    <tr>
                        <td>姓名</td>
                        <td>${get.name}</td>
                    </tr>
                    <tr>
                        <td>性别</td>
                        <td>
                            <c:if test="${get.gender == 0}">
                                女
                            </c:if>
                            <c:if test="${get.gender == 1}">
                                男
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <td>出生日期</td>
                        <td>${get.birth}</td>
                    </tr>
                    <tr>
                        <td>年级</td>
                        <td>${get.nianji}</td>
                    </tr>
                    <tr>
                        <td>班级</td>
                        <td>${get.banji}</td>
                    </tr>
                    <tr>
                        <td>籍贯</td>
                        <td>${get.birthPlace}</td>
                    </tr>
                    <tr>
                        <td>家庭地址</td>
                        <td>${get.address}</td>
                    </tr>
                    <tr>
                        <td>手机号码</td>
                        <td>${get.tel}</td>
                    </tr>
                    <tr>
                        <td>电子邮箱</td>
                        <td>${get.address}</td>
                    </tr>
                    <tr>
                        <td>头像</td>
                        <td>${get.img}</td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <a class="btn btn-default" href="student.jsp">返回</a>
                        </td>
                    </tr>
                </c:if>
            </c:forEach>
        </table>
    </div>

</body>
</html>
