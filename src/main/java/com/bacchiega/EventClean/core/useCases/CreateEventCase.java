package com.bacchiega.EventClean.core.useCases;

import com.bacchiega.EventClean.core.entities.Event;

public interface CreateEventCase {

    Event execute(Event event);
}
