package cn.idcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 练习添加一条数据
 * */
public class JDBCDome2 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获取连接数据库对象
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db3", "root", "root");
            //3.定义SQL
            String sql = "insert into account values(null,'刘智超',15000)";
            //4.获取执行SQL对象
            stat = conn.createStatement();
            //5.执行SQL
            int count = stat.executeUpdate(sql);//影响的行数
            //6.处理结果
            System.out.println(count);
            if (count > 0) {
                System.out.println("添加成功");
            }else{
                System.out.println("添加失败");
            }
            //7.释放资源
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
