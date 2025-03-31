package com.bacchiega.EventClean.infrastructure.presentation;

import com.bacchiega.EventClean.core.entities.Event;
import com.bacchiega.EventClean.core.useCases.CreateEventUseCase;
import com.bacchiega.EventClean.core.useCases.FindEventUseCase;
import com.bacchiega.EventClean.core.useCases.GenerateRandomIdentifierUseCase;
import com.bacchiega.EventClean.core.useCases.IdentifierFilterUseCase;
import com.bacchiega.EventClean.infrastructure.dto.EventDto;
import com.bacchiega.EventClean.infrastructure.mapper.EventDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class EventController {

    private final CreateEventUseCase createEventCase; // usando o useCase (do core)
    private final FindEventUseCase findEventCase;
    private final IdentifierFilterUseCase identifierFilterUseCase;

    private final EventDtoMapper eventMapper;

    // Fluxo -> Vai bater no endpoint
    @PostMapping("/create")
    public ResponseEntity<Map<String, Object>> createEvent(@RequestBody EventDto dto) {

        // vai chamar o useCase.
        Event newEvent = createEventCase.execute(eventMapper.toDomain(dto)); // aqui eu precisaria passar uma entidade do core, por isso o meu Mapper retorna Event (do core)
        Map<String, Object> response = new HashMap<>();
        response.put("Message:", "Event created successfully");
        response.put("Data:", eventMapper.toDto(newEvent));// transformando em dto novamente. Por isso que o meu Mapper recebe um Event (do core)
        return ResponseEntity.ok(response);
    }

    @GetMapping("/list")
    public ResponseEntity<Map<String, Object>> findAllEvents() {
        List<EventDto> allEvents = findEventCase.execute().stream().map(eventMapper::toDto).collect(Collectors.toList());
        Map<String, Object> response = new HashMap<>();
        response.put("Message", "Events has been found");
        response.put("Datas:", allEvents);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/find/{identifier}")
    public ResponseEntity<Map<String, Object>> findByIdentifier(@PathVariable String identifier) {
        final Event event = identifierFilterUseCase.execute(identifier);
        Map<String, Object> response = new HashMap<>();
        response.put("Message:", "Event found successfully");
        response.put("Data:", eventMapper.toDto(event));
        return ResponseEntity.ok(response);
    }
}
