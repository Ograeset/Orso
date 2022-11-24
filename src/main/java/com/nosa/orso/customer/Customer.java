package com.nosa.orso.customer;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Data
@Document
public class Customer {


    @Id
    private String id;
    private String name;
    private String email;
    private int numberCompany;
    private boolean vegetarians;
    private Allergies allergies;
    private final LocalDateTime created;

    public Customer(String name,
                    String email,
                    int numberCompany,
                    boolean vegetarians,
                    Allergies allergies, LocalDateTime created) {
        this.name = name;
        this.email = email;
        this.numberCompany = numberCompany;
        this.vegetarians = vegetarians;
        this.allergies = allergies;
        this.created = created;
    }
}
