package kz.app.cart.shopping.repository;

import kz.app.cart.shopping.model.CartProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartProductCategoryRepository extends JpaRepository<CartProductCategory, Long> {
    CartProductCategory getById(Long id);
}
