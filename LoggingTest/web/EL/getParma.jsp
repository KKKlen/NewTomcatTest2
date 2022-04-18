<%@ page import="cn.edu.lingnan.domain.User" %>
<%@ page import="java.util.*" %><%--
  Created by IntelliJ IDEA.
  User: 86159
  Date: 2022/4/17
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        session.setAttribute("name","里斯");
        request.setAttribute("name","狂徒");
        session.setAttribute("age",23);
        User user = new User();
        user.setUsername("克林");
        user.setPassword("333");
        user.setBirthday(new Date());
        request.setAttribute("user",user);

        List list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add(user);
        request.setAttribute("list",list);

        Map map = new HashMap();
        map.put("sname","所大大");
        map.put("gender","男");
        map.put("user",user);
        request.setAttribute("map",map);

    %>

    <h3>el表达式获取域值</h3>
    ${requestScope.name}
    ${sessionScope.age}
    ${name}
    ${sessionScope.name}

    <h3>获取对象中的值</h3>
    <%--
        * 通过的是对象的属性来获得
            * setter/getter方法，去掉set/get后，在将剩余部分，首字母小写
                * setName ——> Name ——> name
    --%>
    ${user.username}<br>
    ${user.birthday.month}<br>
    ${user.birToStr}<br>

    <h3>获取List集合中的值</h3>
    ${list}<br>
    ${list[0]}
    ${list[1]}
    ${list[9]}
    ${list[3].username}

    <h3>获取Map集合中的值</h3>
    ${requestScope.map.gender}<br>
    ${map["gender"]}<br>
    ${map.user.username}

</body>
</html>
