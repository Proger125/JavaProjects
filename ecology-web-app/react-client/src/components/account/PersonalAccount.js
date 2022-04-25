import {Component} from "react";
import {Redirect} from "react-router-dom";

export default class PersonalAccount extends Component {
    state = {}

    componentDidMount() {
        if (this.props.user) {
            if (this.props.user.roles[0].name === "ROLE_USER") {
                this.setState({roleText: 'пользователя'});
            } else if (this.props.user.roles[0].name === "ROLE_ADMIN") {
                this.setState({roleText: 'администратора'})
            }
        }
    }

    render() {
        if (!this.props.user) {
            return <Redirect to={'/'} />
        }
        return (
            <div className="account-wrapper">
                <div className="account-inner">
                    <div className="account-header">
                        <h2>Личный кабинет {this.state.roleText}</h2>
                    </div>
                    <div className="account-info">
                        <div className="account-info-item">
                            <h3>Имя пользователя:</h3>
                            <h3 className="account-info-property">{this.props.user.firstName + " " + this.props.user.lastName}</h3>
                        </div>
                        <div className="account-info-item">
                            <h3>Адрес эл. почты:</h3>
                            <h3 className="account-info-property">{this.props.user.email}</h3>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}