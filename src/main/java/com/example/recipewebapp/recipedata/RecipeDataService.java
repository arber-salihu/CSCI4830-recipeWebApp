package com.example.recipewebapp.recipedata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeDataService {

    private final RecipeDataRepository recipeDataRepository;

    @Autowired
    public RecipeDataService(RecipeDataRepository recipeDataRepository) {
        this.recipeDataRepository = recipeDataRepository;
    }

    public List<RecipeData> getRecipes() {
        return recipeDataRepository.findAll();
    }
}
