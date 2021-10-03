package kz.app.cart.shopping.service;

import kz.app.cart.shopping.dto.CartDTO;
import kz.app.cart.shopping.model.Cart;

import java.util.List;

public interface ICartService {

    Cart save(CartDTO cartDTO);
    void deleteById(Long id);
    Cart getById(Long id);

    List<Cart> getAll();
}
