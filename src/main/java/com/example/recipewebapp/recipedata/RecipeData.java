package com.example.recipewebapp.recipedata;

import jakarta.persistence.*;

@Entity
@Table
public class RecipeData {

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
    private Long id;
    private String name;
    private String description;
    private Integer calorieCount;
    private String ingredients;
    private String instructions;

    public RecipeData(Long id, String name, String description, Integer calorieCount, String ingredients, String instructions) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.calorieCount = calorieCount;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public RecipeData(String name, String description, Integer calorieCount, String ingredients, String instructions) {
        this.name = name;
        this.description = description;
        this.calorieCount = calorieCount;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    /*
    I don't know why I had to make this empty constructor.
     */
    public RecipeData() {

    }

    public Long getId() {
        return id;
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
    public void setId(Long id) {
        this.id = id;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", calorieCount=" + calorieCount +
                ", ingredients='" + ingredients + '\'' +
                ", instructions='" + instructions + '\'' +
                '}';
    }
}
