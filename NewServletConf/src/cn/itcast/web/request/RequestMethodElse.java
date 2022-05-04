package cn.itcast.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/register2")
public class RequestMethodElse extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        /**根据请求参数名称获取参数值,如url后的?username=zs&password=123*/
        String username = req.getParameter("username");
        System.out.println("Get--");
        System.out.println(username);
        /**根据参数名称获取参数值的数组,如hobby=xx&hobby=xxx*/
        String[] hobbies = req.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }
        /**根据所有请求的参数名称获取*/
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String name = parameterNames.nextElement();
            String value = req.getParameter(name);
            System.out.println(name+"----"+value);
        }
        /**获取所有参数的map集合*/
        Map<String, String[]> parameterMap = req.getParameterMap();
        //遍历：map.keySet()
        Set<String> keySet = parameterMap.keySet();
        for (String name : keySet) {
            //获取键获取值
            String[] values = parameterMap.get(name);
            System.out.println(name);
            for (String value : values) {
                System.out.println(value);
            }
            System.out.println("------------");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        //根据请求参数名称获取参数值,如url后的?username=zs&password=123
//        String username = req.getParameter("username");
//        System.out.println("Post");
//        System.out.println(username);
        doPost(req, resp);
    }
}
