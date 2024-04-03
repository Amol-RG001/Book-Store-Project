package com.amol.bookstore.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Books")
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer bookId;
    private Integer bookPages;
    private Integer bookPrice;
    private String bookTitle;
    private String bookAuthor;
    private String bookEdition;
    private String bookDescription;
}
