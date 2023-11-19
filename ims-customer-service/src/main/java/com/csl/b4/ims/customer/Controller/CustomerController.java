package com.csl.b4.ims.customer.Controller;

import com.csl.b4.ims.customer.model.Customer;
import com.csl.b4.ims.customer.service.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Void> saveCustomer(@RequestBody Customer Customer){
        customerService.saveCustomer(Customer);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<?> getCustomers(@RequestParam(name = "asPage", required = false, defaultValue = "false") Boolean asPage,
                                          @RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "3") int size,
                                          @RequestParam(name = "name", required = false) String name,
                                          @RequestParam(name = "address", required = false) String address,
                                          @RequestParam(name = "phone", required = false) String phone){
        if(asPage){
            Pageable pageable = PageRequest.of(page, size);
            Page<Customer> CustomersAsPage = customerService.findAllCustomers(pageable, name, address, phone);
            return ResponseEntity.ok(CustomersAsPage);
        }
        List<Customer> CustomersAsList = customerService.findAllCustomers(name, address, phone);
        return ResponseEntity.ok(CustomersAsList);
    }
    @GetMapping("/{id}/exist")
    public ResponseEntity<Boolean> isExist(@PathVariable("id") Long id){
        boolean exist = customerService.isExist(id);
        return exist ? ResponseEntity.ok(exist) : ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findCustomer(@PathVariable("id") Long id){
        Customer customer = customerService.getCustomerById(id);
        return ResponseEntity.ok(customer);
    }
}
