package com.nosa.orso.customer;

import com.nosa.orso.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;


@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    //Dont need constuctor when lombok is in place
   /* public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }*/

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }


    public ResponseEntity<Customer> getCustomerById(String id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not exist with id: " + id));
        return ResponseEntity.ok().body(customer);
    }


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


    public ResponseEntity <Customer> updateCustomer(String id, Customer customerDetails){
        Customer updateCustomer = customerRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Customer does not exist with id: " + id));

        updateCustomer.setName(customerDetails.getName());
        updateCustomer.setEmail(customerDetails.getEmail());
        updateCustomer.setNumberCompany(customerDetails.getNumberCompany());
        updateCustomer.setVegetarians(customerDetails.isVegetarians());
        updateCustomer.setAllergies(customerDetails.getAllergies());
        customerRepository.save(updateCustomer);
        return ResponseEntity.ok(updateCustomer);
    }

    public ResponseEntity<HttpStatus> deleteCustomer(String id) {
        customerRepository.deleteById(id);
        return null;
    }
}
