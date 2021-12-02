package kz.app.cart.shopping.service;

import kz.app.cart.shopping.dto.InventoryDTO;
import kz.app.cart.shopping.model.InventoryItem;
import kz.app.cart.shopping.model.Order;

import java.util.List;

public interface InventoryServiceI {

    InventoryItem save(InventoryDTO inventoryDTO);
    void deleteById(Long id);
    InventoryItem getById(Long id);

    List<InventoryItem> getAll();
}
