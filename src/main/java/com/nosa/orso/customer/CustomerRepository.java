package com.nosa.orso.customer;

import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends MongoRepository <Customer, String>{
    Optional<Object> findCustomerByName(String name);

//    Optional<Customer> getCustomerById(String id);

//    Optional<Customer> findCustomerByName(String name);
//
//    List<Customer> saveCustomer(Customer customer);
}
