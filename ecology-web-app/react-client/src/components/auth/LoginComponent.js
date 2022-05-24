import {Component} from "react";
import axios from "axios";
import {Redirect} from "react-router-dom";

export default class LoginComponent extends Component {

    state = {}

    handleSubmit = e => {
        e.preventDefault();
        const data = {
            login: this.userName,
            password: this.password,
        }
        axios.post('login', data).then(
            res => {
                this.props.setUser(res.data);
                localStorage.setItem('token', res.data.token);
                this.setState({
                    loggedIn: true
                })
            }
        ).catch(
            err => {

            }
        )
    };
    render() {
        if (this.state.loggedIn) {
            return <Redirect to={'/account'} />
        }
        return (
            <div className="form-wrapper">
                <div className="form-inner">
                    <form className="custom-form" onSubmit={this.handleSubmit}>
                        <h3>Login</h3>
                        <div className="form-group">
                            <label htmlFor="">Username</label>
                            <input type="text" className="form-control" placeholder="Username"
                                   onChange={e => this.userName = e.target.value}/>
                        </div>
                        <div className="form-group">
                            <label htmlFor="">Password</label>
                            <input type="password" className="form-control" placeholder="Password"
                                   onChange={e => this.password = e.target.value}/>
                        </div>
                        <div className="form-btn">
                            <button className="btn btn-primary btn-block">Login</button>
                        </div>
                    </form>
                </div>
            </div>

        )
    }
}