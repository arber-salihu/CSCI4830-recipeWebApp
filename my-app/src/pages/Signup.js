import React, { useState } from 'react';


function SignUp() {
    const [email, setEmail] = useState('');
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    function handleSubmit(event) {
        event.preventDefault();

        fetch(`${process.env.REACT_APP_API_BASE_URL}/api/v1/users`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                email: email,
                username: username,
                password: password
            })
        })
            .then(response => {
                if (response.ok) {
                    console.log('User created successfully!');
                } else {
                    console.error('Error creating user:', response.statusText);
                }
            })
            .catch(error => {
                console.error('Error creating user:', error);
            });
        window.location.href='/';
    }

    return (
        <div>
            <form onSubmit={handleSubmit} className="fancyDiv" id="signup-form">
                <h1>Sign Up</h1>
                <label htmlFor="email" id="email-label">
                    Email:
                    <input type="email" id="email-input" value={email} onChange={e => setEmail(e.target.value)} />
                </label>
                <br />
                <label htmlFor="username" id="username-label">
                    Username:
                    <input type="text" id="username-input" value={username} onChange={e => setUsername(e.target.value)} />
                </label>
                <br />
                <label htmlFor="password" id="password-label">
                    Password:
                    <input type="password" id="password-input" value={password} onChange={e => setPassword(e.target.value)} />
                </label>
                <br />
                <button type="submit" id="signup-button">Sign Up</button>
            </form>

        </div>
    );
}

export default SignUp;
