package cn.idcast.util;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC工具类
 * */
public class JDBCUtil {

    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    static {
        //1. 创建Properties集合类。
        Properties pro = new Properties();
        //获取src路径下的文件的方式--->ClassLoader 类加载器
        ClassLoader classLoader = JDBCUtil.class.getClassLoader();
        URL res = classLoader.getResource("jdbc.properties");
        String path = res.getPath();
        try {
            //2.加载文件
            pro.load(new FileReader(path));
            //3.获取数据并赋值
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");
            //4.注册驱动
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }

    /**
     * 更新数据用于释放资源
     * */
    public static void close(Connection conn, Statement stat) {
        if(stat != null) {
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 查询数据用于释放资源
     * */
    public static void close(ResultSet res, Connection conn, Statement stat) {
        if(res != null) {
            try {
                res.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stat != null) {
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
