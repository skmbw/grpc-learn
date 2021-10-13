package com.xueershangda.tianxun;

import com.vteba.tutorial.Book;
import com.vteba.tutorial.BookService;
import com.vteba.tutorial.GetBookRequest;
import com.vteba.tutorial.QueryBooksRequest;

import java.util.concurrent.CompletableFuture;

public class BookServiceImpl implements BookService {
    @Override
    public Book getBook(GetBookRequest request) {
        return null;
    }

    @Override
    public CompletableFuture<Book> getBookAsync(GetBookRequest request) {
        return null;
    }

    @Override
    public Book queryBooks(QueryBooksRequest request) {
        return null;
    }

    @Override
    public CompletableFuture<Book> queryBooksAsync(QueryBooksRequest request) {
        return null;
    }
}
