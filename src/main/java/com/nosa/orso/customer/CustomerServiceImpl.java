package com.nosa.orso.customer;


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
    public Customer saveCustomer(Customer customer){
//       Optional<Customer> savedCustomer = customerRepository.findbyEmail(customer.getEmail());
//        if(savedCustomer.isPresent()){
//            throw new ResourceNotFoundException("Customer already exist with given email" + customer.getEmail());
//        }
        return customerRepository.save(customer);
    }
    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(String id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer updateCustomer(Customer updatedCustomer) {
        return customerRepository.save(updatedCustomer);
    }

    @Override
    public void deleteCustomer(String id) {
        customerRepository.deleteById(id);
    }


}
