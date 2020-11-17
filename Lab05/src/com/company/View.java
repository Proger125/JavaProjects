package com.company;
import com.company.Controllers.*;
import com.company.Series.LinearSeries;
import com.company.Series.Series;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private Series series;
    private InputParamsListener listener;
    SeriesChoiceListener listener1;
    SumCalculateListener listener2;
    ElementCalculateListener listener3;
    SaveToFileListener listener4;
    JPanel mainPanel = new JPanel( new GridLayout(3,2, 10, 10));
    JRadioButton linearRadioButton;
    JRadioButton exponentialRadioButton;
    private JTextField firstElementField;
    public JTextField getFirstElementField(){
        return this.firstElementField;
    }
    private JButton firstElementSubmitButton;
    public JButton getFirstElementSubmitButton(){
        return this.firstElementSubmitButton;
    }
    JTextField amountField;
    public JTextField getAmountField(){
        return amountField;
    }
    JButton amountSubmitButton;
    public JButton getAmountSubmitButton(){
        return amountSubmitButton;
    }
    JTextField denominatorField;
    public JTextField getDenominatorField(){
        return this.denominatorField;
    }
    JButton denominatorSubmitButton;
    public JButton getDenominatorSubmitButton(){
        return this.denominatorSubmitButton;
    }
    JButton calcSumButton;
    public JButton getCalcSumButton(){
        return calcSumButton;
    }
    JTextField elementField;
    public JTextField getElementField(){
        return elementField;
    }
    JButton elementButton;
    public JButton getElementButton(){
        return elementButton;
    }
    JLabel sumLabel;
    public JLabel getSumLabel(){
        return sumLabel;
    }
    JLabel outputElementLabel;
    public JLabel getOutputElementLabel(){
        return outputElementLabel;
    }
    JLabel seriesOutput;
    public JLabel getSeriesOutput(){
        return seriesOutput;
    }
    public View(String title, Series series){
        super(title);
        this.series = series;
        this.setSize(700, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUpAllComponents();
        changeSeries(this.series);
        mainPanel.setFocusable(true);
        this.setContentPane(mainPanel);
        this.setVisible(true);
    }
    public void changeSeries(Series series){
        listener = new InputParamsListener(series, this);
        firstElementSubmitButton.addMouseListener(listener);
        amountSubmitButton.addMouseListener(listener);
        denominatorSubmitButton.addMouseListener(listener);
        listener1 = new SeriesChoiceListener(series, this);
        linearRadioButton.addItemListener(listener1);
        exponentialRadioButton.addItemListener(listener1);
        listener2 = new SumCalculateListener(series, this);
        calcSumButton.addMouseListener(listener2);
        listener3 = new ElementCalculateListener(series, this);
        elementButton.addMouseListener(listener3);
        listener4 = new SaveToFileListener(series);
        firstElementSubmitButton.addKeyListener(listener4);
        amountSubmitButton.addKeyListener(listener4);
        denominatorSubmitButton.addKeyListener(listener4);
        linearRadioButton.addKeyListener(listener4);
        exponentialRadioButton.addKeyListener(listener4);
        calcSumButton.addKeyListener(listener4);
        elementButton.addKeyListener(listener4);
    }
    private void setUpAllComponents(){
        setUpRadioButtons();
        setUpFieldsForInputParameters();
        setUpSumOutput();
        setUpElementOutput();
        setUpSeriesOutput();
    }
    private void setUpRadioButtons(){
        ButtonGroup group = new ButtonGroup();
        linearRadioButton = new JRadioButton("Linear Series");
        linearRadioButton.setSelected(true);
        exponentialRadioButton = new JRadioButton("Exponential Series");
        group.add(linearRadioButton);
        group.add(exponentialRadioButton);
        JPanel panel = new JPanel();
        panel.add(linearRadioButton);
        panel.add(exponentialRadioButton);
        panel.setBorder(BorderFactory.createTitledBorder("Choose the series"));
        mainPanel.add(panel);
    }
    private void setUpFieldsForInputParameters(){
        JPanel panel = new JPanel(new GridLayout(3, 3));
        JLabel inputFirstElementLabel = new JLabel("Input the first element:");
        panel.add(inputFirstElementLabel);
        firstElementField = new JTextField(10);
        panel.add(firstElementField);
        firstElementSubmitButton = new JButton("Submit");
        panel.add(firstElementSubmitButton);

        JLabel inputAmountLabel = new JLabel("Input the amount of elements:");
        panel.add(inputAmountLabel);
        amountField = new JTextField(10);
        panel.add(amountField);
        amountSubmitButton = new JButton("Submit");
        amountSubmitButton.setEnabled(false);
        panel.add(amountSubmitButton);

        JLabel denominatorLabel = new JLabel("Input the denominator:");
        panel.add(denominatorLabel);
        denominatorField = new JTextField(10);
        panel.add(denominatorField);
        denominatorSubmitButton = new JButton("Submit");
        denominatorSubmitButton.setEnabled(false);
        panel.add(denominatorSubmitButton);
        mainPanel.add(panel);
    }
    private void setUpSumOutput(){
        JPanel panel = new JPanel(new GridLayout(2,1));
        calcSumButton = new JButton("Calculate");
        calcSumButton.setEnabled(false);
        panel.add(calcSumButton);
        sumLabel = new JLabel();
        panel.add(sumLabel);
        panel.setBorder(BorderFactory.createTitledBorder("Calculate sum"));
        mainPanel.add(panel);
    }
    private void setUpElementOutput(){
        JPanel panel = new JPanel(new GridLayout(2, 2));
        JLabel elementLabel = new JLabel("Input index of element");
        panel.add(elementLabel);
        elementField = new JTextField(10);
        panel.add(elementField);
        elementButton = new JButton("Calculate");
        elementButton.setEnabled(false);
        panel.add(elementButton);
        outputElementLabel = new JLabel();
        panel.add(outputElementLabel);

        mainPanel.add(panel);
    }
    private void setUpSeriesOutput(){
        JPanel panel = new JPanel(new GridLayout(2,1));

        JLabel comments = new JLabel("Elements of series:");
        panel.add(comments);
        seriesOutput = new JLabel();
        panel.add(seriesOutput);

        mainPanel.add(panel);
    }
}
