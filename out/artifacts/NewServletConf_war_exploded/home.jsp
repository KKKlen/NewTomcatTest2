<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: 86159
  Date: 2022/4/13
  Time: 8:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>helloitcast</title>
</head>
<body>
    <%
        //获取Cookies
        Cookie[] cookies = request.getCookies();

        boolean flag = false;

        if (cookies != null && cookies.length > 0){
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                //判断名称是否为last time
                if ("lastTime".equals(name)){
                    //已有Cookie，不是首次访问
                    flag = true;

                    //响应数据
                    String value = cookie.getValue();
                    System.out.println("解码前的value："+value);
                    //URL解码
                    value = URLDecoder.decode(value,"utf-8");
                    System.out.println("解码后的value："+value);
    %>
                    <h1>欢迎回来，你上次最后访问时间为:<%=value%></h1>
    <%
                    //设置Cookie中value值
                    //获取当前时间的字符串，重新设置Cookie值，重新发送Cookie
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年mm月dd日 HH:mm:ss");
                    String str_date = sdf.format(date);
                    System.out.println("编码前的数据："+str_date);
                    //URL编码
                    str_date = URLEncoder.encode(str_date, "utf-8");
                    System.out.println("编码后的数据："+str_date);
                    cookie.setValue(str_date);
                    //设置Cookie的存活时间
                    cookie.setMaxAge(60*30);
                    response.addCookie(cookie);

                    break;
                }
            }
        }else if (cookies==null||cookies.length==0||flag==false){
            //设置Cookie中value值
            //获取当前时间的字符串，重新设置Cookie值，重新发送Cookie
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String str_date = sdf.format(date);
            System.out.println("编码前的数据："+str_date);
            //URL编码
            str_date = URLEncoder.encode(str_date, "utf-8");
            System.out.println("编码后的数据："+str_date);

            Cookie cookie = new Cookie("lastTime",str_date);
            //设置Cookie的存活时间
            cookie.setMaxAge(60*60*24*30);
            response.addCookie(cookie);
    %>
            //响应数据
            <h1>您好，欢迎首次访问页面</h1>
<%
        }
%>
</body>
</html>
