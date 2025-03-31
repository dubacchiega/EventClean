package com.bacchiega.EventClean.infrastructure.mapper;

import com.bacchiega.EventClean.core.entities.Event;
import com.bacchiega.EventClean.core.gateway.EventGateway;
import com.bacchiega.EventClean.infrastructure.dto.EventDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventDtoMapper {

    @Autowired
    EventGateway eventGateway;

    // eu passo um Event (do core) pois ele vai ser um retorno de um UseCase
    public EventDto toDto(Event event){
        return new EventDto(
                event.getId(),
                event.getName(),
                event.getDescription(),
                event.getIdentifier(),
                event.getStartDate(),
                event.getEndDate(),
                event.getLocation(),
                event.getOrganizer(),
                event.getCapacity(),
                event.getType()
        );
    }

    // eu retorno um Event (do core) pois ele vai ser um parâmetro de um UseCase
    // toDomain significa que é a entidade do core
    public Event toDomain(EventDto dto){
        return new Event(
                dto.id(),
                dto.name(),
                dto.description(),
                dto.identifier(),
                dto.startDate(),
                dto.endDate(),
                dto.location(),
                dto.organizer(),
                dto.capacity(),
                dto.type()
        );
    }
}
