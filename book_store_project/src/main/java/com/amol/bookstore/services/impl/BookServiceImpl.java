package com.amol.bookstore.services.impl;

import com.amol.bookstore.entities.Books;
import com.amol.bookstore.repositories.BookRepo;
import com.amol.bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepo bookRepo;

    public void createBooks(Books b) {
        bookRepo.save(b);
    }



    @Override
    public void deleteBooks(Integer bookId) {
        bookRepo.deleteById(bookId);
    }

    @Override
    public List<Books> getAllBooks() {
        List<Books> b = bookRepo.findAll();
        return b;
    }

    @Override
    public Books getBookById(Integer bookId) {
        Books b = bookRepo.findById(bookId).get();
        return b;
    }

    @Override
    public void updateBookById(Integer id, Books book) {
        Books myBook = bookRepo.findById(id).get();
        myBook.setBookTitle(book.getBookTitle());
        myBook.setBookAuthor(book.getBookAuthor());
        myBook.setBookPages(book.getBookPages());
        myBook.setBookPrice(book.getBookPrice());
        myBook.setBookEdition(book.getBookEdition());
        myBook.setBookDescription(book.getBookDescription());
        bookRepo.save(myBook);

    }
}
