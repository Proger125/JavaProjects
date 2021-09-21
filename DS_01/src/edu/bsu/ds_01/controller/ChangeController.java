package edu.bsu.ds_01.controller;

import edu.bsu.ds_01.model.TextModel;

import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public interface ChangeController {
    default void changeText(TextModel model, Document document){
        try {
            model.setText(document.getText(0, document.getLength()));
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
    }
}
