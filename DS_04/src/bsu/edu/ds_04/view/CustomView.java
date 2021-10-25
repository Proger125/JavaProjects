package bsu.edu.ds_04.view;

import bsu.edu.ds_04.controller.ExitController;
import bsu.edu.ds_04.controller.OpenFileController;
import bsu.edu.ds_04.controller.ProcessController;
import bsu.edu.ds_04.model.CustomModel;

import javax.swing.*;

public class CustomView extends JFrame {

    private final CustomModel model;

    JTextArea initArea = new JTextArea();
    JTextArea resultArea = new JTextArea();
    JButton mainButton = new JButton("Process");

    public CustomView(String title, CustomModel model){
        super(title);
        this.model = model;

        this.setJMenuBar(createMenu());
        this.setContentPane(createMainPanel());
        this.setSize(800, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void setInitAreaText(String text){
        this.initArea.setText(text);
    }

    public void setResultAreaText(String text){
        this.resultArea.setText(text);
    }

    private JPanel createMainPanel(){
        JPanel mainPanel = new JPanel(null);
        mainPanel.setSize(800, 500);

        initArea.setSize(300, 500);
        initArea.setLocation(0, 0);
        initArea.setLineWrap(true);

        resultArea.setSize(300, 500);
        resultArea.setLocation(500, 0);
        resultArea.setLineWrap(true);

        mainButton.setSize(100, 50);
        mainButton.setLocation(350, 225);
        mainButton.addActionListener(new ProcessController(model, this));

        mainPanel.add(initArea);
        mainPanel.add(resultArea);
        mainPanel.add(mainButton);
        return mainPanel;
    }

    private JMenuBar createMenu(){
        JMenuBar menuBar = new JMenuBar();

        menuBar.add(createFileMenu());

        return menuBar;
    }

    private JMenu createFileMenu(){
        JMenu fileMenu = new JMenu("Файл");

        JMenuItem openItem = new JMenuItem("Открыть");
        openItem.addActionListener(new OpenFileController(model, this));

        JMenuItem exitItem = new JMenuItem("Выйти");
        exitItem.addActionListener(new ExitController());

        fileMenu.add(openItem);
        fileMenu.add(exitItem);

        return fileMenu;
    }
}
