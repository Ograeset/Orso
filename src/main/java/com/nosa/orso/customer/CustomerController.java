package com.nosa.orso.customer;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

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

   @PutMapping("/updateCustomer/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable String id, @RequestBody Customer customer){
       Optional<Customer> customerData = customerService.getCustomerById(id);

       if(customerData.isPresent()) {
           Customer _customer = customerData.get();
           _customer.setName(customer.getName());
           _customer.setEmail(customer.getEmail());
//           _customer.getNumberCompany(customer.getNumberCompany());
//           _customer.isVegetarians(customer.isVegetarians());
           return new ResponseEntity(customerService.updateCustomer(_customer), HttpStatus.OK);
       } else {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }

//        return customerService.updateCustomer(customer);
    }

    @DeleteMapping("/deleteCustomer/{id}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("id") String id){
        return customerService.deleteCustomer(id);
    }

}


