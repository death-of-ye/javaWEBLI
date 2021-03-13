package cn.idcast.jdbc;

import java.sql.*;

/**
 * 使用JDBC查询练习
 *
 * */
public class JDBCDome3 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        ResultSet res = null;
        try {
            //1.注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获取连接数据对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root", "root");
            //3.定义SQL
            String sql = "select * from account";
            //4.获取执行SQL对象
            stat = conn.createStatement();
            //5.执行SQL
            res = stat.executeQuery(sql);
            //6.处理结果
            while (res.next()) {
                int id = res.getInt("id");
                String name = res.getString("name");
                int balance = res.getInt("balance");
                System.out.println(id + "----" + name + "----" + balance);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
           //7.释放资源
           if (res != null) {
               try {
                   res.close();
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

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
