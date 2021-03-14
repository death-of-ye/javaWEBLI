package cn.itcast.web.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/dome123")
/**
 * Request练习
 */
public class RequestDome1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         /*
        获取请求行数据
        1.获取请求方式 getMethod()
        2.获取虚拟目录
        3.获取Servlet路径
        4.获取get请求参数
        5.获取请求URI
        6.获取请求URL
        7.获取协议及版本
         */
        //1.获取请求方式 getMethod()
        String method = req.getMethod();
        System.out.println("请求方法是: " + method);
        System.out.println("__________________________________");
        //2.获取虚拟目录
        String contextPath = req.getContextPath();
        System.out.println("虚拟路径是: " + contextPath);
        System.out.println("_________________________");
        //3.获取Servlet路径
        String servletPath = req.getServletPath();
        System.out.println("Servlet路径是: " + servletPath);
        System.out.println("_________________________");
        //4.获取get请求参数
        String queryString = req.getQueryString();
        System.out.println("请求参数是: " + queryString );
        System.out.println("_________________________");
        //5.获取请求URI
        String requestURI = req.getRequestURI();
        System.out.println("请求URI" + requestURI);
        System.out.println("_________________________");
        //6.获取请求URL
        StringBuffer requestURL = req.getRequestURL();
        System.out.println("请求URL" + requestURL);
        System.out.println("_________________________");
        //7.获取协议及版本
        String protocol = req.getProtocol();
        System.out.println("协议及版本" + protocol);
        System.out.println("_________________________");

    }

    

    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost...");
    }
}
