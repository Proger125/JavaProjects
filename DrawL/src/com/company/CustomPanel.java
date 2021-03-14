package com.company;

import javax.swing.*;
import java.awt.*;

public class CustomPanel extends JPanel {
    private static final int n = 500;
    private double[] nodes = new double[n];
    private double[] functionNodes = new double[n];
    private double[] polynomNodes = new double[n];
    public void countNodes(){
        nodes[0] = -250;
        nodes[n - 1] = 250;
        double step = ((nodes[n - 1] - nodes[0]) / ((double)n - 1));
        for (int i = 1; i <= n - 2; i++){
            nodes[i] = nodes[i - 1] + step;
        }
    }
    public void countFunction(){
        for (int i = 0; i < n; i++){
            functionNodes[i] = Math.pow(Math.E, Math.abs(nodes[i])) + Math.abs(nodes[i]);
        }
    }
    public double countPolynom(double x){
        double tmp = 1;
        double polynom = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (i != j){
                    tmp *= (x - nodes[i]);
                    tmp /= (nodes[i] - nodes[j]);
                }
            }
            polynom += functionNodes[i] * tmp;
        }
        return polynom;
    }
    @Override

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine(250, 0, 250, 500);
        g.drawLine(0, 250, 500, 250);
        int zeroX = 250;
        int zeroY = 250;
        countNodes();
        countFunction();
        for (int i = 0; i < 500; i++){
            g.drawRect(zeroX +(int)nodes[i], zeroY - (int)functionNodes[i] * 100, 1, 1);
            g.drawRect(zeroX + (int)nodes[i], zeroY - (int)countPolynom(nodes[i]) * 100, 1, 1);
        }
    }
}
