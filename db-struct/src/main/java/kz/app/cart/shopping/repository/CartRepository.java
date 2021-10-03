package kz.app.cart.shopping.repository;

import com.sun.istack.NotNull;
import kz.app.cart.shopping.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    Cart getById(Long id);
}
