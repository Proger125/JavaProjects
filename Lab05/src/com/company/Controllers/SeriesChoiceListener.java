package com.company.Controllers;

import com.company.Series.ExponentialSeries;
import com.company.Series.LinearSeries;
import com.company.Series.Series;
import com.company.View;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class SeriesChoiceListener implements ItemListener {
    private Series series;
    private View view;
    public SeriesChoiceListener(Series series, View view){
        this.series = series;
        this.view = view;
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        JRadioButton button = (JRadioButton) e.getSource();
        if (button.getText() == "Linear Series" && button.isSelected()){
            double firstElement = series.getFirstElement();
            int amount = series.getAmountOfElements();
            double denominator = series.getDenominator();
            series = new LinearSeries(firstElement, amount, denominator);
            view.getSeriesOutput().setText(series.toString());
            view.changeSeries(series);
        }else if(button.getText() == "Exponential Series" && button.isSelected()){
            double firstElement = series.getFirstElement();
            int amount = series.getAmountOfElements();
            double denominator = series.getDenominator();
            series = new ExponentialSeries(firstElement, amount, denominator);
            view.getSeriesOutput().setText(series.toString());
            view.changeSeries(series);
        }
    }
}
