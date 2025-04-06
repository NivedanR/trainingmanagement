package com.example.vendorservice.dao.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactPerson {

    public String name;
    public String designation;
    public String email;
    public String phoneNo;

    public ContactPerson(String designation, String name, String email, String phoneNo) {
        this.designation = designation;
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
    }

    public ContactPerson() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
