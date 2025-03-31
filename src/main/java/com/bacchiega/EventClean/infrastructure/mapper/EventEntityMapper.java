package com.bacchiega.EventClean.infrastructure.mapper;

import com.bacchiega.EventClean.core.entities.Event;
import com.bacchiega.EventClean.infrastructure.persistence.EventEntity;
import org.springframework.stereotype.Component;

@Component
public class EventEntityMapper {

    // criando um mapper para converter o domain para entity e vice-versa. é para ser usado no gateway
    // eu preciso usar pois o meu gateway do core não pode conhecer a minha entidade do banco de dados, pois ela esta na infraestrutura
    // entao o core só vai usar o Domain, na minha implementação do gateway eu vou converter o domain para a entidade para usar no repository

    public EventEntity toEntity(Event event){
        return new EventEntity(
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

    public Event toDomain(EventEntity entity){
        return new Event(
                entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getIdentifier(),
                entity.getStartDate(),
                entity.getEndDate(),
                entity.getLocation(),
                entity.getOrganizer(),
                entity.getCapacity(),
                entity.getType()
        );
    }
}
