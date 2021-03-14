package com.company;

import com.company.Model.Model;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class View extends JFrame {
    private final JTable table;
    private final Model model;
    private boolean isTotalPriceLastUpdated = false;
    public View(String title, Model model){
        super(title);
        this.model = model;
        table = new JTable(model);
        JPanel mainPanel = new JPanel(new BorderLayout());
        addComponents(mainPanel);
        this.setContentPane(mainPanel);
        this.setSize(800, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public void addComponents(JPanel panel) {
        table.setRowHeight(50);
        table.getModel().addTableModelListener(new TableChangeListener());
        table.getColumnModel().getColumn(1).setCellEditor(new IconCellChangeListener());
        JButton addRowButton = new JButton("Добавить ряд");
        addRowButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Model model = (Model)table.getModel();
                model.addRow(new Object[]{false, null, "", 0.0});
            }
        });
        panel.add(addRowButton, BorderLayout.EAST);
        panel.add(new JScrollPane(table), BorderLayout.CENTER);
    }
    private class TableChangeListener implements TableModelListener{

        @Override
        public void tableChanged(TableModelEvent e) {
            if(!isTotalPriceLastUpdated) {
                Model model = (Model) e.getSource();
                Double generalPrice = 0.0;
                for (int i = 1; i < model.getRowCount(); i++) {
                    Boolean isSelected = (Boolean) model.getValueAt(i, 0);
                    if (isSelected) {
                        generalPrice += (Double) model.getValueAt(i, 3);
                    }
                }
                isTotalPriceLastUpdated = true;
                model.setValueAt(generalPrice, 0, 3);
            }else{
                isTotalPriceLastUpdated = false;
            }
        }
    }
    private static class IconCellChangeListener extends AbstractCellEditor implements TableCellEditor {
        private final JLabel label = new JLabel();
        @Override
        public Object getCellEditorValue() {
            return label.getIcon();
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            JFileChooser chooser = new JFileChooser();
            int res = chooser.showOpenDialog(null);
            if (res == JFileChooser.APPROVE_OPTION){
                File targetFile = chooser.getSelectedFile();
                label.setIcon(new ImageIcon(targetFile.getPath()));
                label.setHorizontalAlignment(JLabel.CENTER);
                return label;
            }
            return null;
        }
    }
}
