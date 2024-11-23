package com.bookstore.bookstore.service;

import com.bookstore.bookstore.entity.Author;

import java.util.List;

public interface AuthorService {

    Author saveAuthor(Author author);

    List<Author> getAllAuthors();

    Author getAuthorById(int authorId);

    String deleteAuthorById(int authorId);

    Author updateAuthor(int authorId, Author author);
}
