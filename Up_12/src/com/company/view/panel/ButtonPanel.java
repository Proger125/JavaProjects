package com.company.view.panel;

import com.company.controller.*;
import com.company.model.CustomModel;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {
    private CustomModel model;
    private final JButton addNaturalGemButton;
    private final JButton addArtificialGemButton;
    private final JButton deleteButton;
    private final JButton openButton;
    private final JButton saveButton;
    private final JButton openBinaryButton;
    private final JButton saveBinaryButton;
    private final JButton calcMaxTransparencyButton;
    private final JButton calcMinEdgeAmountButton;
    public ButtonPanel(CustomModel model){
        this.model = model;
        this.setLayout(new GridLayout(2,5));

        addNaturalGemButton = new JButton("Добавить Natural");
        addNaturalGemButton.addMouseListener(new AddNaturalGemController(model));

        addArtificialGemButton = new JButton("Добавить Artificial");
        addArtificialGemButton.addMouseListener(new AddArtificialGemController(model));

        deleteButton = new JButton("Удалить элемент");
        deleteButton.addMouseListener(new DeleteButtonController(model));

        openButton = new JButton("Открыть файл");
        openButton.addMouseListener(new OpenButtonController(model));

        saveButton = new JButton("Сохранить");
        saveButton.addMouseListener(new SaveButtonController(model));

        openBinaryButton = new JButton("Открыть бинарно");
        openBinaryButton.addMouseListener(new OpenBinaryButtonController(model));

        saveBinaryButton = new JButton("Сохранить бинарно");
        saveBinaryButton.addMouseListener(new SaveBinaryButtonController(model));

        calcMaxTransparencyButton = new JButton("Максимальная прозрачность");
        calcMaxTransparencyButton.addMouseListener(new MaxTransparencyButtonController());

        calcMinEdgeAmountButton = new JButton("Минимальное число граней");
        calcMinEdgeAmountButton.addMouseListener(new MinEdgeAmountController());

        this.add(openButton);
        this.add(saveButton);
        this.add(addNaturalGemButton);
        this.add(addArtificialGemButton);
        this.add(deleteButton);
        this.add(openBinaryButton);
        this.add(saveBinaryButton);
        this.add(calcMaxTransparencyButton);
        this.add(calcMinEdgeAmountButton);
    }
}
