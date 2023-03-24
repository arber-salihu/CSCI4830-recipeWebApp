package com.example.recipewebapp.recipedata;

public class RecipeData {
    private int id;
    private String name;
    private String description;
    private int calorieCount;

    public RecipeData(int id, String name, String description, int calorieCount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.calorieCount = calorieCount;
    }

    public RecipeData(String name, String description, int calorieCount) {
        this.name = name;
        this.description = description;
        this.calorieCount = calorieCount;
    }

    public int getId() {
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

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCalorieCount(int calorieCount) {
        this.calorieCount = calorieCount;
    }

    @Override
    public String toString() {
        return "RecipeData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", calorieCount=" + calorieCount +
                '}';
    }
}
