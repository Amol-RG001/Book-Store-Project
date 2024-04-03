package com.amol.bookstore.services;

import com.amol.bookstore.entities.Books;

import java.util.List;

public interface BookService {

   public void createBooks(Books book);

   void deleteBooks(Integer bookId);

   List<Books>getAllBooks();

   public Books getBookById(Integer bookId);

  void updateBookById(Integer id, Books b);
}
