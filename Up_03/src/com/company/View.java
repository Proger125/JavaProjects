package com.company;

import com.company.Model.ListCountry;
import com.company.Model.Model;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.io.IOException;

public class View extends JFrame {
    private Model model;
    private JLabel mainLabel;
    private JList<ListCountry> jList;
    public View(String title, Model model) throws IOException {
        super(title);
        this.model = model;
        this.setSize(800, 500);
        JPanel mainPanel = new JPanel(new BorderLayout());
        addComponents(mainPanel);
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public void addComponents(JPanel panel) throws IOException {
        DefaultListModel<ListCountry> defaultListModel = model.convertToDefaultListModel();
        jList = new JList<>(defaultListModel);
        jList.setCellRenderer(new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                ListCountry item = (ListCountry) value;
                label.setIcon(new ImageIcon(item.getFlagPath()));
                return label;
            }
        });
        jList.addListSelectionListener(new ListItemListener());
        panel.add(jList, BorderLayout.WEST);
        mainLabel = new JLabel();
        mainLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainLabel.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(mainLabel, BorderLayout.CENTER);
    }
    private class ListItemListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()){
                ImageIcon icon = new ImageIcon(new ImageIcon(jList.getSelectedValue().getFlagPath()).getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
                mainLabel.setIcon(icon);
                mainLabel.setText(jList.getSelectedValue().toString());
                mainLabel.setVerticalTextPosition(JLabel.BOTTOM);
                mainLabel.setHorizontalTextPosition(JLabel.CENTER);
            }
        }
    }
}
