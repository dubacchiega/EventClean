package com.bacchiega.EventClean.core.useCases;

import com.bacchiega.EventClean.core.entities.Event;
import com.bacchiega.EventClean.core.gateway.EventGateway;

import java.util.List;

public class FindEventUseCaseImpl implements FindEventUseCase {

    private final EventGateway eventGateway;

    public FindEventUseCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public List<Event> execute() {
        return eventGateway.findAllEvents();
    }
}
