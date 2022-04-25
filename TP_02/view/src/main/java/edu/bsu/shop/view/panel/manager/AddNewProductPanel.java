package edu.bsu.shop.view.panel.manager;

import edu.bsu.shop.listener.AddNewProductButtonListener;

import javax.swing.*;

import java.awt.*;

import static edu.bsu.shop.view.config.GraphicalItems.*;

public class AddNewProductPanel extends JPanel {

    public AddNewProductPanel() {
        this.setLayout(null);
        this.setPreferredSize(new Dimension(500, 450));

        PRODUCT_NAME_LABEL.setLocation(100, 100);
        PRODUCT_NAME_FIELD.setLocation(210, 100);
        PRODUCT_DESCRIPTION_LABEL.setLocation(100, 130);
        PRODUCT_DESCRIPTION_AREA.setLocation(210, 130);
        PRODUCT_COST_LABEL.setLocation(100, 390);
        PRODUCT_COST_FIELD.setLocation(210, 390);
        ADD_NEW_PRODUCT_BUTTON.setLocation(210, 420);
        ADD_NEW_PRODUCT_BUTTON.addActionListener(new AddNewProductButtonListener());

        this.add(PRODUCT_NAME_LABEL);
        this.add(PRODUCT_NAME_FIELD);
        this.add(PRODUCT_DESCRIPTION_LABEL);
        this.add(PRODUCT_DESCRIPTION_AREA);
        this.add(PRODUCT_COST_LABEL);
        this.add(PRODUCT_COST_FIELD);
        this.add(ADD_NEW_PRODUCT_BUTTON);
    }
}
