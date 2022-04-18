<%@ page import="java.util.List" %>
<%@ page import="cn.edu.lingnan.domain.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 86159
  Date: 2022/4/18
  Time: 9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List<User> list = new ArrayList<>();
    list.add(new User("克林","123",new Date()));
    list.add(new User("柯林","123",new Date()));
    list.add(new User("克凛","123",new Date()));
    request.setAttribute("list",list);
%>

    <table border="1" width="500" align="center">
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>密码</th>
            <th>日期</th>
        </tr>
        <c:forEach items="${list}" var="user" varStatus="s">
            <c:if test="${s.count%2==0}">
                <tr bgcolor="#bc8f8f">
                    <td>${s.count}</td>
                    <td>${user.username}</td>
                    <td>${user.password}</td>
                    <td>${user.birToStr}</td>
                </tr>
            </c:if>
            <c:if test="${s.count%2!=0}">
                <tr bgcolor="#f5f5dc">
                    <td>${s.count}</td>
                    <td>${user.username}</td>
                    <td>${user.password}</td>
                    <td>${user.birToStr}</td>
                </tr>
            </c:if>

        </c:forEach>

    </table>
</body>
</html>
