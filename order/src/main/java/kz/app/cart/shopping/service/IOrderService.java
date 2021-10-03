package kz.app.cart.shopping.service;

import kz.app.cart.shopping.dto.OrderDTO;
import kz.app.cart.shopping.model.Cart;
import kz.app.cart.shopping.model.Order;

import java.util.List;

public interface IOrderService {

    Order save(OrderDTO cartDTO);
    void deleteById(Long id);
    Order getById(Long id);

    List<Order> getAll();
}
