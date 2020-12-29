package com.book.service;

import com.book.pojo.Book;
import com.book.pojo.Page;

import java.util.List;

/**
 * @author lijichen
 * @date 2020/10/14 - 16:50
 */
public interface BookService {

    /**
     * 添加书
     * @param book
     * @return 如果是true添加成功 ， false表示添加失败
     */
    boolean add(Book book);

    /**
     * 删除书
     * @param id
     * @return 如果是true删除成功 ， false表示删除失败
     */
    boolean deleteBook(int id);

    /**
     * 修改书
     * @param book
     * @return 如果是true修改成功 ， false表示修改失败
     */
    boolean updateBook(Book book);

    /**
     * 查询单个书
     * @param id
     * @return 返回单个书
     */
    Book queryBook(int id);

    /**
     * 查询所有书
     * @return 返回所有书
     */
    List<Book> queryBooks();
    /**
     * 分页
     * @param pageNo
     * @param pageSize
     * @return
     */
    Page<Book> queryPageByBeginAndPageSize(Integer pageNo, Integer pageSize);
    /**
     * 重载的按照价格进行分页
     * @param minPrice
     * @param maxPrice
     * @param pageNo
     * @param pageSize
     * @return
     */
    Page<Book> queryPageByBeginAndPageSize(Integer minPrice, Integer maxPrice, Integer pageNo, Integer pageSize);
}
