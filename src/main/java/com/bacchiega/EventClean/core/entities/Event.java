package com.bacchiega.EventClean.core.entities;


import com.bacchiega.EventClean.core.enums.EventType;

import java.time.LocalDateTime;

public class Event{

    Long id;
    String name;
    String description;
    String identifier;
    LocalDateTime startDate;
    LocalDateTime endDate;
    String location;
    String organizer;
    Integer capacity;
    EventType type;

    public Event() {
    }

    public Event(Long id, String name, String description, String identifier, LocalDateTime startDate, LocalDateTime endDate, String location, String organizer, Integer capacity, EventType type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.identifier = identifier;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.organizer = organizer;
        this.capacity = capacity;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }


}
