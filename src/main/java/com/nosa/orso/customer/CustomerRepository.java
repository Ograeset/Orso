package com.nosa.orso.customer;

import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.data.mongodb.core.query.Criteria;
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

//    List<Customer> getVegetarians() {
//        Query query = new Query();
//        query.addCriteria(Criteria.where("vegetarians").is(true));
//
//        return new List<Customer>() {
//        }
//    }


//    Optional<Customer> getCustomerById(String id);

//    Optional<Customer> findCustomerByName(String name);
//
//    List<Customer> saveCustomer(Customer customer);
}
