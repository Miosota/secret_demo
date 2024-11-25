import React, { Component, ChangeEvent, useState} from "react";

// const [secretId, setSecretId] = useState<number>();

    // function geURLParam(): number | null{
    //     const queryParams = new URLSearchParams(location.search);
    //     const param = queryParams.get('id');
    //     const secretId = param !== null ? parseInt(param) : 0;
    //     // setSecretId(parseInt(param));
    //     return secretId;
    // }

export default function SecretComponent() {

    const [secretText, setSecretText] = useState<string>('');
    // const [secretId, setSecretId] = useState<number>();

    const urlString = window.location.search;
    const urlParams = new URLSearchParams(urlString);
    const param = urlParams.get('id');
    const secretId = param !== null ? parseInt(param) : 0;
    if(secretId !== 0) {

        fetch("http://localhost:8090/secrets/secretid="+secretId,{
            method: "GET",
            headers:{"Content-Type":"application/json"}
        }).then((response) => response.text())
            .then((responseText) => {

            console.log(responseText);

        })
    }

    return (
            <>

            </>
    );



}

