package com.bacchiega.EventClean.core.gateway;

import com.bacchiega.EventClean.core.entities.Event;

import java.util.List;
import java.util.Optional;

public interface EventGateway {

    // no gateway, ele vai procurar uma implementação
    Event createEvent(Event event);
    List<Event> findAllEvents();
    boolean existsIdentifier(String identifier);
    Optional<Event> findByIdentifier(String identifier);
}
