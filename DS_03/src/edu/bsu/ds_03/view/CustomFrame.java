package edu.bsu.ds_03.view;

import javax.swing.*;

import edu.bsu.ds_03.controller.CalculateController;
import edu.bsu.ds_03.controller.ExitController;
import edu.bsu.ds_03.controller.LocaleController;
import edu.bsu.ds_03.controller.SelectionListener;
import edu.bsu.ds_03.model.LocaleModel;

import java.awt.*;

public class CustomFrame extends JFrame {
    private final Fields fields = new Fields();
    private final LocaleModel localeModel = new LocaleModel(fields);
    private final JPanel centerPanel = new JPanel(null);

    public CustomFrame(String title){
        super(title);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JList<String> methodsList = fields.getMethodsList();
        methodsList.addListSelectionListener(new SelectionListener(this, localeModel));
        methodsList.setModel(localeModel.createMethodsListModel());
        mainPanel.add(new JScrollPane(methodsList), BorderLayout.WEST);

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        addFirstParameter();
        addSecondParameter();
        addThirdParameter();
        addCalcButton();
        addResultLabel();
        clearCenterPanel();

        this.setContentPane(mainPanel);
        this.setSize(800, 500);
        this.setJMenuBar(createMenu());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private JMenuBar createMenu(){
        JMenuBar menuBar = new JMenuBar();

        menuBar.add(createFileMenu());
        menuBar.add(createOptionMenu());

        return menuBar;
    }

    public Fields getFields() {
        return fields;
    }

    private JMenu createFileMenu(){
        JMenu fileMenu = fields.getFileMenu();

        JMenuItem exitItem = fields.getExitItem();
        exitItem.addActionListener(new ExitController());

        fileMenu.add(exitItem);

        return fileMenu;
    }

    private JMenu createOptionMenu(){
        JMenu optionMenu = fields.getOptionMenu();

        ButtonGroup languageGroup = new ButtonGroup();

        JRadioButtonMenuItem englishButton = fields.getEnglishButton();
        englishButton.addActionListener(new LocaleController(localeModel, this));
        languageGroup.add(englishButton);
        optionMenu.add(englishButton);

        JRadioButtonMenuItem russianButton = fields.getRussianButton();
        russianButton.addActionListener(new LocaleController(localeModel, this));
        languageGroup.add(russianButton);
        optionMenu.add(russianButton);

        russianButton.setSelected(true);

        return optionMenu;
    }

    public void clearCenterPanel(){
        fields.getFirstParameter().setVisible(false);
        fields.getFirstParameterLabel().setVisible(false);

        fields.getSecondParameter().setVisible(false);
        fields.getSecondParameterLabel().setVisible(false);

        fields.getThirdParameter().setVisible(false);
        fields.getThirdParameterLabel().setVisible(false);

        fields.getCalcButton().setVisible(false);
    }

    private void addFirstParameter(){
        JLabel label = fields.getFirstParameterLabel();
        label.setSize(200, 20);
        label.setLocation(50, 50);

        JTextField field = fields.getFirstParameter();
        field.setSize(100, 20);
        field.setLocation(260, 50);

        centerPanel.add(label);
        centerPanel.add(field);
    }

    private void addSecondParameter(){
        JLabel label = fields.getSecondParameterLabel();
        label.setSize(200, 20);
        label.setLocation(50, 110);

        JTextField field = fields.getSecondParameter();
        field.setSize(100, 20);
        field.setLocation(260, 110);

        centerPanel.add(label);
        centerPanel.add(field);
    }

    private void addThirdParameter(){
        JLabel label = fields.getThirdParameterLabel();
        label.setSize(200, 20);
        label.setLocation(50, 170);

        JTextField field = fields.getThirdParameter();
        field.setSize(100, 20);
        field.setLocation(260, 170);

        centerPanel.add(label);
        centerPanel.add(field);
    }

    public void showFirstParameter(){
        fields.getFirstParameterLabel().setVisible(true);
        fields.getFirstParameter().setVisible(true);
    }

    public void showSecondParameter(){
        fields.getSecondParameterLabel().setVisible(true);
        fields.getSecondParameter().setVisible(true);
    }

    public void showThirdParameter(){
        fields.getThirdParameterLabel().setVisible(true);
        fields.getThirdParameter().setVisible(true);
    }

    public void addCalcButton(){
        JButton calcButton = fields.getCalcButton();
        calcButton.setSize(100, 50);
        calcButton.setLocation(200, 250);
        calcButton.addActionListener(new CalculateController(localeModel, fields));

        centerPanel.add(calcButton);
    }

    public void showCalcButton(){
        fields.getCalcButton().setVisible(true);
    }

    public void addResultLabel(){
        JLabel label = fields.getResultLabel();
        label.setSize(200, 20);
        label.setLocation(200, 320);
        centerPanel.add(label);
    }
}
