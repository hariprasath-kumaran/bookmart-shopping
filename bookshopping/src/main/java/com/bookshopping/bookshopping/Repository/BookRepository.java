package com.bookshopping.bookshopping.Repository;

import com.bookshopping.bookshopping.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
