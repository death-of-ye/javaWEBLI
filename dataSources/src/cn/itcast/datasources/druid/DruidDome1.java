package cn.itcast.datasources.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * druid演示
 * */
public class DruidDome1 {

    public static void main(String[] args) {
        //1.导包
        //2.配置文件
        try {
            //3.加载配置文件
            Properties pro = new Properties();
            InputStream path = DruidDome1.class.getClassLoader().getResourceAsStream("druid.properties");
            System.out.println(path);
            pro.load(path);
            //4.获取连接池对象
            DataSource ds = DruidDataSourceFactory.createDataSource(pro);
            //5.获取连接对象
            Connection conn = ds.getConnection();
            System.out.println(conn);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
