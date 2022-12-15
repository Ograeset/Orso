import React, {Component} from "react";
import { Link, withRouter} from "react-router-dom";
import { Button,Container, Form, FormGroup, Input, Label } from "reactstrap";
import AppNavBar from '/.AppNavBar';
class CustomerEdit extends Component{
    emptyItem ={
        name:'',
        email:''
    };

    constructor(props) {
        super(props);
        this.state = {
            item: this.emptyItem
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    async componentDidMount(){
        if (this.props.match.params.id !== 'new'){
            const customer = await (await
            fetch('/customers/${this.props.match.params.id}')).json();
            this.setState({item: customer});
        }
    }

    handleChange(event){
        const target = event.target;
        const value = target.value;
        const name = target.name;
        let item = {...this.state.item};
        item[name] = value;
        this.setState({item});
    }

    async handleSubmit(event){
        event.preventDefault();
        const {item} = this.state;

        await fetch('/clients' + (item.id ? '/' + item.id : ''), {
            method: (item.id) ? 'PUT' : 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(item),
        });
        this.props.history.push('/customers');
    }
}
export default withRouter(CustomerEdit);