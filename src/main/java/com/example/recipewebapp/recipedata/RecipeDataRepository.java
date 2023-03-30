package com.example.recipewebapp.recipedata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecipeDataRepository
        extends JpaRepository<RecipeData, Long> {

    @Query(/*"SELECT r FROM RecipeData r WHERE r.name = ?1"*/)
    Optional<RecipeData> findRecipeDataByName(String name);
}
