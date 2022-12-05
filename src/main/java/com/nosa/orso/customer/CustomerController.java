package com.nosa.orso.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerServiceImpl customerService;


    @Autowired
    public CustomerController(CustomerServiceImpl customerService) {
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

   @PutMapping("/updateCustomer/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") String id, @RequestBody Customer customer){
       System.out.println("Debugging ID " + id);
        return customerService.updateCustomer(id, customer);
    }

    @DeleteMapping("/deleteCustomer/{id}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("id") String id){
        return customerService.deleteCustomer(id);
    }

    @GetMapping("/getCustomer/{id}")
    public ResponseEntity<Customer> getCustomerById (@PathVariable(value = "id")String id){

        return customerService.getCustomerById(id);
    }

    @DeleteMapping("/deleteAllCustomers")
    public ResponseEntity<HttpStatus> deleteAllCustomers(){
        return customerService.deleteAllCustomers();
    }

}


