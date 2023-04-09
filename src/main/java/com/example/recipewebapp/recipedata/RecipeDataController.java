package com.example.recipewebapp.recipedata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/recipe")
@CrossOrigin(origins = "http://localhost:3000")
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
    @GetMapping(path = "{recipeId}")
    public RecipeData getRecipeById(@PathVariable("recipeId") Long recipeId) {
        return recipeDataService.getRecipeById(recipeId);
    }

    @DeleteMapping(path= "{recipeDataId}")
    public void deleteRecipe(@PathVariable("recipeDataId") Long id) {
        recipeDataService.deleteRecipe(id);
    }

    @PostMapping
    public void registerNewRecipe(@RequestBody RecipeData recipeData) {
        recipeDataService.addNewRecipe(recipeData);
    }
    @PutMapping(path = "{recipeId}")
    public void updateRecipe(
            @PathVariable("recipeId") Long recipeId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) int calorieCount) {
        recipeDataService.updateRecipe(recipeId, name, description, calorieCount);
    }
}
