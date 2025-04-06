package com.example.vendorservice.controller;

import com.example.vendorservice.dao.entity.VendorEntity;
import com.example.vendorservice.dto.Responsedto;
import com.example.vendorservice.dto.Vendordto;
import com.example.vendorservice.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendors")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    /**
     * Add a new vendor
     */
    @PostMapping
    public ResponseEntity<VendorEntity> addVendor(@RequestBody VendorEntity vendor) {
        VendorEntity savedVendor = vendorService.addVendor(vendor);
        return ResponseEntity.ok(savedVendor);
    }

    /**
     * Get vendor details along with Trainings and Trainers
     */
    @GetMapping("/{vendorId}")
    public ResponseEntity<Responsedto> getVendor(@PathVariable Long vendorId) {
        Responsedto responseDto = vendorService.getVendor(vendorId);
        return ResponseEntity.ok(responseDto);
    }

    /**
     * Get all vendors
     */
    @GetMapping
    public ResponseEntity<List<Vendordto>> getAllVendors() {
        List<Vendordto> vendors = vendorService.getAllVendors();
        return ResponseEntity.ok(vendors);
    }

    /**
     * Find vendor by name
     */
    @GetMapping("/name/{name}")
    public ResponseEntity<Vendordto> getVendorByName(@PathVariable String name) {
        Vendordto vendor = vendorService.getVendorByName(name);
        return ResponseEntity.ok(vendor);
    }

    /**
     * Update a vendor
     */
    @PutMapping("/{vendorId}")
    public ResponseEntity<VendorEntity> updateVendor(@PathVariable Long vendorId, @RequestBody VendorEntity updatedVendor) {
        VendorEntity vendor = vendorService.updateVendor(vendorId, updatedVendor);
        return ResponseEntity.ok(vendor);
    }

    /**
     * Delete a vendor
     */
    @DeleteMapping("/{vendorId}")
    public ResponseEntity<String> deleteVendor(@PathVariable Long vendorId) {
        String message = vendorService.deleteVendor(vendorId);
        return ResponseEntity.ok(message);
    }
}
