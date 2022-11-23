package com.nosa.orso.customer;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


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

    public Customer(String name,
                    String email,
                    int numberCompany,
                    boolean vegetarians,
                    Allergies allergies) {
        this.name = name;
        this.email = email;
        this.numberCompany = numberCompany;
        this.vegetarians = vegetarians;
        this.allergies = allergies;
    }
}
