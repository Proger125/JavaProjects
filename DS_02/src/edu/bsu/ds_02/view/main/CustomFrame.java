package edu.bsu.ds_02.view.main;

import edu.bsu.ds_02.controller.main.ExitListener;
import edu.bsu.ds_02.controller.main.OpenFileController;
import edu.bsu.ds_02.controller.main.OpenFileObjectController;
import edu.bsu.ds_02.controller.main.saveImpl.SaveAsFileController;
import edu.bsu.ds_02.controller.main.saveImpl.SaveAsObjectController;
import edu.bsu.ds_02.controller.main.saveImpl.SaveFileController;
import edu.bsu.ds_02.controller.option.OpenAddUserDialogController;
import edu.bsu.ds_02.model.Users;
import edu.bsu.ds_02.model.UtilModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CustomFrame extends JFrame {

    private final Users users = new Users();
    private final UtilModel utilModel = new UtilModel();
    private UserPanel malePanel;
    private UserPanel femalePanel;

    public CustomFrame(String title) {
        super(title);

        this.setContentPane(createMainPanel());
        this.setJMenuBar(createMenu());
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new ExitListener(users, utilModel));
        this.setSize(800, 500);
        this.setVisible(true);
    }

    public UserPanel getMalePanel() {
        return malePanel;
    }

    public UserPanel getFemalePanel() {
        return femalePanel;
    }

    private JPanel createMainPanel(){
        JPanel mainPanel = new JPanel(new BorderLayout());

        malePanel = new UserPanel("Мужчины", users, this);
        mainPanel.add(malePanel, BorderLayout.WEST);

        femalePanel = new UserPanel("Женщины", users, this);
        mainPanel.add(femalePanel, BorderLayout.EAST);

        PairsPanel pairsPanel = new PairsPanel(users, utilModel);
        mainPanel.add(pairsPanel, BorderLayout.CENTER);
        return mainPanel;
    }

    private JMenuBar createMenu(){
        JMenuBar menuBar = new JMenuBar();

        menuBar.add(createFileMenu());
        menuBar.add(createOptionMenu());

        return menuBar;
    }

    private JMenu createFileMenu(){
        JMenu fileMenu = new JMenu("Файл");

        JMenuItem openItem = new JMenuItem("Открыть");
        openItem.addActionListener(new OpenFileController(users, utilModel, this));

        JMenuItem openAsObject = new JMenuItem("Открыть как объект");
        openAsObject.addActionListener(new OpenFileObjectController(users, utilModel));

        JMenuItem saveItem = new JMenuItem("Сохранить");
        saveItem.addActionListener(new SaveFileController(users, utilModel));

        JMenuItem saveAsItem = new JMenuItem("Сохранить как");
        saveAsItem.addActionListener(new SaveAsFileController(users, utilModel));

        JMenuItem saveAsObjectItem = new JMenuItem("Сохранить как объект");
        saveAsObjectItem.addActionListener(new SaveAsObjectController(users, utilModel));

        JMenuItem exitItem = new JMenuItem(new ExitAction());

        fileMenu.add(openItem);
        fileMenu.add(openAsObject);
        fileMenu.add(saveItem);
        fileMenu.add(saveAsItem);
        fileMenu.add(saveAsObjectItem);
        fileMenu.add(exitItem);

        return fileMenu;
    }

    private JMenu createOptionMenu(){
        JMenu optionMenu = new JMenu("Опции");

        JMenuItem addItem = new JMenuItem("Добавить");
        addItem.addActionListener(new OpenAddUserDialogController(users, utilModel, this));

        optionMenu.add(addItem);

        return optionMenu;
    }

    static class ExitAction extends AbstractAction{
        ExitAction(){
            putValue(NAME, "Выход");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
