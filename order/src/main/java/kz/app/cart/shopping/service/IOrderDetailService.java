package kz.app.cart.shopping.service;

import kz.app.cart.shopping.dto.OrderDTO;
import kz.app.cart.shopping.dto.OrderDetailDTO;
import kz.app.cart.shopping.model.CartProduct;
import kz.app.cart.shopping.model.OrderDetail;

import java.util.List;

public interface IOrderDetailService {

    OrderDetail save(OrderDetailDTO orderDetailDTO);
    OrderDetail update(OrderDTO orderDTO);
    void deleteById(Long id);
    OrderDetail getById(Long id);

    List<OrderDetail> getAll();

}
