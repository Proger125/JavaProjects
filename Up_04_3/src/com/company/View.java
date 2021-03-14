package com.company;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private final Model model;
    public View(String title, Model model){
        super(title);
        this.model = model;
        ChartPanel mainPanel = new ChartPanel(createDiagram());
        this.setContentPane(mainPanel);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    private JFreeChart createDiagram(){
        JFreeChart chart = ChartFactory.createBarChart(
                "Самые популярные языки программирования",
                "Название",
                "Процент популярности",
                model.createDataset(),
                PlotOrientation.HORIZONTAL,
                false,
                true,
                false
        );
        chart.setBackgroundPaint(Color.WHITE);
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        return chart;
    }
}
