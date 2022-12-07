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
        ResponseEntity<HttpStatus> deleteAllCustomers();
        List<Customer> getVegetarians();

        //koden nedanför tillkom efter inlämning. ville mest bara se den "in action" kod hämtad gituser Pigey och deras webservice-projekt
        ResponseEntity<Customer> updateField(String id, Map<Object, Object> updates);

}
