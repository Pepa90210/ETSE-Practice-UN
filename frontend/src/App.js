import logo from './logo.svg';
import './App.css';
import LoginPage from './components/LoginPage';
import HomePage from './components/HomePage';
// import { Login } from './Login';
import React from 'react'
import { Router, Route, Routes } from 'react-router-dom';

function App() {
  return (
    <div className="App">
        <Routes>
          <Route path='/' element={ <LoginPage /> } />
          <Route path='/homepage' element={ <HomePage /> } />
        </Routes>
    </div>
  );
}

export default App;
