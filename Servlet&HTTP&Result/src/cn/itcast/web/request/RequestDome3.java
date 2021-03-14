package cn.itcast.web.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/rd3")
/**
 * 获取请求头练习
 */
public class RequestDome3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");

        //根据请求头 user-agent 处理浏览器兼容
        String agent = req.getHeader("user-agent");
        if (agent.contains("Chrome")) {
            System.out.println("我是谷歌浏览器");
        }else if (agent.contains("Firefox")) {
            System.out.println("我是火狐浏览器");
        }

    }

    

    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost...");
    }
}
