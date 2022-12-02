package com.nosa.orso.customer;


import com.mongodb.client.result.UpdateResult;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    public ResponseEntity <Customer> saveCustomer(Customer customer){
        Customer _customer = customerRepository.save(new Customer(
                customer.getName(),
                customer.getEmail(),
                customer.getNumberCompany(),
                customer.isVegetarians(),
                new Allergies(
                        customer.getAllergies().isGlutenAllergyToF(),
                        customer.getAllergies().isLactoseAllergyToF(),
                        customer.getAllergies().isEggAllergyToF(),
                        customer.getAllergies().isNutAllergyToF()),
                customer.getCreated()));
        return new ResponseEntity("Customer added successfully " + _customer, HttpStatus.OK);
    }
    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(String id) {
        return customerRepository.findById(id);
    }



    @Override
    public ResponseEntity <Customer> updateCustomer(String id, Customer customerDetails){
        Customer updateCustomer = customerRepository.findById(id)
                        .orElseThrow();

        updateCustomer.setName(customerDetails.getName());
        updateCustomer.setEmail(customerDetails.getEmail());
        customerRepository.save(updateCustomer);
        return ResponseEntity.ok(updateCustomer);
    }
   /* @Override
    public ResponseEntity <Customer> updateCustomer(String id, Customer customer) {
        Optional<Customer> customerData = customerRepository.findById(id);
        System.out.println("53 " + id);
        System.out.println("54 " + customer);
        System.out.println("55 " + customerData);
        System.out.println("56 " + customerRepository.findById("6389cdea04b62e247618224f"));
        if(customerData.isPresent()) {
            Customer _customer = (customerData.get());
            _customer.setName(customer.getName());
            _customer.setEmail(customer.getEmail());


            System.out.println("63 " + _customer); // Not same value as return
//            _customer.getNumberCompany(customer.getNumberCompany());
//            _customer.isVegetarians(customer.isVegetarians());
            return new ResponseEntity<>(customerRepository.save(_customer), HttpStatus.OK);
//            return new ResponseEntity<>(_customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

//        customerDetails.setName(customerDetails.getName());
//        customerDetails.setEmail(customerDetails.getEmail());
//        customerDetails.setNumberCompany(customerDetails.getNumberCompany());
//        customerDetails.setVegetarians(customerDetails.isVegetarians());
        //TODO add allergies

//        return new ResponseEntity("Customer updated successfully " + customerDetails, HttpStatus.OK);
    }*/

    @Override
    public ResponseEntity<HttpStatus> deleteCustomer(String id) {
        customerRepository.deleteById(id);
        return null;
    }


}
