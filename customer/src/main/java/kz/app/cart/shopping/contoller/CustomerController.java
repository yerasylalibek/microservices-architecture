 package kz.app.cart.shopping.contoller;
 import kz.app.cart.shopping.dto.CustomerDTO;
 import kz.app.cart.shopping.model.Customer;
 import kz.app.cart.shopping.service.ICustomerService;
 import lombok.AllArgsConstructor;
 import lombok.extern.slf4j.Slf4j;
 import org.springframework.http.ResponseEntity;
 import org.springframework.web.bind.annotation.*;
 import java.util.List;

 @RestController
 @Slf4j
 @AllArgsConstructor
 public class CustomerController {
       @Autowired
    private ItemService itemService;
     private final ICustomerService customerService;
 
     @PostMapping
     public ResponseEntity<Customer> save(@RequestBody CustomerDTO customerDTO) {
         log.info("customerDTO : " + customerDTO.toString());
         return ResponseEntity.ok(customerService.save(customerDTO));
     }
 
     @RequestMapping(method = RequestMethod.POST, value = "/test")
     public ResponseEntity<?> update(@RequestBody CustomerDTO customerDTO) {
         log.info("here");
         return ResponseEntity.ok(customerService.save(customerDTO));
     }
 
     @GetMapping("/{id}")
     public ResponseEntity<Customer> getById(@PathVariable Long id){
         return ResponseEntity.ok(customerService.getById(id));
     }
  
     @PostMapping(value = "/deleteitem")
    public String deleteItem(@RequestParam(name = "id", defaultValue = "0") Long id){
        ShopItems item = itemService.getItem(id);
        if(item!=null){

            itemService.deleteItem(item);
        }
        return "redirect:/";
    }

     @GetMapping
     public ResponseEntity<List<Customer>> getAll() {
         return ResponseEntity.ok(customerService.getAll());
     }

 }
