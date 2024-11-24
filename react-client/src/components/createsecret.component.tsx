import React, { Component, ChangeEvent, useState} from "react";
import {useParams } from "react-router-dom";

import Form from 'react-bootstrap/Form';
import Container from 'react-bootstrap/Container';
import Button from 'react-bootstrap/Button';

export default function CreateSecretComponent() {

    const [name, setName] = useState<string>('');
    const [secretText, setSecretText] = useState<string>('');
    const [timesToView, setTimesToView] = useState<number>();

    const handleClick=(e: React.FormEvent<HTMLButtonElement>)=> {
        e.preventDefault();
        const user={name};
        console.log(user);
        fetch("http://localhost:8090/secret_demo/createobjects",{
            method: "POST",
            headers:{"Content-Type":"application/json"},
            body:JSON.stringify({name, secretText, timesToView})
        }).then((response) => response.text())
            .then((responseText) => {
          console.log(responseText);
        })
        // fetch("http://localhost:8090/secrets/createSecret",{
        // method: "POST",
        // headers:{"Content-Type":"application/json"},
        // body:JSON.stringify({secretText,timesToView})
        // }).then(()=>{
        //     console.log("New secret added");
        // })

    
    }

    return (
        <Container>
            <Form>
                <Form.Group className="userName">
                    <Form.Label>User name</Form.Label>
                    <Form.Control type="text" placeholder="User name" 
                    value={name}
                    onChange={(e)=>setName(e.target.value)}
                    />
                </Form.Group>
                <Form.Group className="secretText">
                    <Form.Label>Secret text</Form.Label>
                    <Form.Control type="text" placeholder="Secret text"
                    value={secretText}
                    onChange={(e)=>setSecretText(e.target.value)}
                    />
                </Form.Group>
                <Form.Group className="timesToView">
                    <Form.Label>Amount of users to show the secret</Form.Label>
                    <Form.Control type="text" placeholder="Secret text"
                    value={timesToView}
                    onChange={(e)=>setTimesToView(parseInt(e.target.value))}/>
                </Form.Group>
                <Button variant="primary" onClick={handleClick}>Generate Link</Button>
            </Form>
        </Container>
    );
}

