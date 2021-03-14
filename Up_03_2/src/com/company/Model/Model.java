package com.company.Model;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class Model extends DefaultTableModel {
    private final String[] columnsHeader = new String[]{ "Выбрать", "Страна", "Описание", "Цена"};
    private final Class[] columnsClasses = new Class[]{Boolean.class, ImageIcon.class, String.class, Double.class};
    private final List<Tour> list;
    public Model(){
        list = new ArrayList<>();
    }

    @Override
    public String getColumnName(int column) {
        return this.columnsHeader[column];
    }

    public void addTour(Tour tour){
        this.list.add(tour);
    }
    @Override
    public int getRowCount() {
        if (list == null){
            return 0;
        }else{
            return list.size();
        }
    }

    @Override
    public int getColumnCount() {
        return columnsHeader.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
            Tour tour = list.get(rowIndex);
            if(rowIndex == 0 && columnIndex == 0){
                return null;
            }
            if (columnIndex == 0){
                return tour.getSelected();
            }
            if (columnIndex == 1){
                return tour.getFlag();
            }
            if (columnIndex == 2){
                return tour.getDescription();
            }
            if (columnIndex == 3){
                return tour.getPrice();
            }
            return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return this.columnsClasses[columnIndex];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        if (row == 0 && (column == 0 || column == 1 || column == 2 || column == 3)){
            return false;
        }
        return true;
    }

    @Override
    public void addRow(Object[] rowData) {
        Boolean isSelected = (boolean)rowData[0];
        ImageIcon flag = (ImageIcon)rowData[1];
        String description = (String)rowData[2];
        Double price = (Double)rowData[3];
        Tour tour = new Tour(flag, description, price, isSelected);
        list.add(tour);
        fireTableRowsInserted(list.size(), list.size());
    }

    @Override
    public void setValueAt(Object aValue, int row, int column) {
        Tour tour = list.get(row);
        if(column == 0 && row == 0){
            tour.setSelected(null);
        }
        if (column == 0){
            tour.setSelected((Boolean)aValue);
        }
        if (column == 1){
            tour.setFlag((ImageIcon)aValue);
        }
        if (column == 2){
            tour.setDescription((String)aValue);
        }
        if (column == 3){
            tour.setPrice((Double)aValue);
        }
        fireTableCellUpdated(row, column);
    }

}
