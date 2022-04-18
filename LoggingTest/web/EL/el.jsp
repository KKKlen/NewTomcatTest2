<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 86159
  Date: 2022/4/17
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${3>4}
    \${3>4}
<hr>

<h3>算术运算符</h3>
    ${3 + 4}<br>
    ${3 / 4}<br>
    ${3 div 4}<br>
    ${3 % 4}<br>
    <h3>比较运算符</h3>
    ${3 == 4}<br>
    <h3>逻辑运算符</h3>
    ${3>4&&3<4}

    <h3>empty空运算符</h3>
    <%
        String str = "";
        request.setAttribute("str",str);

        List list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        request.setAttribute("list",list);
    %>
    ${empty str}<br>
    ${not empty str}<br>
    ${empty list}<br>
    ${not empty list}

</body>
</html>
