package com.bacchiega.EventClean.infrastructure.persistence;

import com.bacchiega.EventClean.core.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventRepository extends JpaRepository<EventEntity, Long> {
    // funcionaria, porém não é muito usual
    Optional<EventEntity> findByIdentifier(String identifier);
}
