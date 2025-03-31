package com.bacchiega.EventClean.core.useCases;

import com.bacchiega.EventClean.core.entities.Event;

public interface IdentifierFilterUseCase {

    Event execute(String identifier);
}
