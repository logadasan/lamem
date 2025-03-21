package com.events.laMem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.events.laMem.model.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
	  @Query("SELECT e FROM Event e LEFT JOIN FETCH e.customizations")
	    List<Event> findAllWithCustomizations();
}
