package com.bookstore.bookstore.service;

import com.bookstore.bookstore.entity.Book;

import java.util.List;

public interface BookService {

    Book saveDepartment(Book book);

    List<Book> getAllBook();

    Book getBookById(int bookId);

    String deleteBookById(int bookId);

    Book updateBook(int bookId, Book book);
}
