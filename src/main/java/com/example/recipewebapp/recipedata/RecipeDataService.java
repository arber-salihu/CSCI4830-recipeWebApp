package com.example.recipewebapp.recipedata;

import com.example.recipewebapp.user.User;
import com.example.recipewebapp.user.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RecipeDataService {

    private final RecipeDataRepository recipeDataRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public RecipeDataService(RecipeDataRepository recipeDataRepository) {
        this.recipeDataRepository = recipeDataRepository;
    }

    public List<RecipeData> getRecipes() {
        return recipeDataRepository.findAll();
    }
    public RecipeData getRecipeById(Long recipeId) {
        return recipeDataRepository.findById(recipeId)
                .orElseThrow(() -> new IllegalStateException(
                        "recipe with id " + recipeId + " does not exist"
                ));
    }


    public void addNewRecipe(String username, RecipeData recipeData) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            recipeData.setUser(user);
            recipeDataRepository.save(recipeData);
        } else {
            throw new IllegalStateException("User with username " + username + " does not exist");
        }
    }

    public void deleteRecipe(String username,Long recipeDataId) {
        boolean exists = recipeDataRepository.existsById(recipeDataId);
        if (!exists) {
            throw new IllegalStateException("recipe with id " + recipeDataId + " does not exist");
        }

        RecipeData recipeData = recipeDataRepository.findById(recipeDataId)
                .orElseThrow(() -> new IllegalStateException(
                        "recipe with id " + recipeDataId + " does not exist"
                ));

        User currentUser = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalStateException("User with username " + username + " does not exist"));

        if (!recipeData.getUser().equals(currentUser)) {
            throw new IllegalStateException("User with username " + username + " is not authorized to delete this recipe");
        }

        recipeDataRepository.deleteById(recipeDataId);
    }

    @Transactional
    public void updateRecipe(String username, Long recipeId, String name, String description, Integer calorieCount, String ingredients, String instructions) {
        RecipeData recipeData = recipeDataRepository.findById(recipeId)
                .orElseThrow(() -> new IllegalStateException(
                        "recipe with id " + recipeId + " does not exist"
                ));

        User currentUser = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalStateException("User with username " + username + " does not exist"));

        if (!recipeData.getUser().equals(currentUser)) {
            throw new IllegalStateException("User with username " + username + " is not authorized to edit this recipe");
        }

        if (name != null &&
                name.length() > 0 &&
                !Objects.equals(recipeData.getName(), name)
        ) {
            recipeData.setName(name);
        }

        if (description != null &&
                description.length() > 0 &&
                !Objects.equals(recipeData.getDescription(), description)
        ) {
            recipeData.setDescription(description);
        }

        if (calorieCount != null &&
                calorieCount > 0 &&
                !Objects.equals(recipeData.getCalorieCount(), calorieCount)
        ) {
            recipeData.setCalorieCount(calorieCount);
        }

        if (ingredients != null &&
                ingredients.length() > 0 &&
                !Objects.equals(recipeData.getIngredients(), ingredients)
        ) {
            recipeData.setIngredients(ingredients);
        }

        if (instructions != null &&
                instructions.length() > 0 &&
                !Objects.equals(recipeData.getInstructions(), instructions)
        ) {
            recipeData.setInstructions(instructions);
        }
    }

}
