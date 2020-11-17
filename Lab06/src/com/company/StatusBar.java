package com.company;

import javax.swing.*;

public class StatusBar extends JLabel {
    public StatusBar(){
        super();
        super.setSize(200, 50);
        setMessage("Ready");
    }
    public void setMessage(String message){
        setText(" " + message);
    }
}
