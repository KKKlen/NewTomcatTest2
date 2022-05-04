package cn.itcast.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/cookiedemo")
public class Cookiedemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         *  1、创建Cookie对象，绑定数据——new Cookie(String name,String value)
         * 	2、发送Cookie对象——resp.addCookie(Cookie cookie)
         * 	3、获取Cookie，拿到数据——Cookie [] = req.getCookie()
         */

        //创建Cookie对象，绑定数据
        Cookie cookie = new Cookie("msg","helloCookie~");

        //设置Cookie.setPath()，代表Cookie的获取范围
        //默认情况下是当前虚拟目录
        //即cookie.setpath("/NewServletConf_war_exploded")
        //如果要共享，则可以将cookie.setPath置为("/")，
        //运行在当前服务器下的所有pro都可以共享cookie信息
//        cookie.setPath("/");

        //发送Cookie对象
        response.addCookie(cookie);

    }
}
