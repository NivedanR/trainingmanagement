package com.example.vendorservice.service;

import com.example.vendorservice.dao.VendorRepo;
import com.example.vendorservice.dao.entity.VendorEntity;
import com.example.vendorservice.dto.Responsedto;
import com.example.vendorservice.dto.Trainerdto;
import com.example.vendorservice.dto.Trainingdto;
import com.example.vendorservice.dto.Vendordto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VendorService {

    @Autowired
    private VendorRepo vendorRepo;

    @Autowired
    private WebClient.Builder webClientBuilder;

    /**
     * Add a new vendor
     */
    public VendorEntity addVendor(VendorEntity vendor) {
        return vendorRepo.save(vendor);
    }

    /**
     * Fetch Vendor Details along with associated Trainings and Trainers.
     */
    public Responsedto getVendor(Long vendorId) {
        Responsedto responseDto = new Responsedto();

        // Fetch Vendor from DB
        VendorEntity vendor = vendorRepo.findById(vendorId)
                .orElseThrow(() -> new RuntimeException("Vendor not found with ID: " + vendorId));

        // Convert VendorEntity to DTO
        Vendordto vendordto = mapToVendorDto(vendor);

        // Fetch Trainings associated with the Vendor from Training Service
        List<Trainingdto> trainingList = webClientBuilder.baseUrl("http://localhost:9092")
                .build()
                .get()
                .uri("/trainings/vendor/" + vendorId)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Trainingdto>>() {})
                .block();

        // Fetch Trainers associated with each Training
        for (Trainingdto training : trainingList) {
            List<Trainerdto> trainers = webClientBuilder.baseUrl("http://localhost:9099")
                    .build()
                    .get()
                    .uri("/trainers/training/" + training.getTrainingId()) // Assuming this endpoint exists
                    .retrieve()
                    .bodyToMono(new ParameterizedTypeReference<List<Trainerdto>>() {})
                    .block();

            training.setTrainers(trainers); // Assuming Trainingdto has a List<Trainerdto> trainers field
        }

        responseDto.setVendordto(vendordto);
        responseDto.setTrainingdto(trainingList);

        return responseDto;
    }

    /**
     * Fetch all vendors
     */
    public List<Vendordto> getAllVendors() {
        List<VendorEntity> vendors = vendorRepo.findAll();
        return vendors.stream().map(this::mapToVendorDto).collect(Collectors.toList());
    }

    /**
     * Find vendor by name
     */
    public Vendordto getVendorByName(String name) {
        VendorEntity vendor = vendorRepo.findByName(name)
                .orElseThrow(() -> new RuntimeException("Vendor not found with name: " + name));
        return mapToVendorDto(vendor);
    }

    /**
     * Update an existing vendor
     */
    public VendorEntity updateVendor(Long vendorId, VendorEntity updatedVendor) {
        VendorEntity existingVendor = vendorRepo.findById(vendorId)
                .orElseThrow(() -> new RuntimeException("Vendor not found with ID: " + vendorId));

        existingVendor.setName(updatedVendor.getName());
        existingVendor.setContactno(updatedVendor.getContactno());
        existingVendor.setWebsite(updatedVendor.getWebsite());
        existingVendor.setEmail(updatedVendor.getEmail());
        existingVendor.setGSTpin(updatedVendor.getGSTpin());
        existingVendor.setCIN(updatedVendor.getCIN());
        existingVendor.setHeadOffice(updatedVendor.getHeadOffice());
        existingVendor.setPoc(updatedVendor.getPoc());

        return vendorRepo.save(existingVendor);
    }

    /**
     * Delete a vendor
     */
    public String deleteVendor(Long vendorId) {
        VendorEntity vendor = vendorRepo.findById(vendorId)
                .orElseThrow(() -> new RuntimeException("Vendor not found with ID: " + vendorId));
        vendorRepo.delete(vendor);
        return "Vendor with ID " + vendorId + " deleted successfully!";
    }

    /**
     * Convert VendorEntity to Vendordto
     */
    public Vendordto mapToVendorDto(VendorEntity vendor) {
        return new Vendordto(
                vendor.getId(),
                vendor.getName(),
                vendor.getContactno(),
                vendor.getWebsite(),
                vendor.getEmail(),
                vendor.getGSTpin(),
                vendor.getCIN(),
                vendor.getHeadOffice(),
                vendor.getPoc()
        );
    }
}
