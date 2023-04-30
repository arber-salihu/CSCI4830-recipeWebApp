import React from 'react';
import {Link} from 'react-router-dom';
import './Navbar.css';

const Navbar = () => {
    const username = localStorage.getItem('username');

    return (
        <div>
            <nav>
                <ul>
                    <li>
                        <Link to="/">Home</Link>
                    </li>
                    {username && (
                        <li>
                            <Link to="/newPage">New Recipe</Link>
                        </li>
                    )}
                    {username ? (
                        <li className="right">
                            <Link to="/userprofile">Profile</Link>
                        </li>
                    ) : (
                        <li className="right">
                            <Link to="/login">Login</Link>
                        </li>
                    )}
                </ul>
            </nav>
        </div>
    );
}

export default Navbar;
