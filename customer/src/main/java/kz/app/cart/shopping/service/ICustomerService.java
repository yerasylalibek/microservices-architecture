package kz.app.cart.shopping.service;

import kz.app.cart.shopping.dto.CustomerDTO;
import kz.app.cart.shopping.model.Customer;
 
 public interface ICustomerService {

     Customer save(CustomerDTO customerDTO);
     Customer getById(Long id);
}
