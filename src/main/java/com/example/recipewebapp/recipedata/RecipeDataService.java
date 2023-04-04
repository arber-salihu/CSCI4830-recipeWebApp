package com.example.recipewebapp.recipedata;

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
    public RecipeDataService(RecipeDataRepository recipeDataRepository) {
        this.recipeDataRepository = recipeDataRepository;
    }

    public List<RecipeData> getRecipes() {
        return recipeDataRepository.findAll();
    }

    public void addNewRecipe(RecipeData recipeData) {
        Optional<RecipeData> recipeOptional = recipeDataRepository
                .findRecipeDataByName(recipeData.getName());
        if (recipeOptional.isPresent()) {
            throw new IllegalStateException("name taken");
        }
        recipeDataRepository.save(recipeData);
    }

    public void deleteRecipe(Long recipeDataId) {
        boolean exists = recipeDataRepository.existsById(recipeDataId);
        if (!exists) {
            throw new IllegalStateException("recipe with id " + recipeDataId + " does not exist");
        }
        recipeDataRepository.deleteById(recipeDataId);
    }

    @Transactional
    public void updateRecipe(Long recipeId, String name,
                             String description,/*, int calorieCount*/int calorieCount) {
        RecipeData recipeData = recipeDataRepository.findById(recipeId)
                .orElseThrow(() -> new IllegalStateException(
                        "recipe with id " + recipeId + " does not exist"
                ));
        if (name != null &&
            name.length() > 0 &&
            !Objects.equals(recipeData.getName(), name)
        ) {
//            Optional<RecipeData> recipeOptional = recipeDataRepository
//                    .findRecipeDataByName(recipeData.getName());
//            if (recipeOptional.isPresent()) {
//                throw new IllegalStateException("name taken");
//            }
            recipeData.setName(name);
        }

        if (description != null &&
                description.length() > 0 &&
                !Objects.equals(recipeData.getDescription(), description)
        ) {
            recipeData.setDescription(description);
        }


    }
}
