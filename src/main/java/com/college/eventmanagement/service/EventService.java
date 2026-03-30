package com.college.eventmanagement.service;

import com.college.eventmanagement.entity.Event;
import java.util.List;
import java.util.Optional;

public interface EventService {

    List<Event> getAllEvents();
    Optional<Event> getEventById(Long id);
    Event createEvent(Event event);
    Event updateEvent(Long id, Event updated);
    void deleteEvent(Long id);
    Event registerForEvent(Long id);
    List<Event> searchEvents(String keyword);
    List<Event> getEventsByCategory(String category);
}