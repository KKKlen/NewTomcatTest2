package cn.itcast.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getContextdemo")
public class GetContextdemo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //ServletContext对象的获取
        /**
         * 1、通过request对象获取
         * 	  *req.getServletContext();
         * 2、通过HttpServlet获取
         * 	  *this.getServletContext();
         */
        //通过request对象获取
        ServletContext context1 = req.getServletContext();
        //通过HttpServlet获取
        ServletContext context2 = this.getServletContext();

        System.out.println("context1:"+context1+"\n"+"context2"+context2);
        System.out.println(context1 == context2);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
