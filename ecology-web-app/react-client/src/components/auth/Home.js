import {Component} from "react";
import {Clusterer, Map, Placemark, YMaps} from "react-yandex-maps";
import axios from "axios";

export default class Home extends Component {

    state = {
        placemarks: [],
        mapWidth: "100%",
        mapHeight: "calc(100vh - 57px)"
    }

    componentDidMount() {
        axios.get('http://localhost:8080/trash-separating-places').then(res => {
            this.props.setPlacemarks(res.data);
        }).catch(err => {

        })
    }


    render() {

        const { placemarks } = this.state;

        return (
            <div className="map-container">
                <YMaps enterprise query={{ apikey: 'c5ca1e33-fac1-4219-b656-9a943917dd18' }}>
                    <Map defaultState={
                        {
                            center: [53.904278, 27.434261],
                            zoom: 9
                        }
                    } modules={
                        ["geolocation", "geocode"]
                    }  width={this.state.mapWidth} height={this.state.mapHeight}>
                        <Clusterer>
                            {
                                this.props.placemarks.map(n => (
                                    <Placemark geometry={[n.latitude, n.longitude]}
                                                onClick={() => {
                                        this.props.setTrashSeparatingPlace(n);
                                    }}/>
                                ))}
                        </Clusterer>
                    </Map>
                </YMaps>
            </div>

        )
    }
}