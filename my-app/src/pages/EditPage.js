import React, { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";

function EditRecipe() {
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

  const handleDeleteClick = async () => {
    await fetch(`http://localhost:8080/api/v1/recipe/${id}`, {
      method: "DELETE",
    });
    navigate("/");
  };

  const handleFormSubmit = async (event) => {
    event.preventDefault();
    const formData = new FormData(event.target);
    const name = formData.get("name");
    const description = formData.get("description");
    const calorieCount = parseInt(formData.get("calorieCount"), 10);

    await fetch(`http://localhost:8080/api/v1/recipe/${id}`, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ name, description, calorieCount }),
    });
    navigate("/");
  };

  if (!recipe) {
    return <div>Loading...</div>;
  }

  return (
    <div>
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
          <label htmlFor="calorieCount">Calorie Count</label>
          <input
            id="calorieCount"
            name="calorieCount"
            type="number"
            defaultValue={recipe.calorieCount}
          />
        </div>
        <button type="submit">Save Changes</button>
        <button onClick={handleDeleteClick}>Delete Recipe</button>
      </form>
    </div>
  );
}

export default EditRecipe;
