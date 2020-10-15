package com.code.repartis.Fake;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class Companyf {
    
    private String name;
    private String catchPhrase;
    private String bs;

}
