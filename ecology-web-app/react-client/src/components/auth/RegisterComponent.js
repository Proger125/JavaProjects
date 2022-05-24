import {Component} from "react";
import axios from "axios";

export default class RegisterComponent extends Component {

    handleSubmit = e => {
        e.preventDefault();
        const data = {
            login: this.userName,
            firstName: this.firstName,
            lastName: this.lastName,
            email: this.email,
            password: this.password,
            confirmPassword: this.confirmPassword
        }
        axios.post('registration', data).then(
            res => {
                console.log(res);
            }
        ).catch(
            err => {
                console.log(err);
            }
        )
    };

    render() {
        return (
            <div className="form-wrapper">
                <div className="form-inner">
                    <form className="custom-form" onSubmit={this.handleSubmit}>
                        <h3>Sign Up</h3>
                        <div className="form-group">
                            <label htmlFor="">Username</label>
                            <input type="text" className="form-control" placeholder="Username"
                                   onChange={e => this.userName = e.target.value}/>
                        </div>
                        <div className="form-group">
                            <label htmlFor="">FirstName</label>
                            <input type="text" className="form-control" placeholder="First Name"
                                   onChange={e => this.firstName = e.target.value}/>
                        </div>
                        <div className="form-group">
                            <label htmlFor="">LastName</label>
                            <input type="text" className="form-control" placeholder="Last Name"
                                   onChange={e => this.lastName = e.target.value}/>
                        </div>
                        <div className="form-group">
                            <label htmlFor="">Email</label>
                            <input type="email" className="form-control" placeholder="Email"
                                   onChange={e => this.email = e.target.value}/>
                        </div>
                        <div className="form-group">
                            <label htmlFor="">Password</label>
                            <input type="password" className="form-control" placeholder="Password"
                                   onChange={e => this.password = e.target.value}/>
                        </div>
                        <div className="form-group">
                            <label htmlFor="">Confirm password</label>
                            <input type="password" className="form-control" placeholder="Confirm password"
                                   onChange={e => this.confirmPassword = e.target.value}/>
                        </div>
                        <div className="form-btn">
                            <button className="btn btn-primary btn-block">Sign Up</button>
                        </div>
                    </form>
                </div>
            </div>
        )
    }
}