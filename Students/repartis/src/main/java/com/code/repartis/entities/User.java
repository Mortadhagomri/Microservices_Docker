package com.code.repartis.entities;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

//import com.code.repartis.Fake.Addressf;
//import com.code.repartis.Fake.Companyf;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USER_TBL")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "name is required")
    @Column(name = "nameU")
    private String name;

    @NotBlank(message = "Username is required")
    private String username;

    @Email
    @NotEmpty(message = "Email is required")
    private String email;
    
    @NotBlank(message = "Address is required")
    @Embedded
    private Address address;
 
    @NotBlank(message = "Phone is required")
    private String phone;
    
    @NotBlank(message = "Website is required")
    private String website;

    @NotBlank(message = "Company is required")
    @Embedded
    private Company company;

    /*
    public void setAddress(Addressf adr){
        this.address.setStreet(adr.getStreet());
        this.address.setSuite(adr.getSuite());
        this.address.setCity(adr.getCity());
        this.address.setZipcode(adr.getZipcode());
        this.address.setGeo(adr.getGeo());
    }

    public void setCompany(Companyf comp){
        this.company.setCatchPhrase(comp.getCatchPhrase());
        this.company.setNamec(comp.getName());
        this.company.setBs(comp.getBs());
    }
    */

}
