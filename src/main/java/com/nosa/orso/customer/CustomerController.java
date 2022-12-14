package com.nosa.orso.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/getVegetarians")
    public List<Customer> fetchVegetarians(){
        return customerService.getVegetarians();
    }

    @DeleteMapping("/deleteAllCustomers")
    public ResponseEntity<HttpStatus> deleteAllCustomers() {
        return customerService.deleteAllCustomers();
    }


    //koden nedanf??r tillkom efter inl??mning. ville mest bara se den "in action" kod h??mtad gituser Pigey och deras webservice-projekt

    @PatchMapping("/updateField/{id}")
    public ResponseEntity<Customer> updateField (@PathVariable("id") String id, @RequestBody Map<Object, Object> updates) {
        return customerService.updateField(id, updates);

    }
}



