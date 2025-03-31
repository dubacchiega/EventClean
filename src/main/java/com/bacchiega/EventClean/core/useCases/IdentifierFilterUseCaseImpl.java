package com.bacchiega.EventClean.core.useCases;

import com.bacchiega.EventClean.core.entities.Event;
import com.bacchiega.EventClean.core.gateway.EventGateway;
import com.bacchiega.EventClean.infrastructure.exceptions.NotFoundEventException;

public class IdentifierFilterUseCaseImpl implements IdentifierFilterUseCase{

    private final EventGateway eventGateway;

    public IdentifierFilterUseCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public Event execute(String identifier) {
        return eventGateway.findByIdentifier(identifier).orElseThrow(() -> new NotFoundEventException("Event not found"));
    }
}
