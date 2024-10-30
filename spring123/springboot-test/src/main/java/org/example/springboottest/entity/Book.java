package org.example.springboottest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@Table(name = "books")
@AllArgsConstructor
@NoArgsConstructor

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length =50)
    private String book_title;

    @Column(nullable = false, length =100)
    private String book_author;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;


}
