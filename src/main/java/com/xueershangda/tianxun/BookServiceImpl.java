package com.xueershangda.tianxun;

import com.vteba.tutorial.Book;
import com.vteba.tutorial.BookService;
import com.vteba.tutorial.GetBookRequest;
import com.vteba.tutorial.QueryBooksRequest;

import java.util.concurrent.CompletableFuture;

public class BookServiceImpl implements BookService {
    @Override
    public Book getBook(GetBookRequest request) {
        return Book.newBuilder()
                .setAuthor("yinlei")
                .setIsbn(123465L)
                .setTitle("好书啊").build();
    }

    @Override
    public CompletableFuture<Book> getBookAsync(GetBookRequest request) {
        return CompletableFuture.completedFuture(getBook(request));
    }

    @Override
    public Book queryBooks(QueryBooksRequest request) {
        String authorPrefix = request.getAuthorPrefix();
        if (authorPrefix != null) {
            return Book.newBuilder().setAuthor(authorPrefix).build();
        }
        return null;
    }

    @Override
    public CompletableFuture<Book> queryBooksAsync(QueryBooksRequest request) {
        return CompletableFuture.completedFuture(queryBooks(request));
    }
}
