import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';  // Replace Switch with Routes
import Login from './components/Auth/Login';
import Signup from './components/Auth/Signup';

const App = () => {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<Login />} />
                <Route path="/signup" element={<Signup />} />
            </Routes>
        </Router>
    );
};

export default App;
