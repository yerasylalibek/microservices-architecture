package kz.app.cart.shopping.service.impl;

import kz.app.cart.shopping.dto.CartProductCategoryDTO;
import kz.app.cart.shopping.model.CartProductCategory;
import kz.app.cart.shopping.service.ICartProductCategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class CartProductCategoryService implements ICartProductCategoryService {
    @Override
    public CartProductCategory save(CartProductCategoryDTO cartProductCategoryDTO) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public CartProductCategory getById(Long id) {
        return null;
    }

    @Override
    public List<CartProductCategory> getAll() {
        return null;
    }
}
