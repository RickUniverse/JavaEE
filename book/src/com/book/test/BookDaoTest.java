package com.book.test;

import com.book.dao.BookDao;
import com.book.dao.impl.BookDaoImpl;
import com.book.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookDaoTest {

    private BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        System.out.println(bookDao.addBook(new Book(0, "aaaa", new BigDecimal(1000.11), "里", 13232, 12312, null)));
    }

    @Test
    public void deleteBookById() {
        System.out.println(bookDao.deleteBookById(11));
    }

    @Test
    public void updateBook() {
        System.out.println(bookDao.updateBook(new Book(11, "aaffaa", new BigDecimal(100330.11), "里3", 13232, 12312, "") ));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(11));
    }

    @Test
    public void queryBooks() {
        bookDao.queryBooks().forEach(System.out::println);
    }

    @Test
    public void getPageTotalCountByBook() {
        System.out.println(bookDao.getPageTotalCountByBook());
    }

    @Test
    public void queryBooksItem() {
        System.out.println(bookDao.queryBooksItem(0, 3));
        int i = 1;
//        int i1 = i++;
        int i2 = i + 1;
//        System.out.println(i1);
        System.out.println(i2);
        System.out.println(i);
    }

    @Test
    public void getPageTotalCountByBook2(){
        System.out.println(bookDao.getPageTotalCountByBook(0, 31));
    }
    @Test
    public void queryBooksItem2(){
        System.out.println(bookDao.queryBooksItem(0, 31, 0, 4));
    }
}