package cn.itcast.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookiedemo2")
public class GetCookiedemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 1、创建Cookie对象，绑定数据——new Cookie(String name,String value)
         * 	2、发送Cookie对象——resp.addCookie(Cookie cookie)
         * 	3、获取Cookie，拿到数据——Cookie [] = req.getCookie()
         */

        //获取Cookie
        Cookie[] cookies = request.getCookies();
        //获取数据，遍历Cookies
        if (cookies!=null){
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                String value = cookie.getValue();
                System.out.println(name +"——"+ value);
            }
        }else {
            System.out.println("req中cookies获取为空值，有可能不是同一次会话（如向获得resp外的浏览器，去申请请求）");
        }
    }
}
