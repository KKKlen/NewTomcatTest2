package cn.itcast.web.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/demo1")
public class Respchongdingxiang extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("重定向被访问");
//        //访问demo1时，会自动跳转到demo2
//        //1、设置状态码为302
//        resp.setStatus(302);
//        //2、设置响应头location
//        resp.setHeader("location","/demo2");

        req.setAttribute("msg","msg");

        //简单的重定向方法
        resp.sendRedirect("/NewServletConf_war_exploded/demo2");

    }
}
