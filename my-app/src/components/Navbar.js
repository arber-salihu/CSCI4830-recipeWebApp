import React from 'react';
import './Navbar.css'

const Navbar = () => {
  return (
      <ul>
          <li><a className="#recipe" href="#home">Recipes</a></li>
          <li><a href="#new">New Recipe</a></li>
          <li className="floatRight"><a href="#signup">Signup</a></li>
          <li className="floatRight"><a href="#login">Login</a></li>
      </ul>
  );
};

export default Navbar;