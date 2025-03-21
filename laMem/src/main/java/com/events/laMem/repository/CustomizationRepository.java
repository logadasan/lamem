package com.events.laMem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.events.laMem.model.Customization;

public interface CustomizationRepository extends JpaRepository<Customization, Long> {
}
