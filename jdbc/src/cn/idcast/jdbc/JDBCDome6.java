package cn.idcast.jdbc;

import cn.idcast.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 学习事务小练习
 * */
public class JDBCDome6 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pst1 = null;
        PreparedStatement pst2 = null;
        try {
            //1.连接数据库
            conn = JDBCUtil.getConnection();
            //开启事务
            conn.setAutoCommit(false);
            //2.定义sql
            //张三借给李四500元
            String sql1 = "update account set balance = balance - ? where id = ?";
            //李四得到张三500元
            String sql2 = "update account set balance = balance + ? where id = ?";
            //3.获取执行sql对象
            pst1 = conn.prepareStatement(sql1);
            pst2 = conn.prepareStatement(sql2);
            //4.给?赋值
            pst1.setDouble(1,500);
            pst1.setInt(2,1);
            pst2.setDouble(1,500);
            pst2.setInt(2,2);
            //5.执行sql
            pst1.executeUpdate();
            int a = 10/0;
            pst2.executeUpdate();

            //如果没保错就提交事务
            conn.commit();

        } catch (Exception e) {
            //不管是报的什么错 ，只要错误就执行回滚事务
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            //6.释放资源
            JDBCUtil.close(conn,pst1);
            JDBCUtil.close(null,pst2);
        }
    }
}
