package com.nosa.orso;

import com.nosa.orso.customer.Allergies;
import com.nosa.orso.customer.Customer;
import com.nosa.orso.customer.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class OrsoApplication {

    public static void main(String[] args) {

        SpringApplication.run(OrsoApplication.class, args);
    }
    @Bean
    CommandLineRunner runner (CustomerRepository customerRepository){
        return args -> {

            Allergies allergies = new Allergies(
                    true,
                    false,
                    false,
                    false);

            Customer customer = new Customer(
                    "Test Testsson",
                    "test@mail.com",
                    4,
                    true,
                    allergies,
                    LocalDateTime.now()
            );

            String name = "Test Testson";

            customerRepository.findCustomerByName(name)
                    .ifPresentOrElse(c -> {
                        System.out.println(c + " already exists");
                    },() ->{
                        System.out.println("Inserting customer " + customer);
                        customerRepository.insert(customer);
                    });
        };
    }
}
