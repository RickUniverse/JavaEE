package com.book.dao.impl;

import com.book.dao.BookDao;
import com.book.pojo.Book;

import java.util.List;
import java.util.concurrent.locks.Condition;

/**
 * 图书dao实现类
 * @author lijichen
 * @date 2020/10/14 - 16:01
 */
public class BookDaoImpl extends BaseDao implements BookDao {
    @Override
    public int addBook(Book book) {
        String sql = "INSERT INTO t_book(`name`,`price`,`author`,`sales`,`stock`,`img_path`) VALUES(?,?,?,?,?,?)";
        return update(sql, book.getName(),book.getPrice(),book.getAuthor(),book.getSales(),book.getStock(),book.getImgPath());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from t_book where id = ?";
        return update(sql,id);
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set `name`=?,`price`=?,`author`=?,`sales`=?,`stock`=?,`img_path`=? where id = ?";
        return update(sql,book.getName(),book.getPrice(),book.getAuthor(),book.getSales(),book.getStock(),book.getImgPath(),book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "select `id`,`name`,`price`,`author`,`sales`,`stock`,`img_path` imgPath from t_book where id = ?";
        return queryForOne(Book.class,sql,id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "select `id`,`name`,`price`,`author`,`sales`,`stock`,`img_path` imgPath from t_book";
        return queryForList(Book.class,sql);
    }

    @Override
    public Integer getPageTotalCountByBook() {
        String sql = "select count(*) from t_book";
        Number count = (Number) queryForSingleValue(sql);
        return count.intValue();
    }

    @Override
    public List<Book> queryBooksItem(Integer begin, Integer pageSize) {
        String sql = "select `id`,`name`,`price`,`author`,`sales`,`stock`,`img_path` imgPath from t_book limit ?,?";
        return queryForList(Book.class,sql,begin,pageSize);
    }

    @Override
    public Integer getPageTotalCountByBook(Integer minPrice, Integer maxPrice) {
        String sql = "select count(*) from t_book where price between ? and ?";
        Number count = (Number) queryForSingleValue(sql,minPrice,maxPrice);
        return count.intValue();
    }

    @Override
    public List<Book> queryBooksItem(Integer minPrice, Integer maxPrice, Integer begin, Integer pageSize) {
        String sql = "select `id`,`name`,`price`,`author`,`sales`,`stock`,`img_path` imgPath " +
                "from t_book where price between ? and ? " +
                "order by price " +
                " limit ?,?";
        return queryForList(Book.class,sql,minPrice,maxPrice,begin,pageSize);
    }
}
