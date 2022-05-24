import {Component} from "react";
import axios from "axios";

export default class TrashSeparatingPlace extends Component {
    state = {
        price: null
    }
    componentDidMount() {
        axios.get('http://localhost:8080/trash-separating-places/' + this.props.match.params.id).then(res => {
            if (!res.data.description) {
                res.data.description = "Данная информация отсутствует";
            }
            this.setState({
                place: res.data
            })
        }).catch(err => {

        })
    }

    render() {
        if (this.state.place) {
            let prices;
            if (this.state.place.prices) {

            } else {
                prices = (
                    <h4>Данная информация отсутствует</h4>
                )
            }
            return (
                <div className="wrapper">
                    <div className="wrapper-inner trash-place-inner">
                        <div className="place-header">
                            <h2>{this.state.place.name}</h2>
                        </div>
                        <div className="info-item">
                            <h3>Адрес:</h3>
                            <h3 className="info-property">{this.state.place.address}</h3>
                        </div>
                        <div className="info-item">
                            <h3>Время работы:</h3>
                            <h3 className="info-property">{this.state.place.workingHours}</h3>
                        </div>
                        <div className="info-item">
                            <h3>Контакты:</h3>
                            <h3 className="info-property">{this.state.place.phoneNumber}</h3>
                        </div>
                        <div className="info-item">
                            <h3>Дополнительная информация:</h3>
                            <h3 className="info-property">{this.state.place.description}</h3>
                        </div>
                        <div className="price-item">
                            <h3>Цены</h3>
                            {prices}
                        </div>
                    </div>
                </div>
            );
        }
    }
}