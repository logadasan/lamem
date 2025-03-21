package com.events.laMem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.events.laMem.model.Customization;
import com.events.laMem.repository.CustomizationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomizationService {

    @Autowired
    private CustomizationRepository customizationRepository;

    
    public Customization saveCustomization(Customization customization) {
        return customizationRepository.save(customization);
    }

   
    public List<Customization> getAllCustomizations() {
        return customizationRepository.findAll();
    }

    
    public Optional<Customization> getCustomizationById(Long id) {
        return customizationRepository.findById(id);
    }


    public void deleteCustomization(Long id) {
        customizationRepository.deleteById(id);
    }
}
