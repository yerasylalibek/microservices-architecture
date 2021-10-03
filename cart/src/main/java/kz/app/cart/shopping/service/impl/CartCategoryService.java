package kz.app.cart.shopping.service.impl;

import kz.app.cart.shopping.dto.CartCategoryDTO;
import kz.app.cart.shopping.model.CartCategory;
import kz.app.cart.shopping.service.ICartCategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CartCategoryService implements ICartCategoryService {
    @Override
    public CartCategory save(CartCategoryDTO cartCategoryDTO) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public CartCategory getById(Long id) {
        return null;
    }

    @Override
    public List<CartCategory> getAll() {
        return null;
    }
}
