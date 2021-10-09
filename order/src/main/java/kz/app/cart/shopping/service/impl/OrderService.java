package kz.app.cart.shopping.service.impl;

import kz.app.cart.shopping.dto.OrderDTO;
import kz.app.cart.shopping.model.Order;
import kz.app.cart.shopping.model.OrderDetail;
import kz.app.cart.shopping.repository.OrderRepository;
import kz.app.cart.shopping.service.IOrderDetailService;
import kz.app.cart.shopping.service.IOrderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class OrderService implements IOrderService {

    private final OrderRepository orderRepository;
    protected final IOrderDetailService orderDetailService;

    @Override
    public Order save(OrderDTO orderDTO) {
        Order order;

        OrderDetail orderDetail = orderDetailService.update(orderDTO);

        if (orderDTO.getId() == null) {
            order = Order.builder()
                    .referenceNo(orderDTO.getReference_no())
                    .orderDate(orderDTO.getOrderDate())
                    .expectedDeliveryDate(orderDTO.getExpectedDeliveryDate())
                    .numberOfItems(orderDTO.getNumberOfItems())
                    .totalAmount(orderDTO.getTotalAmount())
                    .orderDetail(orderDetail)
                    .build();

        } else {
            order = getById(orderDTO.getId());

            order.setReferenceNo(orderDTO.getReference_no());
            order.setOrderDate(orderDTO.getOrderDate());
            order.setExpectedDeliveryDate(orderDTO.getExpectedDeliveryDate());
            order.setNumberOfItems(orderDTO.getNumberOfItems());
            order.setOrderDetail(orderDetail);
            order.setTotalAmount(orderDTO.getTotalAmount());
        }

        Order savedOrder = orderRepository.saveAndFlush(order);

        log.info("order saved = " + savedOrder.getId());

        return savedOrder;
    }

    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Order getById(Long id) {
        return orderRepository.getById(id);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }
}
