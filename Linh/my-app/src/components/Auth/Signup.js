import React, { useState } from 'react';
import './Signup.css';
import Header from '../Layout/Header'; // Import the header component
import signupImage from '../../assets/images/1.jpg'; // Import the image from src

const Signup = () => {
    const [formData, setFormData] = useState({
        fullname: '',
        phone: '',
        email: '',
        username: '',
        password: '',
        confirmPassword: '',
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });
    };

    const handleSignup = () => {
        // Perform signup logic here
        console.log(formData);
    };

    return (
        <div className="signup-page">
            <Header />
            <div className="signup-container">
                <img src={signupImage} alt="Signup" className="signup-image" />
                <div className="signup-form">
                    <h2>Please type all the information</h2>
                    <label>Fullname:</label>
                    <input
                        type="text"
                        name="fullname"
                        value={formData.fullname}
                        onChange={handleChange}
                        placeholder="Enter your fullname"
                    />
                    <label>Phone number:</label>
                    <input
                        type="text"
                        name="phone"
                        value={formData.phone}
                        onChange={handleChange}
                        placeholder="Enter your phone number"
                    />
                    <label>Email:</label>
                    <input
                        type="email"
                        name="email"
                        value={formData.email}
                        onChange={handleChange}
                        placeholder="Enter your email"
                    />
                    <label>Username:</label>
                    <input
                        type="text"
                        name="username"
                        value={formData.username}
                        onChange={handleChange}
                        placeholder="Enter your username"
                    />
                    <label>Password:</label>
                    <input
                        type="password"
                        name="password"
                        value={formData.password}
                        onChange={handleChange}
                        placeholder="Enter your password"
                    />
                    <label>Confirm password:</label>
                    <input
                        type="password"
                        name="confirmPassword"
                        value={formData.confirmPassword}
                        onChange={handleChange}
                        placeholder="Confirm your password"
                    />
                    <button onClick={handleSignup}>Let's go</button>
                </div>
            </div>
        </div>
    );
};

export default Signup;
