package com.book.service.impl;

import com.book.dao.BookDao;
import com.book.dao.impl.BookDaoImpl;
import com.book.pojo.Book;
import com.book.pojo.Page;
import com.book.service.BookService;

import java.util.List;

/**
 * @author lijichen
 * @date 2020/10/14 - 16:53
 */
public class BookServiceImpl implements BookService {

    private static BookDao bookDao = new BookDaoImpl();

    @Override
    public boolean add(Book book) {
        return bookDao.addBook(book) > 0;
    }

    @Override
    public boolean deleteBook(int id) {
        return bookDao.deleteBookById(id) > 0;
    }

    @Override
    public boolean updateBook(Book book) {
        return bookDao.updateBook(book) > 0;
    }

    @Override
    public Book queryBook(int id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> queryPageByBeginAndPageSize(Integer pageNo, Integer pageSize) {
        Page<Book> page = new Page<>();

        //设置每页条数
        page.setPageSize(pageSize);
        //设置总条数
        Integer pageTotalCount = bookDao.getPageTotalCountByBook();
        page.setPageTotalCount(pageTotalCount);
        //设置总页数
        Integer pageTotal = (page.getPageTotalCount() - 1) / page.getPageSize() + 1;
        page.setPageTotal(pageTotal);

        //设置当前页,放到后面，因为判断中用到了pageTotal
        page.setPageNo(pageNo);

        //设置itembook集合
        Integer begin = (page.getPageNo() - 1) * page.getPageSize();
        List<Book> listBook = bookDao.queryBooksItem(begin,pageSize);
        page.setItems(listBook);


        return page;
    }


    @Override
    public Page<Book> queryPageByBeginAndPageSize(Integer minPrice, Integer maxPrice, Integer pageNo, Integer pageSize) {
        Page<Book> page = new Page<>();

        //设置每页条数
        page.setPageSize(pageSize);
        //设置总条数
        Integer pageTotalCount = bookDao.getPageTotalCountByBook(minPrice,maxPrice);
        page.setPageTotalCount(pageTotalCount);
        //设置总页数
        Integer pageTotal = (page.getPageTotalCount() - 1) / page.getPageSize() + 1;
        page.setPageTotal(pageTotal);

        //设置当前页,放到后面，因为判断中用到了pageTotal
        page.setPageNo(pageNo);

        //设置itembook集合
        Integer begin = (page.getPageNo() - 1) * page.getPageSize();
        List<Book> listBook = bookDao.queryBooksItem(minPrice,maxPrice,begin,pageSize);
        page.setItems(listBook);


        return page;
    }
}
