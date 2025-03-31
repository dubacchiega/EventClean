package com.bacchiega.EventClean.core.useCases;

import com.bacchiega.EventClean.core.entities.Event;

import java.util.List;

public interface FindEventUseCase {

    List<Event> execute();
}
