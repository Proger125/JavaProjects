package edu.bsu.ds_01.controller;

import edu.bsu.ds_01.model.TextModel;

public abstract class MainController {
    protected TextModel model;

    public MainController(TextModel model) {
        this.model = model;
    }

    public TextModel getModel() {
        return model;
    }

    public void setModel(TextModel model) {
        this.model = model;
    }
}
