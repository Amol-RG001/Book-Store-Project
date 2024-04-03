package com.amol.bookstore.controllers;

import com.amol.bookstore.entities.Books;
import com.amol.bookstore.repositories.BookRepo;
import com.amol.bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BookController {

    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private BookService bookService; // createBooks, deleteBooks -business logic

    @PostMapping("/books")
    public ResponseEntity<?>createdBook(@RequestBody Books b){
        bookService.createBooks(b);
        return new ResponseEntity<>(b, HttpStatus.CREATED);
    }

    @GetMapping("/books")
    public ResponseEntity<?> fetchAllBooks(){
        List<Books> books = bookService.getAllBooks();
        return new ResponseEntity<>(books,HttpStatus.OK);
    }

    @GetMapping("/books/{bookId}")
    public ResponseEntity<?> fetchBookById(@PathVariable("bookId") Integer bookId){
        try{
            Books b = bookService.getBookById(bookId);
            return new ResponseEntity<>(b,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<?> removeBookById(@PathVariable("bookId") Integer bookId){
       try{
           bookService.deleteBooks(bookId);
           return new  ResponseEntity<> ("Book remove with id "+bookId, HttpStatus.OK);
       }
       catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<?>upToDateBookById(@PathVariable("id") Integer id, @RequestBody Books myBook){
        try{
            bookService.updateBookById(id, myBook);
            return new ResponseEntity<>("Book updated with id "+id, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
