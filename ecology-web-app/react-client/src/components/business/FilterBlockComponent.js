import {Component} from "react";
import {BsFilter} from "react-icons/bs"
import axios from "axios";

export default class FilterBlockComponent extends Component {
    state = {
        isOpen: false,
        filters: [],
        trashMap: ["WASTE_PAPER", "PLASTIC", "GLASS", "METAL", "WOOD", "RUBBER", "POLYETHYLENE", "BOTTLE"]
    }
    componentDidMount() {

    }

    render() {
        if (this.state.isOpen) {
            return (
                <div className="filter-block">
                    <div className="head">
                        <div><span className="close-button" onClick={() => {
                            this.setState({
                                isOpen: false
                            })
                        }}>&times;</span></div>
                        <h4>Фильтры</h4>
                    </div>
                    <form className="filters">
                        <div className="form-check">
                            <input className="form-check-input" type="checkbox" value="" id="filter-waste-paper" onInput={(item) => {
                                this.state.filters[0] = item.target.checked;
                            }}/>
                            <label className="form-check-label" htmlFor="filter-waste-paper">
                                Макулатура
                            </label>
                        </div>
                        <div className="form-check">
                            <input className="form-check-input" type="checkbox" value="" id="filter-plastic" onInput={(item) => {
                                this.state.filters[1] = item.target.checked;
                            }}/>
                            <label className="form-check-label" htmlFor="filter-plastic">
                                Пластик
                            </label>
                        </div>
                        <div className="form-check">
                            <input className="form-check-input" type="checkbox" value="" id="filter-glass" onInput={(item) => {
                                this.state.filters[2] = item.target.checked;
                            }}/>
                            <label className="form-check-label" htmlFor="filter-glass">
                                Стекло
                            </label>
                        </div>
                        <div className="form-check">
                            <input className="form-check-input" type="checkbox" value="" id="filter-metal" onInput={(item) => {
                                this.state.filters[3] = item.target.checked;
                            }}/>
                            <label className="form-check-label" htmlFor="filter-metal">
                                Металл
                            </label>
                        </div>
                        <div className="form-check">
                            <input className="form-check-input" type="checkbox" value="" id="filter-wood" onInput={(item) => {
                                this.state.filters[4] = item.target.checked;
                            }}/>
                            <label className="form-check-label" htmlFor="filter-wood">
                                Дерево
                            </label>
                        </div>
                        <div className="form-check">
                            <input className="form-check-input" type="checkbox" value="" id="filter-rubber" onInput={(item) => {
                                this.state.filters[5] = item.target.checked;
                            }}/>
                            <label className="form-check-label" htmlFor="filter-rubber">
                                Резина
                            </label>
                        </div>
                        <div className="form-check">
                            <input className="form-check-input" type="checkbox" value="" id="filter-polyethylene" onInput={(item) => {
                                this.state.filters[6] = item.target.checked;
                            }}/>
                            <label className="form-check-label" htmlFor="filter-polyethylene">
                                Полиэтилен
                            </label>
                        </div>
                        <div className="form-check">
                            <input className="form-check-input" type="checkbox" value="" id="filter-bottle" onInput={(item) => {
                                this.state.filters[7] = item.target.checked;
                            }}/>
                            <label className="form-check-label" htmlFor="filter-bottle">
                                Бутылка ПЭТ
                            </label>
                        </div>
                        <div className="submit-filters">
                            <button type="button" className="btn btn-primary" onClick={() => {
                                let params = "";
                                let isFirst = true;
                                for (let i = 0; i < this.state.filters.length; i++) {
                                    if (this.state.filters[i]) {
                                        if (isFirst) {
                                            params += this.state.trashMap[i];
                                            isFirst = false;
                                        } else {
                                            params += "&trashTypes=" + this.state.trashMap[i];
                                        }
                                    }
                                }

                                axios.get('http://localhost:8080/trash-separating-places/params?trashTypes=' + params).then(res => {
                                    this.props.setPlacemarks(res.data);
                                    console.log(res);
                                }).catch(err => {

                                })
                            }}>Найти</button>
                        </div>
                    </form>
                </div>
            )
        }
        return (
            <div className="filter-button" onClick={() => {
                this.setState({
                    isOpen: true
                })
            }}>
                <BsFilter style={{
                    width: '50px',
                    height: '50px'
                }}/>
            </div>
        )
    }
}