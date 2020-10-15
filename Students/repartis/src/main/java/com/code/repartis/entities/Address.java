package com.code.repartis.entities;

import javax.persistence.Embeddable;

//import com.code.repartis.Fake.Geof;

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

/*
    public void setGeo(Geof g){
        this.geo.setLat(g.getLat());
        this.geo.setLng(g.getLng());
    }
*/

}