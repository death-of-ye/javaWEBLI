package cn.idcast.jdbc;

import java.sql.Connection;
import java.sql.DriverAction;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *JDBC快速入门
 * */
public class JdbcDome1 {

    public static void main(String[] args) throws Exception {
        //1.导包
        //2.注册驱动
//        Class.forName("com.mysql.cj.jdbc.Driver");
        //3获取数据库连接对象
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3","root","root");
        String sql = "update account set balance = 500 where id = 1";
        //5.获取执行SQL的对象
        Statement statement = con.createStatement();
        //6.执行SQL
        int count = statement.executeUpdate(sql);
        //7.处理结果
        System.out.println(count);
        //8.释放资源
        statement.close();
        con.close();
    }
}
