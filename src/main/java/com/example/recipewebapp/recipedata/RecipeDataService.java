package com.example.recipewebapp.recipedata;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeDataService {

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
