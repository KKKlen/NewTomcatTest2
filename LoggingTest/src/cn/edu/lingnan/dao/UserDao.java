package cn.edu.lingnan.dao;

import cn.edu.lingnan.domain.User;
import cn.edu.lingnan.util.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {

    //声明JDBCTemplate对象共用
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    public User login(User login){



        return null;
    }

}
