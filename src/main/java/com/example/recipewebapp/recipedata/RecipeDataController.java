package com.example.recipewebapp.recipedata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/recipe")
public class RecipeDataController {

    private final RecipeDataService recipeDataService;

    @Autowired
    public RecipeDataController(RecipeDataService recipeDataService) {
        this.recipeDataService = recipeDataService;
    }

    @GetMapping
    public List<RecipeData> getRecipes() {
        return recipeDataService.getRecipes();
    }
}
