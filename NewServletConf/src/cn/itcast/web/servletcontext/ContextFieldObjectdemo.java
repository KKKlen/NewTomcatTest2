package cn.itcast.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/contextFieldObjectdemo")
public class ContextFieldObjectdemo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //ServletContext对象的功能
        /**
         * 1、获取MIME类型：
         * 	  *MIME类型：在互联网通信过程中定义的一种文件数据类型
         * 	     *格式：大类型/小类型—— text/html、image/jpeg
         * 	  *获取：String getMimeType(Sring file);
         * 	2、域对象：共享数据
         * 	3、获取文件的真实路径/服务器路径
         */
        //通过request对象获取
        //ServletContext context1 = req.getServletContext();
        //通过HttpServlet获取
        ServletContext context = this.getServletContext();

        /**2\域对象*/
        context.setAttribute("msg","haha我是context下获取的域对象定义的msg的值");


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
