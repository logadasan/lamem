package com.events.laMem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.events.laMem.model.Customer;
import com.events.laMem.model.Event;
import com.events.laMem.repository.CustomerRepository;
import com.events.laMem.service.EventService;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;
    @Autowired
    private CustomerRepository customerRepository; 
    
    @PostMapping
    public ResponseEntity<Event> addEvent(@RequestBody Event event) {
        if (event.getCustomer() != null && event.getCustomer().getId() != null) {
            Customer customer = customerRepository.findById(event.getCustomer().getId())
                                                  .orElse(null);
            event.setCustomer(customer); // Link existing customer
        }

        Event savedEvent = eventService.saveEvent(event);
        return ResponseEntity.ok(savedEvent);
    }

    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = eventService.getAllEvents();
        for (Event e : events) {
            System.out.println("Event: " + e.getEventType() + ", Customizations: " + e.getCustomizations());
        }
        return ResponseEntity.ok(events);
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        return eventService.getEventById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }
}
