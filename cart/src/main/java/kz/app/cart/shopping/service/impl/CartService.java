package kz.app.cart.shopping.service.impl;

import kz.app.cart.shopping.dto.CartDTO;
import kz.app.cart.shopping.model.Cart;
import kz.app.cart.shopping.service.ICartService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class CartService implements ICartService {


    @Override
    public Cart save(CartDTO cartDTO) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Cart getById(Long id) {
        return null;
    }

    @Override
    public List<Cart> getAll() {
        return null;
    }
}
