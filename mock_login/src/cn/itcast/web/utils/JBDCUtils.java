package cn.itcast.web.utils;

import com.alibaba.druid.pool.DruidAbstractDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.jdbc.datasource.embedded.DataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * JDBC工具类
 */
public class JBDCUtils {

    private static DataSource ds;

    static {
        try {
            //1.创建Properties对象
            Properties pro = new Properties();
            //2.加载配置
            InputStream druid = JBDCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(druid);
            //3.初始化连接池对象
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * 获取连接池对象
     * @param
     * @return javax.sql.DataSource
     * @author death
     * @date 2021/3/13
     */
    public static DataSource getDataSouce() {
        return ds;
    }

    /*
     * 获取
     * @param
     * @return java.sql.Connection
     * @author death
     * @date 2021/3/14
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
