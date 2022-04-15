package cn.itcast.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/cookieTest")
public class CookieTest extends HttpServlet {

    /**
     * 需求：
     * 	1、访问一个Servlet，如果是第一次访问，则提示：你好，欢迎您首次访问~
     * 	2、如果不是第二次访问，则提示：欢迎回来，你上次访问时间为：显示时间字符串
     * 分析：
     * 	1、可以采用Cookie来完成.
     * 	2、在服务器中的Servlet判断是否有一个名为lastTime的Cookie
     * 		*有：不是第一次访问——响应数据：欢迎回来，上次访问时间为：？？；写回Cookie：lastTime=？
     * 		*没有：第一次访问——响应数据：欢迎首次访问；写回Cookie：lastTime=？？这里add的是首次访问时间
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应消息体的数据格式
        response.setContentType("text/html;charset=utf-8");

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
                    response.getWriter().write("<h1>欢迎回来，你上次最后访问时间为"+value+"</h1>");

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
                    cookie.setMaxAge(60*5);
                    response.addCookie(cookie);

                    break;
                }
            }
        }else if (cookies==null||cookies.length==0||flag==false){

            //获取当前时间的字符串，重新设置Cookie值，重新发送Cookie
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String str_date = sdf.format(date);
            System.out.println("编码前的数据："+str_date);
            //URL编码
            str_date = URLEncoder.encode(str_date, "utf-8");
            System.out.println("编码后的数据："+str_date);

            //设置Cookie中value值
            Cookie cookie = new Cookie("lastTime",str_date);
            //设置Cookie的存活时间
            cookie.setMaxAge(60*5);
            response.addCookie(cookie);

            //响应数据
            response.getWriter().write("<h1>您好，欢迎首次访问页面</h1>");
        }

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }


}
