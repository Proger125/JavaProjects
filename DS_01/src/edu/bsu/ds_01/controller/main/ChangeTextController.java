package edu.bsu.ds_01.controller.main;

import edu.bsu.ds_01.controller.ChangeController;
import edu.bsu.ds_01.controller.MainController;
import edu.bsu.ds_01.model.TextModel;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;


public class ChangeTextController extends MainController implements DocumentListener, ChangeController {
    public ChangeTextController(TextModel model) {
        super(model);
    }


    @Override
    public void insertUpdate(DocumentEvent e) {
        Document document = e.getDocument();
        changeText(model, document);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        Document document = e.getDocument();
        changeText(model, document);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        Document document = e.getDocument();
        changeText(model, document);
    }
}
