package cn.itcast.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookiedemo3")
public class CookieMaxAgedemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * Cookie在浏览器中保存多长时间？
         * 	  * 默认情况下，浏览器关闭后，Cookie数据被销毁
         * 	  * 设置Cookie的生命周期，持久化存储
         * 	   ——setMaxAge(int seconds)
         * 		1、正数：将Cookie数据写到硬盘文件中，持久化存储x秒后自动销毁Cookie文件
         * 		2、负数：默认
         * 		3、零：删除Cookie信息
         */

        Cookie cookie = new Cookie("msg", "MaxAge");
//        cookie.setMaxAge(300);
//        cookie.setMaxAge(-1);
//        cookie.setMaxAge(0);
        response.addCookie(cookie);
//        String path = cookie.getPath();
//        System.out.println(path);
    }
}
