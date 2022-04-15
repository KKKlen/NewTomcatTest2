package cn.edu.lingnan.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int width = 160;
        int height = 80;

        //1、创建一个对象，在内存中图片（验证码图片对象）
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

        //2、美化
        //2.1 填充背景色
        Graphics graphics = image.getGraphics();//画笔对象
        graphics.setColor(Color.PINK);
        graphics.fillRect(0,0,width,height);
        //2.2 画边框
        graphics.setColor(Color.BLUE);
        graphics.drawRect(0,0,width-1,height-1);

        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        StringBuilder stringBuilder = new StringBuilder();
        //生成随机角标
        Random random = new Random();
        for (int i=1;i<=4;i++){
            int index = random.nextInt(str.length());
            //获取字符
            char c = str.charAt(index);
            stringBuilder.append(c);
            //2.3 写验证码
            graphics.setColor(Color.BLUE);
            graphics.drawString(c+"",width/5*i,height/2);
        }

        //将产生的随机验证码用String流对象记载
        String checkCode_session = stringBuilder.toString();
        //并将其存入session中
        req.getSession().setAttribute("checkCode_session",checkCode_session);

        //2.4 画干扰线
        graphics.setColor(Color.GREEN);
        for (int i = 0; i < 5; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            graphics.drawLine(x1,y1,x2,y2);
        }

        //3、将图片输出到页面展示
        ImageIO.write(image,"jpg",resp.getOutputStream());

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
