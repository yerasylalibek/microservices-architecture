package kz.app.cart.shopping.service.impl;

import kz.app.cart.shopping.dto.CartProductDTO;
import kz.app.cart.shopping.model.CartProduct;
import kz.app.cart.shopping.repository.CartProductRepository;
import kz.app.cart.shopping.service.ICartProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class CartProductService implements ICartProductService {

    private final CartProductRepository productRepository;

    @Override
    public CartProduct save(CartProductDTO cartProductDTO) {
        CartProduct cartProduct;
        log.info("start saving cart product");

        if (cartProductDTO.getId() == null) {
            log.info("new cart product");

            cartProduct = CartProduct.builder()
                    .code(cartProductDTO.getCode())
                    .detail(cartProductDTO.getDetail())
                    .name(cartProductDTO.getName())
                    .build();

        } else {
            cartProduct = getById(cartProductDTO.getId());

            cartProduct.setCode(cartProductDTO.getCode());
            cartProduct.setDetail(cartProductDTO.getDetail());
            cartProduct.setName(cartProductDTO.getName());
        }

        CartProduct cartProductSaved = productRepository.saveAndFlush(cartProduct);

        log.info("end saving cart product by id : " + cartProductSaved.getId());

        return cartProductSaved;
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public CartProduct getById(Long id) {
        return productRepository.getById(id);
    }

    @Override
    public List<CartProduct> getAll() {
        return productRepository.findAll();
    }
}
