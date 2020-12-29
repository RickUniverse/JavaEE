package com.book.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 数据库连接工具类
 * @author lijichen
 * @date 2020/10/10 - 18:02
 */
public class JDBCUtil {
    //获取数据库连接池
    public static DruidDataSource dataSource = null;

    //事务专用
    public static ThreadLocal<Connection> conns = new ThreadLocal<>();

    //获取数据库连接
    static {
        try {
            Properties pro = new Properties();
            InputStream is = JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
            pro.load(is);
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取数据库连接中的链接
    public static Connection getConnection() {

        Connection connection = conns.get();
        //一个线程第一次请求获取连接的情况
        if (connection == null) {
            try {
                connection = dataSource.getConnection();

                //保存到当前线程共享连接
                conns.set(connection);

                //设置开启事务
                connection.setAutoCommit(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    /**
     * 提交并关闭连接
     */
    public static void commitAndClose() {
        Connection connection = conns.get();
        if (connection != null) {
            //提交事务
            try {
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                //设置重新设置为自动提交
                try {
                    connection.setAutoCommit(true);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                //关闭连接
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //一定要执行remove操作,因为tomcat底层使用了线程池技术
        /*
        * 我没有执行所以报错了
        * */
        conns.remove();
    }

    /**
     * 回滚并关闭连接
     */
    public static void rollbackAndClose() {
        Connection connection = conns.get();
        if (connection != null) {
            //提交事务
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                //设置重新设置为自动提交
                try {
                    connection.setAutoCommit(true);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                //关闭连接
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //一定要执行remove操作
        /*
         * 我没有执行所以报错了
         * */
        conns.remove();
    }
}
