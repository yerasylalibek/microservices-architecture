package kz.app.cart.shopping.service.impl;

import kz.app.cart.shopping.dto.OrderDTO;
import kz.app.cart.shopping.dto.OrderDetailDTO;
import kz.app.cart.shopping.model.Order;
import kz.app.cart.shopping.model.OrderDetail;
import kz.app.cart.shopping.repository.OrderDetailRepository;
import kz.app.cart.shopping.service.IOrderDetailService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class OrderDetailService implements IOrderDetailService {

    private final OrderDetailRepository orderDetailRepository;

    @Override
    public OrderDetail save(OrderDetailDTO orderDetailDTO) {
        return null;
    }

    @Override
    public OrderDetail update(OrderDTO orderDTO) {
        OrderDetailDTO orderDetailDTO = orderDTO.getOrderDetailDTO();

        OrderDetail orderDetail;

        if (orderDetailDTO != null) {
            if (orderDetailDTO.getId() == null) {
                log.info("new order detail entity");
                orderDetail = OrderDetail.builder()
                        .quantity(orderDetailDTO.getQuantity())
                        .quantityPrice(orderDetailDTO.getQuantityPrice())
                        .status(orderDetailDTO.getStatus())
                        .remarks(orderDetailDTO.getRemarks())
                        .build();
            } else {
                log.info("not null");
                orderDetail = getById(orderDetailDTO.getId());

                orderDetail.setQuantity(orderDetailDTO.getQuantity());
                orderDetail.setQuantityPrice(orderDetailDTO.getQuantityPrice());
                orderDetail.setStatus(orderDetailDTO.getStatus());
                orderDetail.setRemarks(orderDetailDTO.getRemarks());
            }
        } else {
            orderDetail = OrderDetail.builder().build();
            log.info("orderDetailDTO is null");
        }

        OrderDetail savedOrderDetail = orderDetailRepository.saveAndFlush(orderDetail);

        log.info("Order detail saved " + savedOrderDetail.getId());

        return savedOrderDetail;
    }

    @Override
    public void deleteById(Long id) {
        orderDetailRepository.deleteById(id);
    }

    @Override
    public OrderDetail getById(Long id) {
        return orderDetailRepository.getById(id);
    }

    @Override
    public List<OrderDetail> getAll() {
        return orderDetailRepository.findAll();
    }
}
