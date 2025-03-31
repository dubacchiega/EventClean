package com.bacchiega.EventClean.infrastructure.dto;

import com.bacchiega.EventClean.core.enums.EventType;

import java.time.LocalDateTime;

public record EventDto(
        Long id,
        String name,
        String description,
        String identifier,
        LocalDateTime startDate,
        LocalDateTime endDate,
        String location,
        String organizer,
        Integer capacity,
        EventType type
) {}
