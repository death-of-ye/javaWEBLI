package cn.idcast.web.servlet;

import jakarta.servlet.*;

import java.io.IOException;

/**
 * servlet入门
 */
public class ServletDome1 implements Servlet {

    /*
     * 初始化方法
     * 在Servlet被创建时执行，且只执行一次
     * @author death
     * @date 2021/3/12
     * @param servletConfig
     * @return void
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init.........");
    }


    /*
     * Servlet的配置方法
     * @param
     * @return jakarta.servlet.ServletConfig
     * @date   2021/3/12
     * @author death
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }


    /*
     * 提供服务的方法 每次访问Servlet时会执行，执行多次
     * @author death
     * @date 2021/3/12
     * @param servletRequest
     * @param servletResponse
     * @return void
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("hello Servlet");
    }


    /*
     * 获取Servlet的一些信息、版本
     * @param
     * @return java.lang.String
     * @date 2021/3/12
     * @author death
     */
    @Override
    public String getServletInfo() {
        return null;
    }


    /*
     * 在服务器正常关闭时执行，且只执行一次
     * 通俗的就是Servlet对象被销毁时触发
     * @author death
     * @date 2021/3/12
     * @param
     * @return void
     */
    @Override
    public void destroy() {
        System.out.println("destroy.........");
    }
}
