import React, { Component, ChangeEvent, useState} from "react";
import { Container } from "react-bootstrap";


export default function SecretComponent() {

    const [secretText, setSecretText] = useState<string>('');
    // const [secretId, setSecretId] = useState<number>();

    const urlString = window.location.search;
    const urlParams = new URLSearchParams(urlString);
    const param = urlParams.get('secretid');
    const secretId = param !== null ? parseInt(param) : 0;
    console.log("///////////////////////////");

    if(secretId !== 0) {

        fetch("http://localhost:8090/secrets/secretid="+secretId,{
            method: "GET",
            headers:{"Content-Type":"application/json"}
        }).then((response) => response.text())
            .then((responseText) => {
            JSON.parse(responseText, (key, value) => {
                if (key === "secretText" ) {
                    setSecretText(value);
                    return value;
                }
                return value;
                });

            console.log("=========================================");
            console.log({secretText});      
            createHTMLObject(secretText);
            

        });
    }

    function createHTMLObject(secretText:string) {
        const parentObject = document.getElementsByClassName('container')[0];
        const childObject = document.createElement('div');
        childObject.innerHTML = `
            <h2>Your friend send some information for you: </h2>
            <h3>`+secretText+`</h3>
        `;
        parentObject.appendChild(childObject);
    }

    return (
            <Container>
                <div>Hi</div>
            </Container>
    );

}

