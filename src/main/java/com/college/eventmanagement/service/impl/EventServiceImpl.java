package com.college.eventmanagement.service.impl;

import com.college.eventmanagement.entity.Event;
import com.college.eventmanagement.repository.EventRepository;
import com.college.eventmanagement.service.EventService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository repo;

    public EventServiceImpl(EventRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Event> getAllEvents() {
        return repo.findAll();
    }

    @Override
    public Optional<Event> getEventById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Event createEvent(Event event) {
        return repo.save(event);
    }

    @Override
    public Event updateEvent(Long id, Event updated) {
        Event existing = repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Event not found: " + id));
        existing.setTitle(updated.getTitle());
        existing.setDescription(updated.getDescription());
        existing.setDate(updated.getDate());
        existing.setLocation(updated.getLocation());
        existing.setCategory(updated.getCategory());
        existing.setMaxRegistrations(updated.getMaxRegistrations());
        return repo.save(existing);
    }

    @Override
    public void deleteEvent(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Event registerForEvent(Long id) {
        Event event = repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Event not found: " + id));
        int current = event.getRegistrations() == null ? 0 : event.getRegistrations();
        event.setRegistrations(current + 1);
        return repo.save(event);
    }

    @Override
    public List<Event> searchEvents(String keyword) {
        return repo.findByTitleContainingIgnoreCase(keyword);
    }

    @Override
    public List<Event> getEventsByCategory(String category) {
        return repo.findByCategory(category);
    }
}