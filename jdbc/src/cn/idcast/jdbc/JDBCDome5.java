package cn.idcast.jdbc;

import cn.idcast.util.JDBCUtil;

import java.sql.*;
import java.util.Scanner;

/**
 * 综合小练习
 * 使用键盘录入 模拟登录
 * */
public class JDBCDome5 {

    public static void main(String[] args) {
        //1.创建键盘录入对象
        Scanner sc = new Scanner(System.in);
        //2.提示用户输入用户名
        System.out.println("请输入用户名");
        //3.接收用户名数据
        String uesrname = sc.nextLine();
        //4.提示用户输入密码
        System.out.println("请输入密码");
        //5.接收密码数据
        String password = sc.nextLine();
        if (uesrname == null || password == null){
            System.out.println("用户名或密码为空");
        }
        //6.调用登录方法模拟登录
        JDBCDome5 jdbcDome5 = new JDBCDome5();
        boolean login = jdbcDome5.login1(uesrname, password);
        //7.根据结果反馈用户
        if (login){
            System.out.println("登录成功");
        }else {
            System.out.println("用户名或密码不正确");
        }
    }

    /**
     * 定义一个方法模拟登录 使用 Statement
     * 会出现bug
     * 用户名随便输 密码 输入一个带java关键字的恒等式会提示登录成
     * 例如 username = djjjhfjhj;
     * password = a' or 'a' = 'a
     * */
    public boolean login(String username , String password){
        Connection conn = null;
        Statement stat = null;
        ResultSet res = null;
        try {
            //1.连接数据库
            conn = JDBCUtil.getConnection();
            //2.定义sql
            String sql = "select * from user where username = '" + username + "' && password = '" + password + "'";
            //3.获取执行sql对象
            stat = conn.createStatement();
            //4.执行sql
            res = stat.executeQuery(sql);
            //5.处理结果
            return res.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //6.释放资源
            JDBCUtil.close(res,conn,stat);
        }

        return false;
    }
    /**
     * 为解决上面的问题 使用
     * */
    public boolean login1(String username , String password){
        Connection conn = null;
        PreparedStatement pstat = null;
        ResultSet res = null;
        try {
            //1.连接数据库
            conn = JDBCUtil.getConnection();
            //2.定义sql
            String sql = "select * from user where username = ? and password = ?";
            //3.获取执行sql对象
            pstat = conn.prepareStatement(sql);
            //给?赋值
            pstat.setString(1,username);
            pstat.setString(2,password);
            //4.执行sql
            res = pstat.executeQuery();
            //5.处理结果
            return res.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //6.释放资源
            JDBCUtil.close(res,conn,pstat);
        }

        return false;
    }
}
