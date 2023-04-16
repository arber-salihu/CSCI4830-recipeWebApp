import React, { useState } from 'react';
import './NewRecipePage.css'

function NewRecipeForm() {
    const [title, setTitle] = useState('');
    const [description, setDescription] = useState('');
    const [calorieCount, setCalorieCount]=useState('')

    const handleSubmit = async (event) => {
        event.preventDefault();

        try {
            const response = await fetch('http://localhost:8080/api/v1/recipe', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    name: title,
                    description: description,
                    calorieCount: calorieCount
                })
            });

            if (!response.ok) {
                throw new Error('Failed to create recipe');
            }

            setTitle('');
            setDescription('');
            setCalorieCount('')

        } catch (error) {
            console.error(error);
        }
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
                <label htmlFor="calorieCount">Calorie Count:</label>
                <input
                    type="number"
                    id="calorieCount"
                    value={calorieCount}
                    onChange={(event) => setCalorieCount(event.target.value)}
                />
            </div>
            <button type="submit">Submit</button>
        </form>
    );
}

export default NewRecipeForm;
