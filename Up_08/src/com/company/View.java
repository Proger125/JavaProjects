package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class View extends JFrame {
    static final char A = 'A';
    private static final  int ROWS = 30;
    private static final  int COLS = 10;

    public View(){
        DefaultTableModel tableModel = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                if (column == 0)
                    return false;
                else
                    return super.isCellEditable(row, column);
            }

            public Class getColumnClass(int column) {
                return MyCell.class;
            }
        };
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setVisible(true);
        table.setRowHeight(25);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        scrollPane.setPreferredSize(new Dimension(700, 500));
        this.setContentPane(scrollPane);




        Vector<Integer> vector = new Vector<>();
        for (int i = 1; i < ROWS; i++){
            vector.add(i);
        }
        table.getTableHeader().setReorderingAllowed(false);
        tableModel.addColumn("", vector);

        for (int i = 0; i < COLS; i++) {
            tableModel.addColumn((char) (A + i));
        }

        CellController editor = new CellController();
        table.setDefaultEditor(MyCell.class, editor);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
