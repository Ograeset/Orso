import logo from './logo.svg';
import './App.css';
import {Component} from "react";

class App extends Component {
  state = {
    customers: []
  };

  async componentDidMount(){
    const response = await fetch ('/customer/getAllCustomers');
    const body = await response.json();
    this.setState({customers: body});
  }

  render(){
    const {customers} = this.state;
    return(
        <div className="App">
          <header className="App-header">
            <img src={logo} className="App-logo" alt="logo"/>
            <div className="App-intro">
              <h2>Customers</h2>
              {customers.map(customer =>
              <div key={customer.id}>
                {customer.name} ({customer.email})
              </div>
                )}
            </div>
          </header>
        </div>
    );
  }
}

export default App;
