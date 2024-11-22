import React from 'react';
import "bootstrap/dist/css/bootstrap.min.css";
import './App.css';

import AppBar from './components/appbar.component';
import User from './components/user.component';

// import UserComponent from "./components/user.component";
// import SecretComponent from "./components/secret.component";

function App() {
  return (
    <div className="App">      
      <h1>Hi, people</h1>
      <AppBar/>
      <User/>
    </div>
  );
}

export default App;
