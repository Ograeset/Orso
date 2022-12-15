import React, {Component} from "react";
import { Button, ButtonGroup, Container, Table} from "reactstrap";
import AppNavbar from './AppNavbar';
import {Link} from 'react-router-dom';

class CustomerList extends Component{
    constructor(props) {
        super(props);
        this.state = {customers:[]};
        this.remove=this.remove.bind(this);
    }

    componentDidMount() {
        fetch('/clients')
            .then(response => response.json())
            .then(data => this.setState({customers: data}));
    }
}
export default CustomerList;