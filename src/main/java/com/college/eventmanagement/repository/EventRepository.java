package com.college.eventmanagement.repository;

import com.college.eventmanagement.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findByCategory(String category);
    List<Event> findByTitleContainingIgnoreCase(String keyword);
}