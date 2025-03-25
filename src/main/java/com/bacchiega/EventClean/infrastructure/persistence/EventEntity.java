package com.bacchiega.EventClean.infrastructure.persistence;

import com.bacchiega.EventClean.core.enums.EventType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "event")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String identifier;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;
    private String location;
    private String organizer;
    private Integer capacity;

    @Enumerated(EnumType.STRING) // faz com que o meu enum seja salvo como string no banco de dados
    private EventType type;
}
