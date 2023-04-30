import React from "react";
import { BrowserRouter as Router, Routes, Route} from "react-router-dom";
import RecipeList from "./pages/RecipeList";
import EditRecipe from "./pages/EditPage.js";
import RecipeMainPage from "./pages/RecipeMainPage";
import NewRecipeForm from './pages/NewRecipePage';
import LoginPage from './pages/Login';
import SignupPage from './pages/Signup'
import Navbar from "./components/Navbar";
import "./App.css";
import UserProfile from "./pages/UserProfile";

function App() {
  return (
    <Router className="background-image">
      <Navbar />
      <Routes>
        <Route path="/" element={<RecipeMainPage />} />
        <Route path="/newPage" element={<NewRecipeForm />} />
          <Route path="/login" element={<LoginPage />} />
          <Route path="/userprofile" element={<UserProfile />} />
          <Route path="/signup" element={<SignupPage />} />
        <Route path="/recipe/:id" element={<RecipeList />} />
        <Route path="/edit-recipe/:id" element={<EditRecipe />} />
      </Routes>
    </Router>
  );
}

export default App;
