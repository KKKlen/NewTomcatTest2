<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 86159
  Date: 2022/4/18
  Time: 8:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Tag_if</title>
</head>
<body>

<%--  c:if标签
    1、属性：
        test：必须属性，就是boolean表达式
        如果表达式为true，则显示if标签内容，否则不显示
        一般情况，test结合EL表达式使用
  --%>
    <c:if test="true">
        我是true~
    </c:if><br>
    <%
        List list = new ArrayList<>();
        list.add("aaa");
        request.setAttribute("list",list);

        request.setAttribute("num",3);
    %>
    <c:if test="${not empty list}">
        list不为empty~
    </c:if><br>
    <c:if test="${num%2!=0}">
        ${num}为ODD~
    </c:if><br>
    <c:if test="${num%2==0}">
        ${num}为偶数~
    </c:if>






</body>
</html>
