import React, { Component, ChangeEvent } from "react";
import {useParams } from "react-router-dom";

import Form from 'react-bootstrap/Form';
import Container from 'react-bootstrap/Container';

// interface RouterProps {
//     id: string;
// }

// let {id} = useParams();

// type State = {
//     name: string,
// }

// const UserComponent: React.FC = () => {

// }

export default function User() {

    return (
        <Container>
            <Form.Label htmlFor="userName">User name</Form.Label>
            <Form.Control
                type="string"
                id="userName"
            />
            <Form.Label htmlFor="secretText">Secret</Form.Label>
            <Form.Control
                type="string"
                id="secretText"
            />
        </Container>
    );
}

