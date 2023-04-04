import React, { useEffect, useState } from "react";
import Card from "react-bootstrap/Card";
import CardDeck from "react-bootstrap/CardDeck";

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
    <CardDeck>
      {recipes.map((recipe) => (
        <Card key={recipe.id}>
          <Card.Body>
            <Card.Title>{recipe.name}</Card.Title>
            <Card.Text>{recipe.description}</Card.Text>
            <Card.Text>{recipe.calorieCount} calories</Card.Text>
          </Card.Body>
        </Card>
      ))}
    </CardDeck>
  );
}

export default RecipeList;
