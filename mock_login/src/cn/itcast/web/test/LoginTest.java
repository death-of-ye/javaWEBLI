package cn.itcast.web.test;

import cn.itcast.web.dao.UserDao;
import cn.itcast.web.entity.User;
import org.junit.Test;

public class LoginTest {

    @Test
    public void testLogin(){
        User loginuser = new User();
        loginuser.setUsername("root");
        loginuser.setPassword("root");


        UserDao dao = new UserDao();
        User user = dao.login(loginuser);

        System.out.println(user);
    }
}
