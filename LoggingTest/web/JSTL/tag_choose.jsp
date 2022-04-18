<%--
  Created by IntelliJ IDEA.
  User: 86159
  Date: 2022/4/18
  Time: 9:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Tag_choose</title>
</head>
<body>
<%--
    完成数字编号对应星期几
        1、域中存储数字
        2、使用choose标签取出数字      — —switch
        3、使用when标签做数字判断       — —case
        4、otherwise标签做其他情况声明  — —default
--%>
    <%
        request.setAttribute("num",3);
    %>
    <c:choose>
        <c:when test="${num==1}">星期一</c:when>
        <c:when test="${num==2}">星期二</c:when>
        <c:when test="${num==3}">星期三</c:when>
        <c:when test="${num==4}">星期四</c:when>
        <c:when test="${num==5}">星期五</c:when>
        <c:when test="${num==6}">星期六</c:when>
        <c:when test="${num==7}">星期天</c:when>
        <c:otherwise>数字输入错误~</c:otherwise>
    </c:choose>


</body>
</html>
