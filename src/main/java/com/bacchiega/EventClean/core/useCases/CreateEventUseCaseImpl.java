package com.bacchiega.EventClean.core.useCases;

import com.bacchiega.EventClean.core.entities.Event;
import com.bacchiega.EventClean.core.gateway.EventGateway;
import com.bacchiega.EventClean.infrastructure.exceptions.DuplicateEventException;


public class CreateEventUseCaseImpl implements CreateEventUseCase {

    private final EventGateway eventGateway;
    private final GenerateRandomIdentifierUseCase generateRandomIdentifierUseCase;


    public CreateEventUseCaseImpl(EventGateway eventGateway, GenerateRandomIdentifierUseCase generateRandomIdentifierUseCase) {
        this.eventGateway = eventGateway;
        this.generateRandomIdentifierUseCase = generateRandomIdentifierUseCase;
    }

    // vai chegar até a implementação, mas ele vai ver que eu to injetando o gateway. Então ele vai até o gateway
    @Override
    public Event execute(Event event) {
        // verifica se o identificador existe ja na criação do evento
        if (eventGateway.existsIdentifier(event.getIdentifier())){
            throw new DuplicateEventException("Event already exists");
        }
        if (event.getIdentifier() == null || event.getIdentifier().isEmpty()) {
            event.setIdentifier(generateRandomIdentifierUseCase.execute());
        }
        return eventGateway.createEvent(event);
    }
}
