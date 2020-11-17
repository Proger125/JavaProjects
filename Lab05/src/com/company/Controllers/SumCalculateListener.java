package com.company.Controllers;

import com.company.Series.Series;
import com.company.View;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SumCalculateListener implements MouseListener {
    private Series series;
    private View view;
    public SumCalculateListener(Series series, View view){
        this.series = series;
        this.view = view;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        double sum = series.sumOfSeries();
        view.getSumLabel().setText(Double.toString(sum));
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
