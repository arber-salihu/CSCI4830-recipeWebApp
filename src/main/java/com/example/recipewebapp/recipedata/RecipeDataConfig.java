package com.example.recipewebapp.recipedata;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class RecipeDataConfig {

    @Bean
    CommandLineRunner commandLineRunner(RecipeDataRepository repository) {
        return args -> {
            RecipeData chickenAlfredo = new RecipeData(
                    "Chicken Alfredo",
                    "A creamy dish of tastey alfredo pasta with chicken.",
                    1050
            );

            RecipeData gBread = new RecipeData(
                    "G-Bread",
                    "Delicious GARLIC bread!",
                    240
            );

            repository.saveAll(
                    List.of(chickenAlfredo, gBread)
            );
        };
    }
}
