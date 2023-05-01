package com.example.recipewebapp.recipedata;

import com.example.recipewebapp.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RecipeDataControllerTest {

    @InjectMocks
    private RecipeDataController recipeDataController;

    @Mock
    private RecipeDataService recipeDataService;

    private RecipeData recipeData;
    private User user;

    @BeforeEach
    void setUp() {
        user = new User("testUser", "test@example.com", "password");
        user.setUser_id(1L);

        recipeData = new RecipeData("Recipe 1", "Description 1", 200, "Ingredients 1", "Instructions 1");
        recipeData.setRecipe_id(1L);
        recipeData.setUser(user);
    }

    @Test
    void getRecipes() {
        when(recipeDataService.getRecipes()).thenReturn(Arrays.asList(recipeData));

        List<RecipeData> result = recipeDataController.getRecipes();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(recipeData, result.get(0));
        verify(recipeDataService, times(1)).getRecipes();
    }

    @Test
    void getRecipeById() {
        when(recipeDataService.getRecipeById(1L)).thenReturn(recipeData);

        RecipeData result = recipeDataController.getRecipeById(1L);

        assertNotNull(result);
        assertEquals(recipeData, result);
        verify(recipeDataService, times(1)).getRecipeById(1L);
    }

    @Test
    void deleteRecipe() {
        doNothing().when(recipeDataService).deleteRecipe("testUser", 1L);

        recipeDataController.deleteRecipe(1L, "testUser");

        verify(recipeDataService, times(1)).deleteRecipe("testUser", 1L);
    }

    @Test
    void registerNewRecipe() {
        doNothing().when(recipeDataService).addNewRecipe("testUser", recipeData);

        recipeDataController.registerNewRecipe("testUser", recipeData);

        verify(recipeDataService, times(1)).addNewRecipe("testUser", recipeData);
    }

    @Test
    void updateRecipe() {
        RecipeData updatedRecipeData = new RecipeData("Updated Recipe", "Updated Description", 250, "Updated Ingredients", "Updated Instructions");
        updatedRecipeData.setRecipe_id(1L);
        updatedRecipeData.setUser(user);

        doNothing().when(recipeDataService).updateRecipe("testUser", 1L, updatedRecipeData.getName(), updatedRecipeData.getDescription(), updatedRecipeData.getCalorieCount(), updatedRecipeData.getIngredients(), updatedRecipeData.getInstructions());

        ResponseEntity<Object> result = recipeDataController.updateRecipe(1L, "testUser", updatedRecipeData);

        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());
        verify(recipeDataService, times(1)).updateRecipe("testUser", 1L, updatedRecipeData.getName(), updatedRecipeData.getDescription(), updatedRecipeData.getCalorieCount(), updatedRecipeData.getIngredients(), updatedRecipeData.getInstructions());
    }
}
