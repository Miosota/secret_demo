import { Component, ChangeEvent } from "react";
import {useParams } from "react-router-dom";

interface RouterProps {
    id: string;
}

let {id} = useParams();

type State = {
    name: string,
}

export default class UserComponent extends Component<State> {
    
}