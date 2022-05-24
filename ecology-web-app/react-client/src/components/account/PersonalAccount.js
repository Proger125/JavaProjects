import {Component} from "react";
import {Link, Redirect} from "react-router-dom";
import axios from "axios";

export default class PersonalAccount extends Component {
    state = {}

    componentDidMount() {
        if (this.props.user) {
            if (this.props.user.roles[0].name === "ROLE_USER") {
                this.setState({roleText: 'пользователя'});
            } else if (this.props.user.roles[0].name === "ROLE_ADMIN") {
                this.setState({roleText: 'администратора'})
                axios.get('http://localhost:8080/trash-separating-places').then(res => {
                    this.setState({
                        places: res.data
                    });
                }).catch(err => {

                })
            }
        }
    }

    render() {
        if (!this.props.user) {
            return <Redirect to={'/'} />
        }
        let adminBlock;
        if (this.props.user.roles[0].name === "ROLE_ADMIN" && this.state.places) {
            let wrapper = document.getElementsByClassName('wrapper-inner')[0];
            wrapper.style['margin-top'] = "250px";
            adminBlock = (
                <div className="admin-block-wrapper">
                    <div className="places-table-header">
                        <h2>Места раздельного сбора мусора</h2>
                    </div>
                    <div className="places-table-wrapper">
                        <table className="places-table" border="1" cellPadding="10">
                            <tr>
                                <th>Название организации</th>
                                <th>Адрес</th>
                                <th>Контакты</th>
                                <th>Время работы</th>
                            </tr>
                            {this.state.places.map(place => (
                                <tr>
                                    <td>{place.name}</td>
                                    <td>{place.address}</td>
                                    <td>{place.phoneNumber}</td>
                                    <td>{place.workingHours}</td>
                                </tr>
                            ))}
                        </table>
                    </div>
                    <div className="add-place-wrapper">
                        <Link className="btn btn-primary" to="/trash-separating-places">Добавить</Link>
                    </div>
                </div>
            );
        }
        return (
            <div className="wrapper">
                <div className="wrapper-inner">
                    <div className="account-header">
                        <h2>Личный кабинет {this.state.roleText}</h2>
                    </div>
                    <div className="account-info">
                        <div className="info-item">
                            <h3>Имя пользователя:</h3>
                            <h3 className="info-property">{this.props.user.firstName + " " + this.props.user.lastName}</h3>
                        </div>
                        <div className="info-item">
                            <h3>Адрес эл. почты:</h3>
                            <h3 className="info-property">{this.props.user.email}</h3>
                        </div>
                    </div>
                    {adminBlock}
                </div>
            </div>
        )
    }
}