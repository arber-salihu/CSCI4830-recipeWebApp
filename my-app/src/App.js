import React from "react";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import RecipeList from "./pages/RecipeList";
import EditRecipe from "./pages/EditPage.js";
import RecipeMainPage from "./pages/RecipeMainPage";
import NewRecipeForm from './pages/NewRecipePage';
import Navbar from "./components/Navbar";
import "./App.css";

function App() {
  return (
    <Router>
      <Navbar />
      <Routes>
        <Route path="/" element={<RecipeMainPage />} />
        <Route path="/newPage" element={<NewRecipeForm />} />
        <Route path="/recipe/:id" element={<RecipeList />} />
        <Route path="/edit-recipe/:id" element={<EditRecipe />} />
      </Routes>
    </Router>
  );
}

export default App;
