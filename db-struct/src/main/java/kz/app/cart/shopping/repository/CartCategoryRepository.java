package kz.app.cart.shopping.repository;

import kz.app.cart.shopping.model.CartCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartCategoryRepository extends JpaRepository<CartCategory, Long> {
    CartCategory getById(Long id);
}
