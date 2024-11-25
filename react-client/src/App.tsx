import React from 'react';
import "bootstrap/dist/css/bootstrap.min.css";
import './App.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';


import AppBar from './components/appbar.component';
import CreateSecretComponent from './components/createsecret.component';

import SecretComponent from "./components/secret.component";

function App() {
  return (
    // <div className="App">      
    //   <AppBar/>
    //   <CreateSecretComponent/>
    // </div>
    // <BrowserRouter>
      <Routes>
        <Route path="*" element={<div className="App"><AppBar/><CreateSecretComponent /></div>} />
        <Route path="secrets" element={<SecretComponent />} />
      </Routes>
    // </BrowserRouter>
  );
}

export default App;
