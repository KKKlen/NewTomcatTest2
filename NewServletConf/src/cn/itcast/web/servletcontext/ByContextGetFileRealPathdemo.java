package cn.itcast.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/realpathdemo")
public class ByContextGetFileRealPathdemo extends HttpServlet {
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

        //获取文件的服务器真实路径
        String c = context.getRealPath("/WEB-INF/c.txt");//web-inf目录下的资源访问
        System.out.println(c);

        String b = context.getRealPath("/b.txt");//web目录下的资源访问
        System.out.println(b);

        String a = context.getRealPath("/WEB-INF/classes/a.txt");//src目录下的资源路径
        System.out.println(a);


        File file = new File(c);


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
