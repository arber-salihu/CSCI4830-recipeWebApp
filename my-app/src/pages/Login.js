import React, { useState } from 'react';
import {Link} from "react-router-dom";

function Login() {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    function handleSubmit(event) {
        event.preventDefault();

        fetch(`${process.env.REACT_APP_API_BASE_URL}/api/v1/login?username=${encodeURIComponent(username)}&password=${encodeURIComponent(password)}`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
        })
            .then(response => {
                if (response.ok) {
                    response.json().then(data => {
                        localStorage.setItem('username', data.username);
                        console.log("Login successful");
                        window.location.href = '/';
                    });
                } else if (response.status === 401) {
                    console.log("Invalid username or password");
                } else {
                    console.log("Unexpected error occurred");
                }
            })
            .catch(error => {
                console.error("Network error:", error);
            });
    }

    return (
        <div>
            <form onSubmit={handleSubmit} className="fancyDiv">
                <h1>Login</h1>
                <label htmlFor="username" id="username-label">
                    Username:
                    <input type="text" id="username" value={username} onChange={e => setUsername(e.target.value)} />
                </label>
                <br />
                <label htmlFor="password" id="password-label">
                    Password:
                    <input type="password" id="password" value={password} onChange={e => setPassword(e.target.value)} />
                </label>
                <br />
                <button type="submit" id="login-button">Login</button>
                <button id="signup-button"><Link to={"/signup"}>Sign Up</Link></button>
            </form>
        </div>
    );
}

export default Login;
