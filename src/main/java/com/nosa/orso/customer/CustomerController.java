package com.nosa.orso.customer;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private final CustomerService customerService;


    @GetMapping("/testing")
    public String testing() {
        return "Hello World";
    }

    @GetMapping("/getAllCustomers")
    public List<Customer> fetchAllCustomers(){
        return customerService.getAllCustomers();
    }

    @PostMapping("/saveCustomer")
    public ResponseEntity<Customer> save(@RequestBody Customer customer) {
        customerService.save(new Customer(
                        customer.getName(),
                        customer.getEmail(),
                        customer.getNumberCompany(),
                        customer.isVegetarians(),
                        new Allergies(customer.getAllergies().isGlutenAllergyToF(),
                            customer.getAllergies().isLactoseAllergyToF(),
                            customer.getAllergies().isEggAllergyToF(),
                            customer.getAllergies().isNutAllergyToF()),
                        customer.getCreated()));
        return new ResponseEntity("Customer added successfully " + customer, HttpStatus.OK);
    }
}


