package com.bookshopping.bookshopping.Repository;

import com.bookshopping.bookshopping.Model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {

    Optional<List<Cart>> findUserCart(Long userId);
}
