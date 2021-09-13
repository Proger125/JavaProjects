package edu.bsu.ds_01.controller.main;

import edu.bsu.ds_01.controller.MainController;
import edu.bsu.ds_01.model.TextModel;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;


public class ChangeTextController extends MainController implements DocumentListener {
    public ChangeTextController(TextModel model) {
        super(model);
    }


    @Override
    public void insertUpdate(DocumentEvent e) {
        Document document = e.getDocument();
        try {
            model.setText(document.getText(0, document.getLength()));
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void removeUpdate(DocumentEvent e) {

    }

    @Override
    public void changedUpdate(DocumentEvent e) {

    }
}
