package com.bacchiega.EventClean.core.useCases;

import com.bacchiega.EventClean.core.entities.Event;

public interface FindEventCase {

    Event execute(Long id);
}
