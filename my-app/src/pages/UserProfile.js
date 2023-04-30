import React, { useState, useEffect } from 'react';

function UserProfile() {
    const [user, setUser] = useState(null);
    const [newEmail, setNewEmail] = useState('');
    const [newUsername, setNewUsername] = useState('');
    const [newPassword, setNewPassword] = useState('');
    const handleLogout = () => {
        localStorage.clear(); // Clear the local storage
        window.location.href = '/';
    }
    const username = localStorage.getItem('username');
    useEffect(() => {
        async function fetchUser() {
            const response = await fetch(`http://localhost:8080/api/v1/users/username/${username}`);
            const data = await response.json();
            setUser(data);
        }
        fetchUser();
    }, [username]);

    const handleSubmit = async (event) => {
        event.preventDefault();
        const updatedUser = {
            email: newEmail || user.email,
            username: newUsername || user.username,
            password: newPassword || user.password
        };
        const response = await fetch(`http://localhost:8080/api/v1/users/username/${username}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(updatedUser)
        });
        const data = await response.json();
        setUser(data);
        localStorage.setItem('username', data.username); // Update the local storage with the new username
    }


        if (!user) {
        return <div>Loading...</div>;
    }

    return (
        <div>
            <h1>User Profile</h1>
            <form onSubmit={handleSubmit}>
                <div>
                    <label htmlFor="email">Email:</label>
                    <input type="text" id="email" name="email" value={newEmail || user.email} onChange={(event) => setNewEmail(event.target.value)} />
                </div>
                <div>
                    <label htmlFor="username">Username:</label>
                    <input type="text" id="username" name="username" value={newUsername || user.username} onChange={(event) => setNewUsername(event.target.value)} />
                </div>
                <div>
                    <label htmlFor="password">Password:</label>
                    <input type="password" id="password" name="password" value={newPassword || user.password} onChange={(event) => setNewPassword(event.target.value)} />
                </div>
                <button className="button-layout" type="submit">Save Changes</button>
            </form>
            <button className="button-layout" onClick={handleLogout}>Logout</button>
        </div>

    );
}

export default UserProfile;
