package cn.edu.lingnan.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //获取参数Map集合
//        Map<String, String[]> map = req.getParameterMap();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String checkCode = req.getParameter("checkCode");
        //先获取生成的验证码
        HttpSession session = req.getSession();
        String checkCode_session = (String) session.getAttribute("checkCode_session");
        //判断验证码是否正确
        //忽略大小写比较"".equalsIgnoreCase()
        if (checkCode_session.equalsIgnoreCase(checkCode)){
            //验证码一致
            if ("Colin".equals(username)&&"333".equals(password)){
                //需要调用userDao查询数据库
                //登录成功
                //存储信息——用户信息
                session.setAttribute("name",username);
                //重定向到success.jsp
                resp.sendRedirect(req.getContextPath()+"/success.jsp");

            }else {
                //登录失败
                //存储提示信息到request域
                req.setAttribute("login_error","用户名或密码错误");
                //转发到登录页面
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }

        }else {
            //验证码不一致
            //存储提示信息到request域
            req.setAttribute("cc_error","验证码错误");
            //转发到登录页面
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }

    }
}
