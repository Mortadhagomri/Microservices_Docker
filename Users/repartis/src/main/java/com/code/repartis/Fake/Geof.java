package com.code.repartis.Fake;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Geof {

    private String lat;
    private String lng;
    
}
