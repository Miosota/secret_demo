import  {useState} from "react";
import { Container } from "react-bootstrap";


export default function SecretComponent() {
    let secretText = "";
    const urlString = window.location.search;
    const urlParams = new URLSearchParams(urlString);
    const param = urlParams.get('secretid');
    const secretId = param !== null ? parseInt(param) : 0;

    console.log('secret component running');
    
    if(secretId !== 0) {

        fetch("http://localhost:8090/secrets/secretid="+secretId, {
            method: "GET",
            headers:{"Content-Type":"application/json"}
        }).then((response) => response.text())
            .then((responseText) => {
            JSON.parse(responseText, (key, value) => {
                if (key === "secretText" ) {
                    secretText = value;
                }
                });

            console.log(responseText);
            console.log(secretText);     
            const parentObject = document.getElementsByClassName('container')[0];
            const childObject = document.createElement('div');
            childObject.innerHTML = `
                <h2>Your friend send some information for you: </h2>
                <h3>`+secretText+`</h3>
            `;
            parentObject.appendChild(childObject); 
           
        })
    }

    return (
            <Container>
            </Container>
    );

}

