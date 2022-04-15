package cn.itcast.web.response;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet("/demo3")
public class respOutputStringToServer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 获取流之前，设置流的默认编码：ISO-8859-1
         * resp.setCharacterEncoding("utf-8");
         * 告诉浏览器，服务器发送的消息体数据的编码。建议浏览器使用该编码解码
         */
        resp.setHeader("content-type","text/html;charset=utf-8");
        //简单形式，设置编码
        resp.setContentType("text/html;charset=utf-8");
        //获取字符输出流
        PrintWriter writer = resp.getWriter();
        writer.write("<h1>你好Hello demo3</h1>");


        //获取字节输出流：多用于图片输出
        ServletOutputStream sos = resp.getOutputStream();
        //输出数据
        sos.write("hello".getBytes(StandardCharsets.UTF_8));

    }
}
