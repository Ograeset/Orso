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

}
