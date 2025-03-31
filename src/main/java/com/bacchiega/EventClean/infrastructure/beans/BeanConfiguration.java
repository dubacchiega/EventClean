package com.bacchiega.EventClean.infrastructure.beans;

import com.bacchiega.EventClean.core.gateway.EventGateway;
import com.bacchiega.EventClean.core.useCases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    // criando um bean para o UseCase ter um contexto.
    // como eu nao posso nada externo no UseCase, eu nao posso anotar com @Service, entao eu crio um bean para ele.
    @Bean
    public CreateEventUseCase createEventUCase(EventGateway eventGateway, GenerateRandomIdentifierUseCase generateRandomIdentifierUseCase) {
        return new CreateEventUseCaseImpl(eventGateway, generateRandomIdentifierUseCase);
    }

    @Bean
    public FindEventUseCase findEventCase(EventGateway eventGateway){
        return new FindEventUseCaseImpl(eventGateway);
    }

    @Bean
    public IdentifierFilterUseCase identifierFilterUseCase(EventGateway eventGateway){
        return new IdentifierFilterUseCaseImpl(eventGateway);
    }

    @Bean
    public GenerateRandomIdentifierUseCase generateRandomIdentifierUseCase() {
        return new GenerateRandomIdentifierUseCaseImpl();
    }

}
