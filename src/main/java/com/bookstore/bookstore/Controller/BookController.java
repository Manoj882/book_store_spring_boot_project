package com.bookstore.bookstore.Controller;

import com.bookstore.bookstore.entity.Book;
import com.bookstore.bookstore.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping()
    public ResponseEntity<?> saveDepartment(@Valid @RequestBody Book book){
        Book response = bookService.saveDepartment(book);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @GetMapping()
    public  ResponseEntity<?> getAllBooks(){
        List<Book> books = bookService.getAllBook();
        return new ResponseEntity<>(books, HttpStatus.OK);

    }

    @GetMapping("/{bookId}")
    public ResponseEntity<?> getBookById(@PathVariable int bookId){
        Book book = bookService.getBookById(bookId);

        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @DeleteMapping("/{bookId}")
    public  ResponseEntity<?> deleteBooById(@PathVariable int bookId){
        String response = bookService.deleteBookById(bookId);
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{bookId}")
    public  ResponseEntity<?> updateBook(@PathVariable int bookId, @RequestBody Book book){
        Book updateBook = bookService.updateBook(bookId, book);
        return new ResponseEntity<>(updateBook, HttpStatus.OK);
    }

}
