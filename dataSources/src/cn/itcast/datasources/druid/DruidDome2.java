package cn.itcast.datasources.druid;

import cn.itcast.datasources.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 测试druid工具类
 * */
public class DruidDome2 {
    public static void main(String[] args) {
        int res = ceshi();
        System.out.println(res);
    }

    /**
     * 测试工具类
     * */
    public static int ceshi() {
        Connection conn = null;
        PreparedStatement pstem = null;
        try {
            //1.获取连接对象
            conn = JDBCUtils.getConnection();
            //2.定义SQL
            String sql = "insert into account values(null,?,?)";
            //3.获取执行sql对象
            pstem = conn.prepareStatement(sql);
            //4.给?赋值
            pstem.setString(1,"王五");
            pstem.setDouble(2,5000);
            //5.执行SQL
            int count = pstem.executeUpdate();
            return count;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //6.释放资源
            JDBCUtils.close(pstem,conn);
        }
        return 10010;
    }
}
