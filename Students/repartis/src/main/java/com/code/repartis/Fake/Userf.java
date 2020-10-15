package com.code.repartis.Fake;

import lombok.Data;

@Data
public class Userf {

    private Long id;
    private String name;
    private String username;
    private String email;
    private Addressf address;
    private String phone;
    private String website;
    private Companyf company;

}
