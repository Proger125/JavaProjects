package com.company.FirstView;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Controller {
    private final ArrayList<String> list1 = new ArrayList<>();
    private final ArrayList<String> list2 = new ArrayList<>();
    private final FirstTaskPanel panel;
    public Controller(FirstTaskPanel panel) {
        this.panel = panel;
    }
    public void setList1(){
        String str = panel.getLeftAreaText();
        StringTokenizer stringTokenizer = new StringTokenizer(str);
        while(stringTokenizer.hasMoreTokens()){
            list1.add(stringTokenizer.nextToken());
        }
    }
    public void setList2(){
        String str = panel.getRightAreaText();
        StringTokenizer stringTokenizer = new StringTokenizer(str);
        while(stringTokenizer.hasMoreTokens()){
            list2.add(stringTokenizer.nextToken());
        }
    }
    public void leftTransfer(){
        setList1();
        setList2();
        list1.addAll(list2);
        list2.removeAll(list1);
        panel.setLeftAreaText(list1);
        panel.setRightAreaText(list2);
        list1.removeAll(list1);
        list2.removeAll(list2);
    }
    public void rightTransfer(){
        setList1();
        setList2();
        list2.addAll(list1);
        list1.removeAll(list2);
        panel.setLeftAreaText(list1);
        panel.setRightAreaText(list2);
        list1.removeAll(list1);
        list2.removeAll(list2);
    }
}
