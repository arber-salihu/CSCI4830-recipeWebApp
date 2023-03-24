package com.example.recipewebapp.recipedata;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/recipe")
public class RecipeDataController {

    @GetMapping
    public List<RecipeData> getRecipes() {
        return List.of(
                new RecipeData(
                        1,
                        "Chicken Alfredo",
                        "A creamy dish of tastey alfredo pasta with chicken.",
                        1050
                )
        );
    }
}
