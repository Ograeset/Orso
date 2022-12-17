import './App.css';
import React, {Component} from "react";
import Home from './Home';
import{BrowserRouter as Router, Route, Switch} from "react-router-dom";
import CustomerList from './CustomerList';
import CustomerEdit from "./CustomerEdit";

class App extends Component {
 render(){
   return (
       <Router>
         <Switch>
           <Route path='/' exact={true} component={Home}/>
           <Route path='/guests' exact={true} component={CustomerList}/>
           <Route path='/guests/:id' component={CustomerEdit}/>
         </Switch>
       </Router>
    )
  }
}
export default App;
