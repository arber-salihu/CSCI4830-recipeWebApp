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
                    "A creamy dish of tasty alfredo pasta with chicken.",
                    1050,
                    "chicken, pasta, cream, cheese, and garlic. ",
                    "Cook the chicken and the pasta and put them together with the rest of the ingredients. Viola!"
            );

            RecipeData gBread = new RecipeData(
                    "G-Bread",
                    "Delicious GARLIC bread!",
                    240,
                    "Thick sliced bread, garlic, and butter.",
                    "Toast bread on pan with premade garlic butter. Yum!"
            );

            repository.saveAll(
                    List.of(chickenAlfredo, gBread)
            );
        };
    }
}
