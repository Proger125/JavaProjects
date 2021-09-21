package edu.bsu.ds_02.controller;

import edu.bsu.ds_02.model.Users;
import edu.bsu.ds_02.view.main.CustomFrame;

public abstract class FrameController {
    protected Users users;
    protected CustomFrame frame;

    public FrameController(Users users, CustomFrame frame) {
        this.users = users;
        this.frame = frame;
    }
}
