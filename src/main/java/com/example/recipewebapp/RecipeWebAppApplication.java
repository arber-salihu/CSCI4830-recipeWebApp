package com.example.recipewebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class RecipeWebAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecipeWebAppApplication.class, args);
    }

}
