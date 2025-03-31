package com.bacchiega.EventClean.infrastructure.gateway;

import com.bacchiega.EventClean.core.entities.Event;
import com.bacchiega.EventClean.core.gateway.EventGateway;
import com.bacchiega.EventClean.infrastructure.exceptions.NotFoundEventException;
import com.bacchiega.EventClean.infrastructure.mapper.EventEntityMapper;
import com.bacchiega.EventClean.infrastructure.persistence.EventEntity;
import com.bacchiega.EventClean.infrastructure.persistence.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

// conectando o core com a infraestrutura. faço isso implementando o gateway do core
@Component
@RequiredArgsConstructor
public class EventRepositoryGateway implements EventGateway {

    // Inversão de dependencia - "D" do SOLID - Dependency Inversion Principle. É um principio
    // O core é protegido de tudo que é externo. O que é externo pode se comunicar com o core, mas o core não pode se comunicar com o externo.

    // Injeção de dependencia - Insere uma dependencia em uma classe de forma que a classe não precise instanciar a dependencia.

    private final EventRepository eventRepository;
    private final EventEntityMapper eventEntityMapper;

    // achando a implementação do gateway, ele vai executar o código.
    @Override
    public Event createEvent(Event event) {
        EventEntity eventEntity = eventEntityMapper.toEntity(event);
        EventEntity newEntity = eventRepository.save(eventEntity);
        return eventEntityMapper.toDomain(newEntity);
    }

    @Override
    public List<Event> findAllEvents() {
        return eventRepository.findAll().stream()
                .map(eventEntityMapper::toDomain).toList();
    }

    // metodo para verificar se o identificador já existe
    @Override
    public boolean existsIdentifier(String identifier) {
        return eventRepository.findAll().stream()
                .anyMatch(event -> event.getIdentifier().equalsIgnoreCase(identifier));
    }

    @Override
    public Optional<Event> findByIdentifier(String identifier) {
        return eventRepository.findByIdentifier(identifier).map(eventEntityMapper::toDomain);
    }
}
