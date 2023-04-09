import React, { useEffect, useState } from "react";
import { useParams, useNavigate, Link } from "react-router-dom";

function RecipeDetails() {
  const { id } = useParams();
  const [recipe, setRecipe] = useState(null);
  const navigate = useNavigate();

  useEffect(() => {
    async function fetchRecipe() {
      const response = await fetch(`http://localhost:8080/api/v1/recipe/${id}`);
      const data = await response.json();
      setRecipe(data);
    }
    fetchRecipe();
  }, [id]);

  if (!recipe) {
    return <div>Loading...</div>;
  }

  return (
    <div>
      <h1>{recipe.name}</h1>
      <p>{recipe.description}</p>
      <p>{recipe.calorieCount} calories</p>
      <Link to={`/edit-recipe/${id}`}>Edit</Link>
    </div>
  );
}

export default RecipeDetails;
