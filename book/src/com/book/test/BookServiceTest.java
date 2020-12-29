package com.book.test;

import com.book.pojo.Book;
import com.book.service.BookService;
import com.book.service.impl.BookServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookServiceTest {

    private BookService bookService = new BookServiceImpl();

    @Test
    public void add() {
        bookService.add(new Book());
    }

    @Test
    public void deleteBook() {
    }

    @Test
    public void updateBook() {
    }

    @Test
    public void queryBook() {
    }

    @Test
    public void queryBooks() {
    }
}