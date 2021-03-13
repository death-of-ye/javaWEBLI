package cn.itcast.datasources.JdbcTemplate;

import cn.itcast.datasources.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * JdbcTemplate入门
 * */
public class JdbcTemplateDome {
    public static void main(String[] args) {
        //1.导包
        //2.创建JdbcTemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
        //3.调用方法执行SQL
        String sql = "update account set balance = 1000 where id = ?";
        int count = jdbcTemplate.update(sql,1);
        System.out.println(count);
    }
}
