<%--
  Created by IntelliJ IDEA.
  User: 86159
  Date: 2022/4/14
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>

    <script>
        window.onload = function () {
            document.getElementById("img").onclick = function () {
                this.src="/LoggingTest_war_exploded/checkCodeServlet?time="+new Date().getTime();
            }
        }
    </script>

    <style>
        div{
            color: red;
        }
    </style>

</head>
<body>
<form action="login" method="post">
    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td>验证码</td>
            <td><input type="text" name="checkCode"></td>
        </tr>
        <tr>
            <td colspan="2"><img id="img" src="/LoggingTest_war_exploded/checkCodeServlet"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" name="登陆"></td>
        </tr>
    </table>

</form>
    <div>
        <%=request.getAttribute("cc_error")%>
    </div>

    <div>
        <%=request.getAttribute("login_error")%>
    </div>
</body>
</html>
