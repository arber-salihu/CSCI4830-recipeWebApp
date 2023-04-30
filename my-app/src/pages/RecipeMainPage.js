import React, { useEffect, useState } from "react";
import { Card, CardBody, CardTitle, CardSubtitle, Col, Row } from "reactstrap";
import { Link } from "react-router-dom";
import "./RecipeCard.css";

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
      <Row>
        {recipes.map((recipe) => (
            <Col md={4} key={recipe.recipe_id}>
              <Link className="link-color" to={`/recipe/${recipe.recipe_id}`}>
                <Card className="recipe-list-row">
                  <CardBody>
                    <CardTitle tag="h2">{recipe.name}</CardTitle>
                    <CardSubtitle>{recipe.description}</CardSubtitle>
                    <p>{recipe.calorieCount} calories</p>
                  </CardBody>
                </Card>
              </Link>
            </Col>
        ))}
      </Row>
  );
}

export default RecipeList;
