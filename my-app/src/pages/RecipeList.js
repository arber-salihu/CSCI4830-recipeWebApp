import React, { useEffect, useState } from "react";
import { useParams, useNavigate, Link } from "react-router-dom";

function RecipeDetails() {
  const { id } = useParams();
  const [recipe, setRecipe] = useState(null);
  const navigate = useNavigate();

  useEffect(() => {
    async function fetchRecipe() {
      const response = await fetch(`${process.env.REACT_APP_API_BASE_URL}/api/v1/recipe/${id}`);
      const data = await response.json();
      setRecipe(data);
    }
    fetchRecipe();
  }, [id]);

  if (!recipe) {
    return <div>Loading...</div>;
  }

  return (
      <div className="wideFancyDiv" id="recipe-details">
          <h1 id="recipe-title">{recipe.name}</h1><br/>
          <h5 id="recipe-description">Description: {recipe.description}</h5>
          <h5 id="recipe-ingredients">Ingredients: {recipe.ingredients}</h5>
          <h5 id="recipe-instructions">Instructions: {recipe.instructions}</h5>
          <p id="recipe-calorie-count">{recipe.calorieCount} calories</p>
          <button className="fancyButton" id="edit-button"><Link to={`/edit-recipe/${id}`}>Edit</Link></button>
      </div>
  );
}

export default RecipeDetails;
