package edu.bsu.ds_01.controller;

import edu.bsu.ds_01.model.OptionFileModel;

public abstract class OptionController {
    protected OptionFileModel model;

    public OptionController(OptionFileModel model) {
        this.model = model;
    }

    public OptionFileModel getModel() {
        return model;
    }

    public void setModel(OptionFileModel model) {
        this.model = model;
    }
}
