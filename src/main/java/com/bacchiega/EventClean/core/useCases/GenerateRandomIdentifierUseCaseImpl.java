package com.bacchiega.EventClean.core.useCases;

import java.util.Random;

public class GenerateRandomIdentifierUseCaseImpl implements GenerateRandomIdentifierUseCase {


    @Override
    public String execute() {
        String character = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append(character.charAt(random.nextInt(character.length())));
        }
        return sb.toString();
    }

}
