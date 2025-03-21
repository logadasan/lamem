package com.events.laMem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.events.laMem.model.Event;
import com.events.laMem.repository.EventRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

   
    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    
    public List<Event> getAllEvents() {
        return eventRepository.findAllWithCustomizations();
    }

   
    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }

   
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}
