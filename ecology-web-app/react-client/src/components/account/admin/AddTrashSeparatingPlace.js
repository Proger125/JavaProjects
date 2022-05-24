import {Component} from "react";
import axios from "axios";
import {Redirect} from "react-router-dom";

export default class AddTrashSeparatingPlace extends Component {
    state = {
        trashTypes: [],
        trashMap: ["WASTE_PAPER", "PLASTIC", "GLASS", "METAL", "WOOD", "RUBBER", "POLYETHYLENE", "BOTTLE"]
    }
    handleSubmit = e => {
        e.preventDefault();
        axios.get('https://geocode-maps.yandex.ru/1.x/?apikey=c5ca1e33-fac1-4219-b656-9a943917dd18&geocode=' + this.address, {
            headers: {
                'content-type': "application/json"
            }
        }).then(res => {
            let startIndex = res.data.indexOf('<pos>')
            let coordsStr = res.data.substring(startIndex + 5, startIndex + 23);
            let coords = coordsStr.split(' ');
            let workingHours = this.startTime + "-" + this.endTime;
            let trashTypes = [];
            for (let i = 0; i < this.state.trashTypes.length; i++) {
                if (this.state.trashTypes[i]) {
                    trashTypes.push(this.state.trashMap[i]);
                }
            }
            const data = {
                name: this.name,
                description: this.description,
                address: this.address,
                latitude: coords[1],
                longitude: coords[0],
                phoneNumber: this.phoneNumber,
                workingHours: workingHours,
                trashTypes: trashTypes
            }
            console.log(data);
            axios.post('http://localhost:8080/trash-separating-places', data).then(res => {
                this.setState({
                    needToRedirect: true
                })
            })
        })
    }
    render() {
        if (this.state.needToRedirect) {
            this.setState({
                needToRedirect: false
            })
            return (<Redirect to={'/account'}/>);
        }
        return (
            <div className="form-wrapper">
                <div className="form-inner">
                    <form className="custom-form" onSubmit={this.handleSubmit}>
                        <h3>Место сбора мусора</h3>
                        <div className="form-group">
                            <label htmlFor="">Название</label>
                            <input type="text" className="form-control" placeholder="Название"
                                   onChange={e => this.name = e.target.value}/>
                        </div>
                        <div className="form-group">
                            <label htmlFor="">Адрес</label>
                            <input type="text" className="form-control" placeholder="Адрес"
                                   onChange={e => this.address = e.target.value}/>
                        </div>
                        <div className="form-group">
                            <label htmlFor="">Контакты</label>
                            <input type="text" className="form-control" placeholder="+375(__) ___ - __ - __"
                                   onChange={e => this.phoneNumber = e.target.value}/>
                        </div>
                        <div className="form-group">
                            <label htmlFor="">Время работы</label>
                            <br/>
                            <label htmlFor="">Начало:</label>
                            <input type="time" className="form-time-control"
                                   onChange={e => this.startTime = e.target.value}/>
                            <label htmlFor="" id="end-time-label">Конец:</label>
                            <input type="time" className="form-time-control"
                                   onChange={e => this.endTime = e.target.value}/>
                        </div>
                        <div className="form-group">
                            <label htmlFor="">Дополнительная информация:</label>
                            <br/>
                            <textarea name="description-area" id="" cols="40" rows="10"
                                      onChange={e => this.description = e.target.value}/>
                        </div>
                        <div className="form-group">
                            <label htmlFor="">Виды собираемых отходов:</label>
                            <div className="form-check">
                                <input className="form-check-input" type="checkbox" value="" id="filter-waste-paper" onInput={(item) => {
                                    this.state.trashTypes[0] = item.target.checked;
                                }}/>
                                <label className="form-check-label" htmlFor="filter-waste-paper">
                                    Макулатура
                                </label>
                            </div>
                            <div className="form-check">
                                <input className="form-check-input" type="checkbox" value="" id="filter-plastic" onInput={(item) => {
                                    this.state.trashTypes[1] = item.target.checked;
                                }}/>
                                <label className="form-check-label" htmlFor="filter-plastic">
                                    Пластик
                                </label>
                            </div>
                            <div className="form-check">
                                <input className="form-check-input" type="checkbox" value="" id="filter-glass" onInput={(item) => {
                                    this.state.trashTypes[2] = item.target.checked;
                                }}/>
                                <label className="form-check-label" htmlFor="filter-glass">
                                    Стекло
                                </label>
                            </div>
                            <div className="form-check">
                                <input className="form-check-input" type="checkbox" value="" id="filter-metal" onInput={(item) => {
                                    this.state.trashTypes[3] = item.target.checked;
                                }}/>
                                <label className="form-check-label" htmlFor="filter-metal">
                                    Металл
                                </label>
                            </div>
                            <div className="form-check">
                                <input className="form-check-input" type="checkbox" value="" id="filter-wood" onInput={(item) => {
                                    this.state.trashTypes[4] = item.target.checked;
                                }}/>
                                <label className="form-check-label" htmlFor="filter-wood">
                                    Дерево
                                </label>
                            </div>
                            <div className="form-check">
                                <input className="form-check-input" type="checkbox" value="" id="filter-rubber" onInput={(item) => {
                                    this.state.trashTypes[5] = item.target.checked;
                                }}/>
                                <label className="form-check-label" htmlFor="filter-rubber">
                                    Резина
                                </label>
                            </div>
                            <div className="form-check">
                                <input className="form-check-input" type="checkbox" value="" id="filter-polyethylene" onInput={(item) => {
                                    this.state.trashTypes[6] = item.target.checked;
                                }}/>
                                <label className="form-check-label" htmlFor="filter-polyethylene">
                                    Полиэтилен
                                </label>
                            </div>
                            <div className="form-check">
                                <input className="form-check-input" type="checkbox" value="" id="filter-bottle" onInput={(item) => {
                                    this.state.trashTypes[7] = item.target.checked;
                                }}/>
                                <label className="form-check-label" htmlFor="filter-bottle">
                                    Бутылка ПЭТ
                                </label>
                            </div>
                        </div>
                        <div className="form-btn">
                            <button className="btn btn-primary btn-block">Добавить</button>
                        </div>
                    </form>
                </div>
            </div>
        )
    }
}