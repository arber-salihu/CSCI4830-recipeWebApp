import React, { useState } from 'react';

function Login() {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    function handleSubmit(event) {
        event.preventDefault();

        fetch('http://localhost:8080/api/v1/login', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ username, password })
        })
            .then(response => {
                if (response.ok) {
                    // TODO: handle successful login
                } else {
                    // TODO: handle failed login
                }
            })
            .catch(error => {
                // TODO: handle network error
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
            </form>
        </div>
    );
}

export default Login;
