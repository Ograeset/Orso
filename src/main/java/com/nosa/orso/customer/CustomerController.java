package com.nosa.orso.customer;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/testing")
    public String testing() {
        return "Hello World";
    }

    @GetMapping("/getAllCustomers")
    public List<Customer> fetchAllCustomers(){
        return customerService.getAllCustomers();
    }

    @PostMapping("/saveCustomer")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

   @PutMapping("/updateCustomer")
    public ResponseEntity <Customer>  updateCustomer(/*@PathVariable String id,*/ @RequestBody Customer customer){

        return customerService.updateCustomer(customer);


    }

}


