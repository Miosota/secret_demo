import React from "react";
import NavBar from "react-bootstrap/Navbar";
import ToolBar from "react-bootstrap/ButtonToolbar";


export default function AppBar() {
    return (
        <div className="appbar">
          <NavBar>
            <ToolBar>
                <h1>Spring Boot React Full Stack Application</h1>
            </ToolBar>
          </NavBar>
        </div>
      );
}