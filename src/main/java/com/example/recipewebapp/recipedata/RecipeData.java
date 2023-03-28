package com.example.recipewebapp.recipedata;

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
    private int calorieCount;

    public RecipeData(Long id, String name, String description, int calorieCount) {
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

    public void setId(Long id) {
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
