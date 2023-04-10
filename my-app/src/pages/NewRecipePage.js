import React, { useState } from 'react';
import './NewRecipePage.css'
function NewRecipeForm() {
    const [title, setTitle] = useState('');
    const [description, setDescription] = useState('');
    const [ingredients, setIngredients] = useState('');
    const [instructions, setInstructions] = useState('');

    const handleSubmit = (event) => {
        event.preventDefault();

        // Send data to backend or perform any other desired action
        console.log(title, description, ingredients, instructions);
    };

    return (
        <form onSubmit={handleSubmit} className="fancyDiv">
            <h1>Add New Recipe</h1>
            <div>
                <label htmlFor="title">Recipe Title:</label>
                <input
                    type="text"
                    id="title"
                    value={title}
                    onChange={(event) => setTitle(event.target.value)}
                />
            </div>
            <div>
                <label htmlFor="description">Description:</label>
                <textarea
                    id="description"
                    value={description}
                    onChange={(event) => setDescription(event.target.value)}
                ></textarea>
            </div>
            <div>
                <label htmlFor="ingredients">Ingredients:</label>
                <textarea
                    id="ingredients"
                    value={ingredients}
                    onChange={(event) => setIngredients(event.target.value)}
                ></textarea>
            </div>
            <div>
                <label htmlFor="instructions">Instructions:</label>
                <textarea
                    id="instructions"
                    value={instructions}
                    onChange={(event) => setInstructions(event.target.value)}
                ></textarea>
            </div>
            <button type="submit">Submit</button>
        </form>
    );
}

export default NewRecipeForm;