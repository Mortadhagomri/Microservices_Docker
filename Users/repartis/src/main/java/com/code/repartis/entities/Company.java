package com.code.repartis.entities;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class Company {
    
    private String name;
    private String catchPhrase;
    private String bs;

}