package com.bookstore.bookstore.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
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
    @Size(min = 5, message = "minimum length of book name is five")
    private String bookName;

    @NotNull(message = "Please enter book rating")
    @Positive(message = "Book rating must be positive")
    private int bookRating;

    @Column(unique = true)
    @NotEmpty(message = "Please enter book code")
    private String bookCode;

    @ManyToOne()
    @JoinColumn(name = "authorId", referencedColumnName = "authorId", nullable = false)
    @JsonBackReference
    private Author author;

}
