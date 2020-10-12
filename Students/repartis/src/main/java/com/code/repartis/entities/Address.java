package com.code.repartis.entities;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class Address {

    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;
    
}