import React, { useState } from 'react';
import {Link} from "react-router-dom";

function Login() {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    function handleSubmit(event) {
        event.preventDefault();

        fetch(`http://localhost:8080/api/v1/login?username=${encodeURIComponent(username)}&password=${encodeURIComponent(password)}`, {
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
                <label>
                    Username:
                    <input type="text" value={username} onChange={e => setUsername(e.target.value)} />
                </label>
                <br />
                <label>
                    Password:
                    <input type="password" value={password} onChange={e => setPassword(e.target.value)} />
                </label>
                <br />
                <button type="submit">Login</button>
                <button><Link to={"/signup"}>Sign Up</Link></button>
            </form>
        </div>
    );
}

export default Login;
