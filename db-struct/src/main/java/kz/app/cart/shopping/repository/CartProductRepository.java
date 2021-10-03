package kz.app.cart.shopping.repository;

import kz.app.cart.shopping.model.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartProductRepository extends JpaRepository<CartProduct, Long> {
    CartProduct getById(Long id);
}
