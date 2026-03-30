package com.college.eventmanagement.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(length = 1000)
    private String description;

    private String date;
    private String location;
    private String category;
    private Integer maxRegistrations;
    private Integer registrations = 0;

    @Column(updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    // ── Getters & Setters ──────────────────────────

    public Long getId()                        { return id; }
    public void setId(Long id)                 { this.id = id; }

    public String getTitle()                   { return title; }
    public void setTitle(String title)         { this.title = title; }

    public String getDescription()             { return description; }
    public void setDescription(String d)       { this.description = d; }

    public String getDate()                    { return date; }
    public void setDate(String date)           { this.date = date; }

    public String getLocation()                { return location; }
    public void setLocation(String location)   { this.location = location; }

    public String getCategory()                { return category; }
    public void setCategory(String category)   { this.category = category; }

    public Integer getMaxRegistrations()               { return maxRegistrations; }
    public void setMaxRegistrations(Integer max)       { this.maxRegistrations = max; }

    public Integer getRegistrations()                  { return registrations; }
    public void setRegistrations(Integer reg)          { this.registrations = reg; }

    public LocalDateTime getCreatedAt()                { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt)  { this.createdAt = createdAt; }
}