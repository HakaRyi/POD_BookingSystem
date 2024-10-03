import React, { useState } from 'react';
import './Login.css';
import Header from '../Layout/Header';
import { useNavigate } from 'react-router-dom'; // Import useNavigate hook

const Login = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const navigate = useNavigate(); // Initialize navigate

    const handleLogin = () => {
        console.log("Username:", username, "Password:", password);
    };

    const handleSignupRedirect = () => {
        navigate('/signup'); // Navigate to Sign Up page
    };

    return (
        <div className="login-page">
            <Header />
            <div className="login-form-container">
                <div className="login-form">
                    <label>Username:</label>
                    <input
                        type="text"
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
                        placeholder="Enter your username"
                    />
                    <label>Password:</label>
                    <input
                        type="password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        placeholder="Enter your password"
                    />
                    <div className="login-buttons">
                        <button onClick={handleLogin}>Log in</button>
                        <button onClick={handleSignupRedirect}>Sign up</button> {/* Redirects to Sign Up */}
                    </div>
                </div>
            </div>
        </div>
    );
};

export default Login;
