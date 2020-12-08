package com.company.FirstView;

import javax.swing.*;


public class Controller {
    private final DefaultListModel<String> list1 = new DefaultListModel<>();
    private final DefaultListModel<String> list2 = new DefaultListModel<>();
    private final FirstTaskPanel panel;
    public Controller(FirstTaskPanel panel) {
        this.panel = panel;
        list1.addElement("1");
        list1.addElement("2");
        list1.addElement("3");
        list1.addElement("4");
        list2.addElement("Line1");
        list2.addElement("Line2");
        list2.addElement("Line3");
        list2.addElement("Line4");
    }

    public DefaultListModel<String> getList1(){
        return list1;
    }

    public DefaultListModel<String> getList2(){
        return list2;
    }

}
