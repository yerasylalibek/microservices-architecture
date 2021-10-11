package kz.app.cart.shopping.service.impl;

import kz.app.cart.shopping.dto.OrderDTO;
import kz.app.cart.shopping.model.Cart;
import kz.app.cart.shopping.model.Customer;
import kz.app.cart.shopping.model.Order;
import kz.app.cart.shopping.model.OrderDetail;
import kz.app.cart.shopping.repository.OrderRepository;
import kz.app.cart.shopping.service.IOrderDetailService;
import kz.app.cart.shopping.service.IOrderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class OrderService implements IOrderService {

    private final OrderRepository orderRepository;
    protected final IOrderDetailService orderDetailService;

    @Value("${service.customer.url}")
    String customerApi;

    @Value("${service.cart.url}")
    String cartApi;

    private Object runGetMethod(String url, Object object) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        HttpEntity entity = new HttpEntity(headers);
        try {
            HttpEntity<?> responseEntity = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    object.getClass());
            return responseEntity.getBody();
        } catch (Exception e) {
            System.out.println("Exception in GET method : " + e.getLocalizedMessage());
            return null;
        }
    }

    private Object runPostMethod(String url, Object body, Object object) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        HttpEntity entity = new HttpEntity(body, headers);
        try {
            HttpEntity<?> responseEntity = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    entity,
                    object.getClass());
            return responseEntity.getBody();
        } catch (Exception e) {
            System.out.println("Exception in POST method : " + e.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public Order save(OrderDTO orderDTO) {
        Order order;

        OrderDetail orderDetail = orderDetailService.update(orderDTO);
        Customer customer = (Customer) runGetMethod(customerApi + orderDTO.getCustomerId(), new Customer());

        List<Long> cartIds = orderDTO.getCartId();

        if (orderDTO.getId() == null) {
            order = Order.builder()
                    .referenceNo(orderDTO.getReference_no())
                    .orderDate(orderDTO.getOrderDate())
                    .expectedDeliveryDate(orderDTO.getExpectedDeliveryDate())
                    .numberOfItems(orderDTO.getNumberOfItems())
                    .totalAmount(orderDTO.getTotalAmount())
                    .orderDetail(orderDetail)
                    .customer(customer)
                    .build();

        } else {
            order = getById(orderDTO.getId());

            order.setReferenceNo(orderDTO.getReference_no());
            order.setOrderDate(orderDTO.getOrderDate());
            order.setExpectedDeliveryDate(orderDTO.getExpectedDeliveryDate());
            order.setNumberOfItems(orderDTO.getNumberOfItems());
            order.setOrderDetail(orderDetail);
            order.setCustomer(customer);
            order.setTotalAmount(orderDTO.getTotalAmount());
        }

        Order savedOrder = orderRepository.saveAndFlush(order);

        log.info("order saved = " + savedOrder.getId());

        return savedOrder;
    }

    @Override
    public boolean makeOrder(Long customerId, Long cartId) {

        return true;
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
