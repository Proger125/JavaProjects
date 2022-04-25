import {Component} from "react";
import {Link} from "react-router-dom";

export default class Navigation extends Component {

    handleLogOut = () => {
        localStorage.clear();
        this.props.setUser(null);
    }

    render() {
        let navigationItems;
        if (this.props.user) {
            if (this.props.user.roles[0].name === "ROLE_USER") {
                navigationItems = (
                    <ul className="navbar-nav ms-auto">
                        <li className="nav-item">
                            <span className="nav-link">{this.props.user.firstName + " " + this.props.user.lastName}</span>
                        </li>
                        <li className="nav-item">
                            <Link className="nav-link" to="/" onClick={this.handleLogOut}>LogOut</Link>
                        </li>
                    </ul>
                );
            }
        } else {
            navigationItems = (
                <ul className="navbar-nav ms-auto">
                    <li className="nav-item">
                        <Link className="nav-link" to="/login">Login</Link>
                    </li>
                    <li className="nav-item">
                        <Link className="nav-link" to="/register">Sign Up</Link>
                    </li>
                </ul>
            )
        }
        return (
            <nav className="navbar navbar-expand navbar-light fixed-top">
                <div className="container">
                    <Link className="navbar-brand" to="/">Home</Link>
                    <div className="collapse navbar-collapse">
                        {navigationItems}
                    </div>
                </div>
            </nav>
        )
    }
}