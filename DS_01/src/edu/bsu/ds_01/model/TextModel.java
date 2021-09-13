package edu.bsu.ds_01.model;


import edu.bsu.ds_01.view.CustomFrame;

public class TextModel {
    private String text = "";
    private String currentFileName;
    private CustomFrame frame;

    public TextModel(CustomFrame frame) {
       this.frame = frame;
    }

    public String getCurrentFileName() {
        return currentFileName;
    }

    public void setCurrentFileName(String currentFileName) {
        this.currentFileName = currentFileName;
        this.frame.enableSaveItem();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void insertText(String text){
        this.text = text;
        frame.setAreaText(text);
    }
}
