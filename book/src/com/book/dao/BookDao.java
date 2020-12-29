package com.book.dao;

import com.book.pojo.Book;

import java.util.List;

/**
 * @author lijichen
 * @date 2020/10/14 - 15:56
 */
public interface BookDao {
    /**
     * 添加一本书
     * @param book
     * @return
     */
    int addBook(Book book);

    /**
     * 按照id删除书
     * @param id
     * @return
     */
    int deleteBookById(Integer id);

    /**
     * 修改书的信息
     * @param book
     * @return
     */
    int updateBook(Book book);

    /**
     *按照id查询书
     * @param id
     * @return
     */
    Book queryBookById(Integer id);

    /**
     * 查询所有的书
     * @return
     */
    List<Book> queryBooks();

    /**
     * 获取所有书籍数目
     * @return
     */
    Integer getPageTotalCountByBook();

    /**
     * 获取分页后的数据集合
     * @param begin
     * @param pageSize
     * @return
     */
    List<Book> queryBooksItem(Integer begin, Integer pageSize);

    /**
     * 获取改价格区间内的书籍数目
     * @param minPrice
     * @param maxPrice
     * @return
     */
    Integer getPageTotalCountByBook(Integer minPrice, Integer maxPrice);

    /**
     * 按照价格查询分页和排序
     * @param minPrice
     * @param maxPrice
     * @param begin
     * @param pageSize
     * @return
     */
    List<Book> queryBooksItem(Integer minPrice, Integer maxPrice, Integer begin, Integer pageSize);
}
