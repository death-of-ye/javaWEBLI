package cn.itcast.web.servlet;

import cn.itcast.web.dao.UserDao;
import cn.itcast.web.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("11111");
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置编码
        req.setCharacterEncoding("utf-8");
        //2.获取请求参数
        String username = req.getParameter("user");
        String password = req.getParameter("pass");
        //3.将获取到的数据封装成User对象
        User loginUsers = new User();
        loginUsers.setUsername(username);
        loginUsers.setPassword(password);
//        Map<String, String[]> parameterMap = req.getParameterMap();
//        //3.创建User对象
//        User loginUsers = new User();
//        //3.1 使用beanUtils封装
//        try {
//            BeanUtils.populate(loginUsers,parameterMap);
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
        //4.调用UserDAO的login方法
        UserDao dao = new UserDao();
        //5.判断
        User loginUser = dao.login(loginUsers);
        System.out.println(loginUser);
        if (loginUser != null) {
            //登录成功
            req.setAttribute("user",username);
            req.getRequestDispatcher("/successServlet").forward(req,resp);
        }else {
            //登录失败
            req.getRequestDispatcher("/failServlet").forward(req,resp);
        }
    }
}
