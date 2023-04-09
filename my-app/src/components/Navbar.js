import React from 'react';
import NewRecipeForm from "../pages/NewRecipePage";
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import RecipeMainPage from "../pages/RecipeMainPage";
import './Navbar.css';
const Navbar = () => {
    return (
        <div>
            <nav>
                <ul>
                    <li>
                        <Link to="/" >Home</Link>
                    </li>
                    <li>
                        <Link to="/newPage" >New Recipe</Link>
                    </li>
                </ul>
            </nav>
        </div>
    );
};

export default Navbar;