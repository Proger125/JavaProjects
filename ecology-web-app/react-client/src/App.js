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
import TrashSeparatingPlace from "./components/business/TrashSeparatingPlace";
import TrashSeparatingPlacePreview from "./components/business/TrashSeparatingPlacePreview";
import FilterBlockComponent from "./components/business/FilterBlockComponent";
import AddTrashSeparatingPlace from "./components/account/admin/AddTrashSeparatingPlace";

export default class App extends Component{
    state = {
        mapWidth: "100%",
        placemarks: []
    }

    setUser = user => {
        this.setState({
            user: user
        });
    }

    setTrashSeparatingPlace = place => {
        this.setState({
            trashSeparatingPlace: place
        })
    }

    setMapWidth = width => {
        this.setState({
            mapWidth: width
        })
    }

    setPlacemarks = placemarks => {
        this.state.placemarks = [];
        placemarks.forEach(placemark => {
            this.setState({
                placemarks: [...this.state.placemarks, placemark]
            })
        })
    }

    render() {
        return (
            <BrowserRouter>
                <div className="App">
                    <Navigation user={this.state.user} setUser={this.setUser}/>
                    <Switch>
                        <Route exact path="/">
                            <div className="home-wrapper">
                                <TrashSeparatingPlacePreview place={this.state.trashSeparatingPlace} setTrashSeparatingPlace={this.setTrashSeparatingPlace}/>
                                <Home setTrashSeparatingPlace={this.setTrashSeparatingPlace} setPlacemarks={this.setPlacemarks} placemarks={this.state.placemarks} />
                                <FilterBlockComponent setPlacemarks={this.setPlacemarks}/>
                            </div>
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
                        <Route path={"/trash-separating-places/:id"} component={TrashSeparatingPlace} />
                        <Route path={"/trash-separating-places"}>
                            <AddTrashSeparatingPlace/>
                        </Route>
                    </Switch>
                </div>
            </BrowserRouter>

        );
    }
}

