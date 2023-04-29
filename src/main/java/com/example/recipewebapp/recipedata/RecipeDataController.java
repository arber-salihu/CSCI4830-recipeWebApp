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

    @DeleteMapping(path= "{recipeDataId}/{username}")
    public void deleteRecipe(@PathVariable("recipeDataId") Long id, @PathVariable("username") String username) {
        recipeDataService.deleteRecipe(username, id);
    }

    @PostMapping("/{username}")
    public void registerNewRecipe(@PathVariable String username, @RequestBody RecipeData recipeData) {
        recipeDataService.addNewRecipe(username, recipeData);
    }

    @PutMapping(path = "{recipeId}/{username}")
    public ResponseEntity<Object> updateRecipe(
            @PathVariable Long recipeId,
            @PathVariable String username,
            @RequestBody RecipeData recipeData) {
        recipeDataService.updateRecipe(username, recipeId, recipeData.getName(), recipeData.getDescription(), recipeData.getCalorieCount(), recipeData.getIngredients(), recipeData.getInstructions());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}

