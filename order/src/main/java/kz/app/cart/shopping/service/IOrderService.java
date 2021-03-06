package kz.app.cart.shopping.service;

import kz.app.cart.shopping.dto.OrderDTO;
import kz.app.cart.shopping.model.Order;

import java.util.List;

public interface IOrderService {

    Order save(OrderDTO orderDTO);
    boolean makeOrder(Long customerId, Long cartId);
    void deleteById(Long id);
    Order getById(Long id);

    List<Order> getAll();
}
