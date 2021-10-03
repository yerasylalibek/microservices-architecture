package kz.app.cart.shopping.repositories;

import kz.app.cart.shopping.model.CartProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartProductCategoryRepository extends JpaRepository<CartProductCategory, Long> {
    Optional<CartProductCategory> findById(Long id);
}
