package com.bookstore.bookstore.service.impl;

import com.bookstore.bookstore.entity.Book;
import com.bookstore.bookstore.exception.BookNotFoundException;
import com.bookstore.bookstore.repository.BookRepository;
import com.bookstore.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book saveDepartment(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(int bookId) {

//        Optional<Book> book = bookRepository.findById(bookId);
//        if(book.isPresent()){
//            return book.get();
//        }
//        throw new BookNotFoundException("Book Id " + bookId + " is not found");

        return this.bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException("Book id "+ bookId + " is not found"));
    }

    @Override
    public String deleteBookById(int bookId) {
//        bookRepository.deleteById(bookId);
//        return "Book id " + bookId + " is deleted..";

        Optional<Book> book = this.bookRepository.findById(bookId);
        if(book.isPresent()){
            this.bookRepository.deleteById(bookId);
            return "Book Id " + bookId + " is deleted...";
        }
        throw new BookNotFoundException("Book Id " + bookId + " is not found");
    }

    @Override
    public Book updateBook(int bookId, Book book) {


        Optional<Book> optionalBook = this.bookRepository.findById(bookId);

        if(optionalBook.isPresent()){
            Book savedBook = bookRepository.findById(bookId).get();
            savedBook.setBookName(book.getBookName());
            savedBook.setBookRating(book.getBookRating());
            savedBook.setBookCode(book.getBookCode());

            return bookRepository.save(savedBook);
        }

        throw new BookNotFoundException("Book id "+ bookId + " is not found");

    }
}
