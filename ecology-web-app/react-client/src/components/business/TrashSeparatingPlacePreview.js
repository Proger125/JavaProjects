import {Component} from "react";
import {Link} from "react-router-dom";

export default class TrashSeparatingPlacePreview extends Component {

    render() {
        if (!this.props.place) {
            return <div/>
        }

        return (
            <div className="place-preview">
                <div className="place-preview-block head">
                    <div><span className="close-button" onClick={() => {
                        this.props.setTrashSeparatingPlace(null);
                    }}>&times;</span></div>
                    <h3>{this.props.place.name}</h3>
                </div>
                <hr/>
                <div className="place-preview-block">
                    <h5>Адрес</h5>
                    <p>{this.props.place.address}</p>
                </div>
                <div className="place-preview-block">
                    <h5>Время работы</h5>
                    <p>{this.props.place.workingHours}</p>
                </div>
                <div className="place-preview-block">
                    <h5>Контакты</h5>
                    <p>{this.props.place.phoneNumber}</p>
                </div>
                <div className="place-preview-block">
                    <p><Link to={`/trash-separating-places/${this.props.place.id}`} >Подробнее...</Link></p>
                </div>
            </div>
        )
    }
}