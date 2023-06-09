import React, {useEffect, useState} from "react";
import {useNavigate, useParams} from "react-router-dom";
import './EditPage.css'
import '../index.css'

function EditRecipe() {
  const { id } = useParams();
  const [recipe, setRecipe] = useState(null);
  const navigate = useNavigate();
  const username = localStorage.getItem('username');

  useEffect(() => {
    async function fetchRecipe() {
      const response = await fetch(`${process.env.REACT_APP_API_BASE_URL}/api/v1/recipe/${id}`);
      const data = await response.json();
      setRecipe(data);
    }
    fetchRecipe();
  }, [id]);

  const handleDeleteClick = async () => {
    await fetch(`${process.env.REACT_APP_API_BASE_URL}/api/v1/recipe/${id}/${username}`, {
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

    await fetch(`${process.env.REACT_APP_API_BASE_URL}/api/v1/recipe/${id}/${username}`, {
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
      <div className="fancyDiv" id="edit-recipe">
        <h1 id="edit-recipe-title">Edit Recipe</h1>
        <form onSubmit={handleFormSubmit}>
          <div>
            <label htmlFor="name" id="name-label">Name</label>
            <input
                id="name"
                name="name"
                type="text"
                defaultValue={recipe.name}
            />
          </div>
          <div>
            <label htmlFor="description" id="description-label">Description</label>
            <textarea
                id="description"
                name="description"
                defaultValue={recipe.description}
            />
          </div>
          <div>
            <label htmlFor="ingredients" id="ingredients-label">Ingredients</label>
            <textarea
                id="ingredients"
                name="ingredients"
                defaultValue={recipe.ingredients}
            />
          </div>
          <div>
            <label htmlFor="instructions" id="instructions-label">Instructions</label>
            <textarea
                id="instructions"
                name="instructions"
                defaultValue={recipe.instructions}
            />
          </div>
          <div>
            <label htmlFor="calorieCount" id="calorieCount-label">Calorie Count</label>
            <input
                id="calorieCount"
                name="calorieCount"
                type="number"
                defaultValue={recipe.calorieCount}
            />
          </div>
          <button type="submit" className="fancyButton" id="save-button">Save Changes</button>
          <button onClick={handleDeleteClick} className="fancyButton red-button" id="delete-button">Delete Recipe</button>
        </form>
      </div>

);
}

export default EditRecipe;
