package com.nosa.orso.customer;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;


    @GetMapping("/getCustomer")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }


}
