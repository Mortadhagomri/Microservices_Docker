package com.code.repartis.Fake;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Addressf {
    
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geof geo;

}
