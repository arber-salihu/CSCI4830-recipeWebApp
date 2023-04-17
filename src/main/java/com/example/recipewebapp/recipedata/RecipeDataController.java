package com.example.recipewebapp.recipedata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Object> updateRecipeu(
            @PathVariable Long recipeId,
            @RequestBody RecipeData recipeData) {
        recipeDataService.updateRecipe(recipeId, recipeData.getName(), recipeData.getDescription(), recipeData.getCalorieCount());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

