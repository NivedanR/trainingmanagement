package com.example.vendorservice.dao;

import com.example.vendorservice.dao.entity.VendorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VendorRepo extends JpaRepository<VendorEntity, Long> {

    // Find vendor by name
    Optional<VendorEntity> findByName(String name);

}
