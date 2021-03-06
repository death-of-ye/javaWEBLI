package cn.itcast.web.servlet;

import cn.itcast.web.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/successServlet")
public class SuccessServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取共享域内容
        String user = req.getAttribute("user").toString();
        //2.判断
        if (user != null){
            req.setCharacterEncoding("utf-8");
            resp.getWriter().write("登录成功," + user + "欢迎您");
        }
    }
}
