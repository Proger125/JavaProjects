import React from 'react';
import ReactDOM from 'react-dom';
import App from "./App";
import './index.css'
import axios from "axios";

axios.defaults.baseURL = 'http://localhost:8080/auth/';
axios.defaults.headers['Authorization'] = 'Bearer ' + localStorage.getItem('token');

ReactDOM.render(
    <App />,
    document.getElementById('root')
);