package kz.app.cart.shopping.service.impl;

import kz.app.cart.shopping.dto.CartDTO;
import kz.app.cart.shopping.model.Cart;
import kz.app.cart.shopping.model.Order;
import kz.app.cart.shopping.repository.CartRepository;
import kz.app.cart.shopping.service.ICartService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class CartService implements ICartService {

    private final CartRepository cartRepository;

    @Override
    public Cart save(CartDTO cartDTO) {
        Cart cart;

        log.info("start saving cart");

        if (cartDTO.getId() == null) {

            log.info("new cart");

            cart = Cart.builder()
                    .description(cartDTO.getDescription())
                    .status(cartDTO.getStatus())
                    .images(cartDTO.getImages())
                    .build();
        } else {
            cart = getById(cartDTO.getId());

            cart.setDescription(cartDTO.getDescription());
            cart.setStatus(cartDTO.getStatus());
            cart.setImages(cartDTO.getImages());
        }

        Cart savedCart = cartRepository.saveAndFlush(cart);
        log.info("end saving by id : " + savedCart.getId());

        return savedCart;
    }

    @Override
    public Cart updateCart(Order order, Long cartId) {

        log.info("start updating cart");

        Cart cart = getById(cartId);
        cart.setOrder(order);

        Cart savedCart = cartRepository.saveAndFlush(cart);
        log.info("end saving by id : " + savedCart.getId());

        return savedCart;
    }

    @Override
    public void deleteById(Long id) {
        cartRepository.deleteById(id);
    }

    @Override
    public Cart getById(Long id) {
        return cartRepository.getById(id);
    }

    @Override
    public List<Cart> getAll() {
        return cartRepository.findAll();
    }
}
