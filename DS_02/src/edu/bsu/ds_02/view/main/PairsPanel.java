package edu.bsu.ds_02.view.main;

import edu.bsu.ds_02.controller.option.MakePairsController;
import edu.bsu.ds_02.model.Users;
import edu.bsu.ds_02.model.UtilModel;

import javax.swing.*;
import java.awt.*;

public class PairsPanel extends JPanel {
    private final Users users;
    private final UtilModel utilModel;

    private final JList<String> pairsList = new JList<>();
    private final JButton makePairsButton = new JButton("Найти пары");

    public PairsPanel(Users users, UtilModel utilModel){
        super(new BorderLayout());

        this.users = users;
        this.utilModel = utilModel;

        this.add(pairsList, BorderLayout.CENTER);

        makePairsButton.addActionListener(new MakePairsController(users, utilModel, this));
        this.add(makePairsButton, BorderLayout.SOUTH);
    }

    public void setModel(DefaultListModel<String> model){
        pairsList.setModel(new DefaultListModel<>());
        pairsList.setModel(model);
    }
}
