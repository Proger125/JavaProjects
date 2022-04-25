import './App.css';
import '../node_modules/bootstrap/dist/css/bootstrap-reboot.min.css'
import '../node_modules/bootstrap/dist/css/bootstrap.min.css'
import Home from "./components/auth/Home";
import Navigation from "./components/Navigation";
import LoginComponent from "./components/auth/LoginComponent";
import {BrowserRouter, Route, Switch} from "react-router-dom";
import RegisterComponent from "./components/auth/RegisterComponent";
import {Component} from "react";
import PersonalAccount from "./components/account/PersonalAccount";

export default class App extends Component{
    state = {}

    setUser = user => {
        this.setState({
            user: user
        });
    }
    render() {
        return (
            <BrowserRouter>
                <div className="App">
                    <Navigation user={this.state.user} setUser={this.setUser}/>
                    <Switch>
                        <Route exact path="/">
                            <Home />
                        </Route>
                        <Route path="/login">
                            <LoginComponent setUser={this.setUser}/>
                        </Route>
                        <Route path="/register">
                            <RegisterComponent/>
                        </Route>
                        <Route path={"/account"}>
                            <PersonalAccount user={this.state.user}/>
                        </Route>
                    </Switch>
                </div>
            </BrowserRouter>

        );
    }
}

