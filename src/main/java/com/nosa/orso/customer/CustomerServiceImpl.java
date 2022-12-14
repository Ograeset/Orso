package com.nosa.orso.customer;

import com.nosa.orso.exception.ResourceNotFoundException;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;


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
    public ResponseEntity<Customer> getCustomerById(String id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not exist with id: " + id));
        return ResponseEntity.ok().body(customer);
    }

    @Override
    public List <Customer> getVegetarians(){
        Query query = new Query();
        query.addCriteria(Criteria.where("vegetarians").is(true));
        return customerRepository.getVegetarians(query);
    }

    @Override
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

    @Override
    public ResponseEntity<HttpStatus> deleteCustomer(String id) {
        customerRepository.deleteById(id);
        return null;
    }


    @Override
    public ResponseEntity<HttpStatus> deleteAllCustomers() {
        customerRepository.deleteAll();
        return null;
    }


    //koden nedanf??r tillkom efter inl??mning. ville mest bara se den "in action" kod h??mtad gituser Pigey och deras webservice-projekt

    @Override
    public ResponseEntity<Customer> updateField(String id, Map<Object, Object> updates) {

        try {
            Customer updateCustomerField = customerRepository.findById(id).get();

            updates.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(Customer.class, (String) key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, updateCustomerField, value);
            });
            customerRepository.save(updateCustomerField);

            return new ResponseEntity<>(updateCustomerField, HttpStatus.OK);
        }catch (Exception e ) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
}
}
