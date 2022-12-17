package com.nosa.orso.customer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.List;
import java.util.Map;


public interface CustomerService {
        ResponseEntity saveCustomer(Customer customer);
        List<Customer> getAllCustomers();
        ResponseEntity<Customer> getCustomerById (String id);
        ResponseEntity <Customer> updateCustomer(String id, Customer customer);
        ResponseEntity<HttpStatus> deleteCustomer(String id);

}
