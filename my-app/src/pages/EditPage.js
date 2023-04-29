import React, {useEffect, useState} from "react";
import {useNavigate, useParams} from "react-router-dom";
import './EditPage.css'

function EditRecipe() {
  const { id } = useParams();
  const [recipe, setRecipe] = useState(null);
  const navigate = useNavigate();
  const username = localStorage.getItem('username');

  useEffect(() => {
    async function fetchRecipe() {
      const response = await fetch(`http://localhost:8080/api/v1/recipe/${id}`);
      const data = await response.json();
      setRecipe(data);
    }
    fetchRecipe();
  }, [id]);

  const handleDeleteClick = async () => {
    await fetch(`http://localhost:8080/api/v1/recipe/${id}/${username}`, {
      method: "DELETE",
    });
    navigate("/");
  };

  const handleFormSubmit = async (event) => {
    event.preventDefault();
    const formData = new FormData(event.target);
    const name = formData.get("name");
    const description = formData.get("description");
    const instructions = formData.get("instructions");
    const ingredients = formData.get("ingredients");
    const calorieCount = parseInt(formData.get("calorieCount"), 10);

    await fetch(`http://localhost:8080/api/v1/recipe/${id}/${username}`, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ name, description,instructions, ingredients, calorieCount }),
    });
    navigate("/");
  };

  if (!recipe) {
    return <div>Loading...</div>;
  }

  return (
  <html lang="en">
      <head>
        <meta charset="UTF-8" />
        <title>Edit Recipe</title>
      </head>
  <body>
  <div className="fancyDiv">
    <h1>Edit Recipe</h1>
    <form onSubmit={handleFormSubmit}>
      <div>
        <label htmlFor="name">Name</label>
        <input
            id="name"
            name="name"
            type="text"
            defaultValue={recipe.name}
        />
      </div>
      <div>
        <label htmlFor="description">Description</label>
        <textarea
            id="description"
            name="description"
            defaultValue={recipe.description}
        />
      </div>
      <div>
        <label htmlFor="ingredients">Ingredients</label>
        <textarea
            id="ingredients"
            name="ingredients"
            defaultValue={recipe.ingredients}
        />
      </div>
      <div>
        <label htmlFor="instructions">Instructions</label>
        <textarea
            id="instructions"
            name="instructions"
            defaultValue={recipe.instructions}
        />
      </div>
      <div>
        <label htmlFor="calorieCount">Calorie Count</label>
        <input
            id="calorieCount"
            name="calorieCount"
            type="number"
            defaultValue={recipe.calorieCount}
        />
      </div>
      <button type="submit" className="fancyButton">Save Changes</button>
      <button onClick={handleDeleteClick} className="fancyButton">Delete Recipe</button>
    </form>
  </div>
  </body>
</html>
);
}

export default EditRecipe;
