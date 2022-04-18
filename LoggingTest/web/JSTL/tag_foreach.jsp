<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 86159
  Date: 2022/4/18
  Time: 9:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Tag_foreach</title>
</head>
<body>
<%--
    foreach：Java代码中的for语句
        1、完成重复操作：
        * 属性：
        begin:开始——
        end:结束——
        var:临时变量——
        step:步长——
        varStatus:循环状态变量
            1\.index：容器中元素的索引，从0开始
            2\.count：循环次数，从1开始
        2、遍历容器：
        List<User> lsit;
        for(User user : list){}
        * 属性：
            items:容器对象
            var:容器中元素的临时变量
--%>
    <c:forEach begin="1" end="10" step="2" var="i" varStatus="s">
        \${i}${i}——>\${s.index}${s.index}——>\${s.count}${s.count}<br>
    </c:forEach><br>
<%
        List list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        request.setAttribute("list",list);
%>
    <c:forEach items="${list}" var="str" varStatus="s">
        ${str}——>${s.index}——>${s.count}<br>
    </c:forEach>


</body>
</html>
