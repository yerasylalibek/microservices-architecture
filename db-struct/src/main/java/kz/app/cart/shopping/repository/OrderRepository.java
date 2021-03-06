package kz.app.cart.shopping.repository;

import kz.app.cart.shopping.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Order getById(Long id);
}
