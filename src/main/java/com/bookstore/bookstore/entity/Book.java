package com.bookstore.bookstore.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "book_tb")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookId;
    @NotEmpty(message = "Please enter book name")
    private String bookName;
    @NotEmpty(message = "Please enter book rating")
    @Positive(message = "Book rating must be positive")
    private String bookRating;
    @Column(unique = true)
    @NotEmpty(message = "Please enter book code")
    private String bookCode;

}
