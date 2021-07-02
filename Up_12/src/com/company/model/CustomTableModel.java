package com.company.model;

import com.company.entity.*;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.time.YearMonth;
import java.time.format.DateTimeParseException;
import java.util.List;

public class CustomTableModel extends AbstractTableModel {
    List<Gem> gems;

    public CustomTableModel(List<Gem> gems){
        this.gems = gems;
    }
    @Override
    public int getRowCount() {
        return gems.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return switch (columnIndex) {
            case 0, 2, 4, 8, 3, 7 -> String.class;
            case 1, 5, 6 -> Integer.class;
            default -> null;
        };
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Gem gem = gems.get(rowIndex);
        switch (columnIndex) {
            case 0 -> gem.setId((String) aValue);
            case 1 -> gem.setWeight((int) aValue);
            case 2 -> gem.setName((String) aValue);
            case 3 -> {
                String str = (String) aValue;
                try {
                    gem.setPreciousness(Preciousness.valueOf(str.toUpperCase().replace('-', '_')));
                }catch (IllegalArgumentException e){
                    JOptionPane.showMessageDialog(null, "Incorrect data");
                }
            }
            case 4 -> gem.getParameters().setColor((String) aValue);
            case 5 -> gem.getParameters().setTransparency((int) aValue);
            case 6 -> gem.getParameters().setEdgeAmount((int) aValue);
            case 7 -> {
                String str = (String) aValue;
                try{
                    gem.setCreationDate(YearMonth.parse(str));
                }catch (DateTimeParseException e){
                    JOptionPane.showMessageDialog(null, "Incorrect data");
                }

            }
            case 8 -> {
                String str = (String) aValue;
                if (gem.getClass() == NaturalGem.class){
                    NaturalGem naturalGem = (NaturalGem) gem;
                    try {
                        naturalGem.setPlace(ExtractionPlace.valueOf(str.toUpperCase().replace('-', '_')));
                    }catch (IllegalArgumentException e){
                        JOptionPane.showMessageDialog(null, "Incorrect data");
                    }
                }else{
                    ArtificialGem artificialGem = (ArtificialGem) gem;
                    try{
                        artificialGem.setGrowingTime(Integer.parseInt(str));
                    }catch (NumberFormatException e){
                        JOptionPane.showMessageDialog(null, "Incorrect data");
                    }
                }
            }
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Gem gem = gems.get(rowIndex);
        switch (columnIndex){
            case 0: return gem.getId();
            case 1: return gem.getValue();
            case 2: return gem.getName();
            case 3: return gem.getPreciousness();
            case 4: return gem.getParameters().getColor();
            case 5: return gem.getParameters().getTransparency();
            case 6: return gem.getParameters().getEdgeAmount();
            case 7: return gem.getCreationDate();
            case 8:{
                if (gem.getClass() == NaturalGem.class){
                    NaturalGem naturalGem = (NaturalGem) gem;
                    return naturalGem.getPlace();
                }else{
                    ArtificialGem artificialGem = (ArtificialGem) gem;
                    return artificialGem.getGrowingTime();
                }
            }
        }
        return null;
    }
}
