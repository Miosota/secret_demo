// import React from 'react';
import "bootstrap/dist/css/bootstrap.min.css";
import './App.css';
import { Routes, Route } from 'react-router-dom';


import AppBar from './components/appbar.component';
import CreateSecretComponent from './components/createsecret.component';
import SecretComponent from "./components/secret.component";

function App() {
  return (
      <Routes>
        <Route path="*" element={<div className="App"><AppBar/><CreateSecretComponent /></div>} />
        <Route path="/secrets" element={<SecretComponent />}/>
      </Routes>
  );
}

export default App;
