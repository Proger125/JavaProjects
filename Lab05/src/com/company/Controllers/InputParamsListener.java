package com.company.Controllers;

import com.company.Series.Series;
import com.company.View;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class InputParamsListener implements MouseListener {
    private Series series;
    private View view;
    public InputParamsListener(Series series, View view){
        this.series = series;
        this.view = view;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == view.getFirstElementSubmitButton()){
            view.getFirstElementField().setBackground(Color.WHITE);
            String text = view.getFirstElementField().getText();
            double firstElement = 0;
            try{
            firstElement = Double.parseDouble(text);
            }catch (NumberFormatException exception){
                view.getFirstElementField().setBackground(Color.RED);
                return;
            }
            if (view.getElementField().getBackground() != Color.RED) {
                series.setFirstElement(firstElement);
                view.getAmountSubmitButton().setEnabled(true);
            }
        }
        if (e.getSource() == view.getAmountSubmitButton()){
            view.getAmountField().setBackground(Color.WHITE);
            String text = view.getAmountField().getText();
            int amount = 0;
            try{
                amount = Integer.parseInt(text);
            }catch(NumberFormatException exception){
                view.getAmountField().setBackground(Color.RED);
            }
            if (view.getElementField().getBackground() != Color.RED) {
                series.setAmountOfElements(amount);
                view.getDenominatorSubmitButton().setEnabled(true);
            }
        }
        if (e.getSource() == view.getDenominatorSubmitButton()){
            view.getDenominatorField().setBackground(Color.WHITE);
            String text = view.getDenominatorField().getText();
            double denominator = 0;
            try{
                denominator = Double.parseDouble(text);
            }catch (NumberFormatException exception){
                view.getDenominatorField().setBackground(Color.RED);
            }
            if (view.getElementField().getBackground() != Color.RED) {
                series.setDenominator(denominator);
                view.getElementButton().setEnabled(true);
                view.getCalcSumButton().setEnabled(true);
                view.getSeriesOutput().setText(series.toString());
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
