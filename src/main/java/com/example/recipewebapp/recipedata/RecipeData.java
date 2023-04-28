package com.example.recipewebapp.recipedata;

import com.example.recipewebapp.user.User;
import jakarta.persistence.*;

@Entity
@Table
public class RecipeData {

    //    @ManyToOne
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;
    @Id
    @SequenceGenerator(
            name = "recipe_sequence",
            sequenceName = "recipe_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "recipe_sequence"
    )
    private Long recipe_id;
    private String name;
    private String description;
    private Integer calorieCount;
    private String ingredients;
    private String instructions;

//    public RecipeData(Long recipe_id, String name, String description, Integer calorieCount, String ingredients, String instructions, User user) {
//        this.recipe_id = recipe_id;
//        this.name = name;
//        this.description = description;
//        this.calorieCount = calorieCount;
//        this.ingredients = ingredients;
//        this.instructions = instructions;
//        this.user = user;
//    }

    public RecipeData(String name, String description, Integer calorieCount, String ingredients, String instructions) {
        this.name = name;
        this.description = description;
        this.calorieCount = calorieCount;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public RecipeData() {

    }
    public void setRecipe_id(Long recipe_id) {
        this.recipe_id = recipe_id;
    }

    public Long getRecipe_id() {
        return recipe_id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getCalorieCount() {
        return calorieCount;
    }
    public String getIngredients() {
        return ingredients;
    }
    public String getInstructions() {
        return instructions;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCalorieCount(Integer calorieCount) {
        this.calorieCount = calorieCount;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
    @Override
    public String toString() {
        return "RecipeData{" +
                "id=" + recipe_id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", calorieCount=" + calorieCount +
                ", ingredients='" + ingredients + '\'' +
                ", instructions='" + instructions + '\'' +
                '}';
    }
}
