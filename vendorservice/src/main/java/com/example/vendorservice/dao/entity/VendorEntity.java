package com.example.vendorservice.dao.entity;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data

public class VendorEntity {
    @Id
    public Long id;
    public String name;
    public String contactno;
    public String website;
    public String email;
    public String GSTpin;
    public String CIN;
    public String headOffice;
    @ElementCollection
    public List<ContactPerson> poc;

    public VendorEntity(Long id, String name, String contactno, String website, String email, String GSTpin, String CIN, String headOffice, List<ContactPerson> poc) {
        this.id = id;
        this.name = name;
        this.contactno = contactno;
        this.website = website;
        this.email = email;
        this.GSTpin = GSTpin;
        this.CIN = CIN;
        this.headOffice = headOffice;
        this.poc = poc;
    }

    public VendorEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGSTpin() {
        return GSTpin;
    }

    public void setGSTpin(String GSTpin) {
        this.GSTpin = GSTpin;
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    public String getHeadOffice() {
        return headOffice;
    }

    public void setHeadOffice(String headOffice) {
        this.headOffice = headOffice;
    }

    public List<ContactPerson> getPoc() {
        return poc;
    }

    public void setPoc(List<ContactPerson> poc) {
        this.poc = poc;
    }
}
