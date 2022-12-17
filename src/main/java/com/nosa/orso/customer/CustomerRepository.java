package com.nosa.orso.customer;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends MongoRepository <Customer, String>{
    Optional<Object> findCustomerByName(String name);
}
