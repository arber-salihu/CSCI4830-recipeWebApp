import React, { useEffect, useState } from "react";
import { Card, CardBody, CardTitle, CardSubtitle, Col, Row } from "reactstrap";
import { Link } from "react-router-dom";
import "./RecipeCard.css";

function RecipeList() {
  const [recipes, setRecipes] = useState([]);

  useEffect(() => {
    async function fetchRecipes() {
      const response = await fetch(`${process.env.REACT_APP_API_BASE_URL}/api/v1/recipe`);
      const data = await response.json();
      setRecipes(data);
    }
    fetchRecipes();
  }, []);

  return (
      <Row id="recipe-list">
        {recipes.map((recipe) => (
            <Col md={4} key={recipe.recipe_id} id={`recipe-col-${recipe.recipe_id}`}>
              <Link className="link-color" to={`/recipe/${recipe.recipe_id}`} id={`recipe-link-${recipe.recipe_id}`}>
                <Card className="recipe-list-row" id={`recipe-card-${recipe.recipe_id}`}>
                  <CardBody>
                    <CardTitle tag="h2" id={`recipe-title-${recipe.recipe_id}`}>{recipe.name}</CardTitle>
                    <CardSubtitle id={`recipe-description-${recipe.recipe_id}`}>{recipe.description}</CardSubtitle>
                    <p id={`recipe-calorie-count-${recipe.recipe_id}`}>{recipe.calorieCount} calories</p>
                  </CardBody>
                </Card>
              </Link>
            </Col>
        ))}
      </Row>
  );
}

export default RecipeList;
