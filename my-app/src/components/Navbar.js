import React from 'react';
import { Link } from 'react-router-dom';
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
                    <li className="right">
                        <Link to="/login" >Login</Link>
                    </li>
                </ul>
            </nav>
        </div>
    );
};

export default Navbar;
