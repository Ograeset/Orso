package com.nosa.orso.customer;


import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerRepository extends MongoRepository <Customer, String>{

    Optional<Customer> findCustomerByName(String name);

    public void save(Customer customer) {
    }



}
