package com.nosa.orso.customer;


import org.springframework.http.ResponseEntity;


import java.util.List;
import java.util.Optional;

public interface CustomerService {
        ResponseEntity saveCustomer(Customer customer);
        List<Customer> getAllCustomers();
        Optional<Customer> getCustomerById (String id);
        Customer updateCustomer(Customer updateCustomer);
        void deleteCustomer(String id);

//    private final CustomerRepository customerRepository;
//
//     List<Customer> getAllCustomers() {
//        return customerRepository.findAll();
//    }
//
//    public List<Customer> save(Customer customer) {
//        return customerRepository.saveCustomer(customer);
//    }
}
