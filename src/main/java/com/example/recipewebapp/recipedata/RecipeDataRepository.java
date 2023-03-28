package com.example.recipewebapp.recipedata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeDataRepository
        extends JpaRepository<RecipeData, Long> {
}
