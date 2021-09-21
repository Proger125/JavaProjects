package edu.bsu.ds_02.controller;

import edu.bsu.ds_02.model.Users;
import edu.bsu.ds_02.model.UtilModel;

public abstract class MainController {
    protected Users users;
    protected UtilModel utilModel;

    public MainController(Users users, UtilModel utilModel){
        this.users = users;
        this.utilModel = utilModel;
    }
}
