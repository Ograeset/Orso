package com.nosa.orso.customer;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends MongoRepository <Customer, String>{
    Optional<Object> findCustomerByName(String name);

    @org.springframework.data.mongodb.repository.Query("{'vegetarians':  true}")
    List<Customer> getVegetarians(Query query);
}
