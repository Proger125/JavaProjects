import {Component} from "react";
import {Clusterer, Map, Placemark, YMaps} from "react-yandex-maps";
import axios from "axios";

export default class Home extends Component {

    state = {
        placemarks: []
    }

    componentDidMount() {
        axios.get('http://localhost:8080/trash-separating-places').then(res => {
            res.data.forEach(element => {
                this.setState(state => ({
                    placemarks: [...this.state.placemarks, [element.latitude, element.longitude]]
                }))
            });
            console.log(this.state.placemarks);
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
                    }  width="100%" height="100%">
                        <Clusterer>
                            {
                                placemarks.map(n => (
                                    <Placemark geometry={n} />
                                ))}
                        </Clusterer>
                    </Map>
                </YMaps>
            </div>

        )
    }
}