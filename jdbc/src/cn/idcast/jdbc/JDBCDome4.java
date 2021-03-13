package cn.idcast.jdbc;

import cn.idcast.entity.Account;
import cn.idcast.util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/***
 * JDBC练习
 * 定义一个方法将查询到的数据装载到集合中，以便拿出来使用
 */
public class JDBCDome4 {
    public static void main(String[] args) {
        JDBCDome4 jdbcDome4 = new JDBCDome4();
        List<Account> res = JDBCDome4.findAll();
        System.out.println(res.get(0).getId());
    }



    public static List<Account> findAll() {
        Connection conn = null;
        Statement stat = null;
        ResultSet res = null;
        List<Account> list = null;
        try {
//            //1.注册驱动
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            //2.获取连接数据对象
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root", "root");
            conn = JDBCUtil.getConnection();
            //3.定义SQL
            String sql = "select * from account";
            //4.获取执行SQL对象
            stat = conn.createStatement();
            //5.执行SQL
            res = stat.executeQuery(sql);
            //6.处理结果
            Account account = null;
            list = new ArrayList<Account>();
            while (res.next()) {
                int id = res.getInt("id");
                String name = res.getString("name");
                int balance = res.getInt("balance");
//                System.out.println(id + "----" + name + "----" + balance);
                //创建Account对象
                account = new Account();
                account.setId(id);
                account.setName(name);
                account.setBalance(balance);
                //装载集合
                list.add(account);
            }

        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //7.释放资源
           JDBCUtil.close(res,conn,stat);
        }
        return list;
    }
}
