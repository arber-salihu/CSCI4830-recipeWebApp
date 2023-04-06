import './App.css';
import RecipeMainPage from './pages/RecipeMainPage';
import Navbar from "./components/Navbar";

function App() {
  return (
    <div className="App">
        <Navbar/>
        <RecipeMainPage />
    </div>
  );
}

export default App;
