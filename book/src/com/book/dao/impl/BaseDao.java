package com.book.dao.impl;

import com.book.utils.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 数据操作
 * @author lijichen
 * @date 2020/10/10 - 18:55
 */
public abstract class BaseDao {
    //使用DBUtils操作数据
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * 增删改操作
     * @param sql 执行的sql语句
     * @param args 参数列表
     * @return 受影响行数
     */
    public int update(String sql, Object ...args) {
        Connection connection = JDBCUtil.getConnection();
        try {
            return queryRunner.update(connection,sql, args);
        } catch (Exception e) {
            e.printStackTrace();
            //将错误抛出去，使得第一层调用可以获取错误并回滚
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询返回一个javabean的sql语句
     * @param type 返回的对象类型
     * @param sql 执行的sql语句
     * @param args sql对应的参数值
     * @param <T> 返回的类型的泛型
     * @return
     */
    public <T> T queryForOne(Class<T> type,String sql, Object ...args) {
        Connection connection = JDBCUtil.getConnection();
        try {
            return queryRunner.query(connection,sql,new BeanHandler<T>(type),args);
        } catch (Exception e) {
            e.printStackTrace();
            //将错误抛出去，使得第一层调用可以获取错误并回滚
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询返回一个javabean的sql语句
     * @param type 返回的对象类型
     * @param sql 执行的sql语句
     * @param args sql对应的参数值
     * @param <T> 返回的类型的泛型
     * @return
     */
    public <T> List<T> queryForList(Class<T> type, String sql, Object ...args) {
        Connection connection = JDBCUtil.getConnection();
        try {
            return queryRunner.query(connection,sql,new BeanListHandler<T>(type),args);
        } catch (Exception e) {
            e.printStackTrace();
            //将错误抛出去，使得第一层调用可以获取错误并回滚
            throw new RuntimeException(e);
        }
    }

    /**
     * 执行返回一行一列的sql语句
     * @param sql 执行的sql语句
     * @param args sql对应的参数值
     * @return
     */
    public Object queryForSingleValue(String sql, Object ...args) {
        Connection connection = JDBCUtil.getConnection();

        try {
            return queryRunner.query(connection,sql,new ScalarHandler(),args);
        } catch (Exception e) {
            e.printStackTrace();
            //将错误抛出去，使得第一层调用可以获取错误并回滚
            throw new RuntimeException(e);
        }
    }
}
