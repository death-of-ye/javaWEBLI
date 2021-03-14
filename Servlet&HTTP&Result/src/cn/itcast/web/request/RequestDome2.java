package cn.itcast.web.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/rd2")
/**
 * 获取请求头练习
 */
public class RequestDome2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取所有请求头
        Enumeration<String> headerNames = req.getHeaderNames();
        //遍历
        while (headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            //根据名称获取请求头的值
            String value = req.getHeader(name);
            //打印
            System.out.println(name + ":" +value);
        }

    }

    

    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost...");
    }
}
