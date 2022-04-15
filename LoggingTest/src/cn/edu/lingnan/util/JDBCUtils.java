package cn.edu.lingnan.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * JDBC工具类，使用Druid连接池
 */

public class JDBCUtils {

    private static DataSource dataSource = null;

    static {
        try {
            //1、加载配置文件
            Properties properties = new Properties();
            //使用ClassLoader加载配置文件，获取字节输入流
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(is);
            //2、初始化连接池对象
            dataSource = DruidDataSourceFactory.createDataSource(properties);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 获取连接池对象
     */
    public static DataSource getDataSource(){
//        if (dataSource == null){
//            try {
//                dataSource = DruidDataSourceFactory.createDataSource(properties);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
        return dataSource;
    }


    /**
     * 获取连接Connection对象
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    //释放资源
    public static void close(ResultSet rs, PreparedStatement prep, Connection conn){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (prep!=null){
            try {
                prep.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn!=null){
            try {
                conn.close();//归还连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(PreparedStatement prep, Connection conn){
//        if (prep!=null){
//            try {
//                prep.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        if (conn!=null){
//            try {
//                conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
        close(null,prep,conn);
    }

}
