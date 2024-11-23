package com.bookstore.bookstore.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "author_tb")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int authorId;

    @NotEmpty(message = "Please enter author name")
    private String authorName;

    @NotNull
    @Max(value = 5, message = "Maximum allowed value is 5")
    @Positive(message = "Author rating must be positive")
    private int authorRating;

    @NotEmpty(message = "Please enter email")
    @Email(message = "Please enter a valid email")
    @Column(unique = true)
    private String authorEmail;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @Valid
    @JsonManagedReference
    private List<Book> books;
}
