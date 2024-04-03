package com.amol.bookstore.repositories;

import com.amol.bookstore.entities.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Books, Integer> {

}
