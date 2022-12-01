package com.nosa.orso.customer;


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
    public ResponseEntity <Customer> updateCustomer(Customer customerDetails) {
        customerDetails.setName(customerDetails.getName());
        customerDetails.setEmail(customerDetails.getEmail());
        customerDetails.setNumberCompany(customerDetails.getNumberCompany());
        customerDetails.setVegetarians(customerDetails.isVegetarians());
        //TODO add allergies




        return new ResponseEntity("Customer updated successfully " + customerDetails, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpStatus> deleteCustomer(String id) {
        customerRepository.deleteById(id);
        return null;
    }


}
