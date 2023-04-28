import React, { useState } from 'react';


function SignUp() {
    const [email, setEmail] = useState('');
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    function handleSubmit(event) {
        event.preventDefault();

        fetch('http://localhost:8080/api/v1/users', {
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
            <form onSubmit={handleSubmit} className="fancyDiv">
                <h1>Sign Up</h1>
                <label>
                    Email:
                    <input type="email" value={email} onChange={e => setEmail(e.target.value)} />
                </label>
                <br />
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
                <button type="submit">Sign Up</button>
            </form>
        </div>
    );
}

export default SignUp;
