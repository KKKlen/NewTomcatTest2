package cn.itcast.web.request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 演示Request对象获取请求操作
 */
@WebServlet("/requestdemo")
public class RequestHeader extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**请求行数据
         * ·GET  /program1_war_exploded/login.html   HTTP/1.1
         * 1、获取请求方式：GET——String getMethod()
         * 2、(*)获取虚拟目录：/program1_war_exploded——String getContextPath()
         * 3、获取Servlet路径：/login——String getServletPath()
         * 4、获取GET方式请求参数：String getQueryString()
         * 5、(*)获取请求URI：String getRequestURI()//String getRequestURL()
         * 6、获取协议版本：String getProtocol()
         * 7、获取客户机IP地址：String getRemoteAddr()
         */
        //1、获取请求方式
        String method = request.getMethod();
        System.out.println("method:"+method);
        //2、(*)获取虚拟目录
        String contextPath = request.getContextPath();
        System.out.println("contextPath:"+contextPath);
        //3、获取Servlet路径
        String servletPath = request.getServletPath();
        System.out.println("servletPath:"+servletPath);
        //4、获取GET方式请求参数
        String queryString = request.getQueryString();
        System.out.println("queryString:"+queryString);
        //5、(*)获取请求URI
        String requestURI = request.getRequestURI();
        StringBuffer requestURL = request.getRequestURL();
        System.out.println("requestURI:"+requestURI);
        System.out.println("requestURL:"+requestURL);
        //6、获取协议版本
        String protocol = request.getProtocol();
        System.out.println("protocol:"+protocol);
        //7、获取客户机IP地址
        String remoteAddr = request.getRemoteAddr();
        System.out.println("remoteAddr:"+remoteAddr);

        /**请求头数据
         *  String getHeader(String name)：通过请求头的名称获取请求头的值
         * 	Enumeration<String> getHeaderNames()：获取所有请求头名称
         */
        //1、获取所有请求头名称
        Enumeration<String> headerNames = request.getHeaderNames();
        //2、遍历
        while (headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            //根据名称获取请求头的值
            String value = request.getHeader(name);
            System.out.println(name + "---" + value);
        }

        String agent = request.getHeader("user-agent");
        //判断agent的浏览器版本
        if (agent.contains("Chrome")){
            System.out.println("Chrome's coming~");
        }else if (agent.contains("Firefox")){
            System.out.println("Firefox's Coming~");
        }

        String referer = request.getHeader("referer");
        System.out.println(referer);
        //防盗链
        if (referer != null){
            if (referer.contains("/NewServletConf_war_exploded")){
//                System.out.println("正常访问！！！");
                //响应中文输出response.setContentType("text/html;charset=utf-8")
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("正常访问！！！");
            }else {
//                System.out.println("想看吗？");
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("想看吗？");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
