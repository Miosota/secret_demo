import React, { Component, ChangeEvent, useState} from "react";
import {useParams } from "react-router-dom";

import Form from 'react-bootstrap/Form';
import Container from 'react-bootstrap/Container';
import Button from 'react-bootstrap/Button';
import User from "./createsecret.component";
import IUserData from "../types/user.type"

export default function Secret() {

    const [user, setUser] = useState<IUserData>();
    const [secretText, setSecretText] = useState<string>('');
    const [timesToView, setTimesToView] = useState<number>();

    // const handleClick=(e: React.FormEvent<HTMLButtonElement>)=> {
        // e.preventDefault();
        // const user={name};
        // console.log(user);
        // fetch("http://localhost:8090/users/createUser",{
        //     method: "POST",
        //     headers:{"Content-Type":"application/json"},
        //     body:JSON.stringify(user)
        // }).then(()=>{
        //     console.log("New user added");
        // })

        // fetch("http://localhost:8090/secrets/createSecret",{
        //     method: "POST",
        //     headers:{"Content-Type":"application/json"},
        //     body:JSON.stringify(secret)
        // }).then(()=>{
        //     console.log("New secret added");
        // })


    // }

    return (
            <>
                {/* <Form.Group className="secretText">
                    <Form.Label>Secret text</Form.Label>
                    <Form.Control type="text" placeholder="Secret text"
                    value={secretText}
                    onChange={(e)=>setSecretText(e.target.value)}/>
                </Form.Group>
                <Form.Group className="timesToView">
                    <Form.Label>Amount of users to show the secret</Form.Label>
                    <Form.Control type="text" placeholder="Secret text"
                    value={timesToView}
                    onChange={(e)=>setTimesToView(e.target.value)}/>
                </Form.Group> */}
            </>
    );



}

