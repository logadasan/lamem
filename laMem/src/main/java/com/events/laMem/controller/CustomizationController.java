package com.events.laMem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.events.laMem.model.Customization;
import com.events.laMem.service.CustomizationService;

import java.util.List;

@RestController
@RequestMapping("/api/customizations")
public class CustomizationController {

    @Autowired
    private CustomizationService customizationService;

    
    @PostMapping
    public ResponseEntity<Customization> addCustomization(@RequestBody Customization customization) {
        Customization savedCustomization = customizationService.saveCustomization(customization);
        return ResponseEntity.ok(savedCustomization);
    }

    
    @GetMapping
    public ResponseEntity<List<Customization>> getAllCustomizations() {
        List<Customization> customizations = customizationService.getAllCustomizations();
        return ResponseEntity.ok(customizations);
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Customization> getCustomizationById(@PathVariable Long id) {
        return customizationService.getCustomizationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

   
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomization(@PathVariable Long id) {
        customizationService.deleteCustomization(id);
        return ResponseEntity.noContent().build();
    }
}
