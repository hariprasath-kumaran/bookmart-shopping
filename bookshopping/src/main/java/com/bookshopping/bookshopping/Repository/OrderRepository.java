package com.bookshopping.bookshopping.Repository;

import com.bookshopping.bookshopping.Model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
    @Query("select o from Order o inner join o.appUser a where a.id=?1")
    Optional<Orders> findUserOrders(Long userId);
}
