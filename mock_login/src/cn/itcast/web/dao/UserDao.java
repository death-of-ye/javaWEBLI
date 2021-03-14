package cn.itcast.web.dao;

import cn.itcast.web.entity.User;
import cn.itcast.web.utils.JBDCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * user表操作类
 */
public class UserDao {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JBDCUtils.getDataSouce());

    /*
     * 登录功能
     * @param loginUser
     * @return cn.itcast.web.entity.User
     * @author death
     * @date 2021/3/13
     */
    public User login(User loginUsers) {
        try {
            //1.编写sql
            String sql = "select * from user where username = ? and password = ?";
            //2.调用query方法
            User user = jdbcTemplate.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUsers.getUsername(), loginUsers.getPassword());
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();//记录日志
            return null;
        }
    }
}
