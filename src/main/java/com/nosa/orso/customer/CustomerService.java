package com.nosa.orso.customer;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.List;
import java.util.Optional;

public interface CustomerService {
        ResponseEntity saveCustomer(Customer customer);
        List<Customer> getAllCustomers();
        Optional<Customer> getCustomerById (String id);
        ResponseEntity updateCustomer(Customer updateCustomer);
        ResponseEntity<HttpStatus> deleteCustomer(String id);

//    private final CustomerRepository customerRepository;
//
//     List<Customer> getAllCustomers() {
//        return customerRepository.findAll();
//    }
//
//    public List<Customer> save(Customer customer) {
//        return customerRepository.saveCustomer(customer);
//    }
}
