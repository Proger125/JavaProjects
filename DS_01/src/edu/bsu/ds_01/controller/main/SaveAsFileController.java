package edu.bsu.ds_01.controller.main;

import edu.bsu.ds_01.controller.MainController;
import edu.bsu.ds_01.controller.SaveAsController;
import edu.bsu.ds_01.model.TextModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveAsFileController extends MainController implements ActionListener, SaveAsController {
    public SaveAsFileController(TextModel model) {
        super(model);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        saveAs(model);
    }
}
