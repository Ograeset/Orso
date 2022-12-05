package com.nosa.orso.customer;


import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.List;


public interface CustomerService {
        ResponseEntity saveCustomer(Customer customer);
        List<Customer> getAllCustomers();
        ResponseEntity<Customer> getCustomerById (String id);
        ResponseEntity <Customer> updateCustomer(String id, Customer customer);
        ResponseEntity<HttpStatus> deleteCustomer(String id);
        ResponseEntity<HttpStatus> deleteAllCustomers();
        List<Customer> getVegetarians();

}
