package kz.app.cart.shopping.controller;

import kz.app.cart.shopping.dto.OrderDetailDTO;
import kz.app.cart.shopping.model.OrderDetail;
import kz.app.cart.shopping.service.IOrderDetailService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/detail")
public class OrderDetailController {

    private final IOrderDetailService orderDetailService;

    @PostMapping
    public ResponseEntity<OrderDetail> create(@RequestBody OrderDetailDTO orderDetailDTO) {
        return ResponseEntity.ok(orderDetailService.save(orderDetailDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDetail> getById(@PathVariable Long id){
        return ResponseEntity.ok(orderDetailService.getById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        orderDetailService.deleteById(id);
    }

    @GetMapping
    public ResponseEntity<List<OrderDetail>> getAll() {
        return ResponseEntity.ok(orderDetailService.getAll());
    }
}
