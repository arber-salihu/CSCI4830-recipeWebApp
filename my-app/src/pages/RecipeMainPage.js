import React, { useEffect, useState } from "react";
import { Card, CardBody, CardTitle, CardSubtitle } from "reactstrap";
import "./RecipeCard.css";
import { Link } from "react-router-dom";

function RecipeList() {
  const [recipes, setRecipes] = useState([]);

  useEffect(() => {
    async function fetchRecipes() {
      const response = await fetch("http://localhost:8080/api/v1/recipe");
      const data = await response.json();
      setRecipes(data);
    }
    fetchRecipes();
  }, []);

  return (
    
    <div className="card-container">
      {recipes.map((recipe) => (
        <Link to={`/recipe/${recipe.id}`} key={recipe.id}>
          <Card key={recipe.id}>
            <CardBody>
              <CardTitle tag="h2">{recipe.name}</CardTitle>
              <CardSubtitle>{recipe.description}</CardSubtitle>
              <p>{recipe.calorieCount} calories</p>
            </CardBody>
          </Card>
        </Link>
      ))}
    </div>
 
  );
}

export default RecipeList;
