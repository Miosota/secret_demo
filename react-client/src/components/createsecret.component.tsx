import React, { useState} from "react";

import Form from 'react-bootstrap/Form';
import Container from 'react-bootstrap/Container';
import Button from 'react-bootstrap/Button';

export default function CreateSecretComponent() {

    const [userName, setName] = useState<string>('');
    const [secretText, setSecretText] = useState<string>('');
    const [timesToView, setTimesToView] = useState<number>();
    const [linkToShare, setLinkToShare] = useState<string>();
console.log("-----------------------");
    const handleClick=(e: React.FormEvent<HTMLButtonElement>)=> {
        e.preventDefault();
        const user={userName};
        console.log(user);
        console.log({userName});console.log({secretText});console.log({timesToView});
        fetch("http://localhost:8090/secret_demo/createobjects",{
            method: "POST",
            headers:{"Content-Type":"application/json"},
            body:JSON.stringify({userName, secretText, timesToView})
        }).then((response) => response.text())
            .then((responseText) => {
                setLinkToShare(responseText);
                console.log(responseText);
        })
          
    }

    return (
        <Container>
            <Form>
                <Form.Group className="userName">
                    <Form.Label>User name</Form.Label>
                    <Form.Control type="text" placeholder="User name" 
                    value={userName}
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
            <h1 className="link_to_share">Share with your friends: <a href={linkToShare}>{linkToShare}</a></h1>
        </Container>
    );
}

