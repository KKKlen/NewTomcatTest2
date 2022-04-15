package cn.edu.lingnan.dao;

import cn.edu.lingnan.util.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

public class Templatedemo {
    public static void main(String[] args) {
        //创建template对象
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        //调用方法
        String sql="update user set username='admin' where id = ?";
        int count = template.update(sql,1);
        System.out.println(count);
    }
}
