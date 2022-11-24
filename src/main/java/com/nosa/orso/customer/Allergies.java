package com.nosa.orso.customer;

import lombok.Data;

@Data
public class Allergies {
    private boolean glutenAllergyToF;
    private boolean lactoseAllergyToF;
    private boolean eggAllergyToF;
    private boolean nutAllergyToF;

    public Allergies(boolean glutenAllergyToF,
                     boolean lactoseAllergyToF,
                     boolean eggAllergyToF,
                     boolean nutAllergyToF) {
        this.glutenAllergyToF = glutenAllergyToF;
        this.lactoseAllergyToF = lactoseAllergyToF;
        this.eggAllergyToF = eggAllergyToF;
        this.nutAllergyToF = nutAllergyToF;
    }
}
