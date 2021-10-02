package edu.bsu.ds_03.view;


import javax.swing.*;
import java.util.Locale;
import java.util.ResourceBundle;

import static edu.bsu.ds_03.view.FieldKey.*;
public class Fields {

    private static final String BUNDLE_NAME = "locale";

    private final JMenu fileMenu = new JMenu();
    private final JMenu optionMenu = new JMenu();

    private final JMenuItem exitItem = new JMenuItem();

    private final JRadioButtonMenuItem englishButton = new JRadioButtonMenuItem();
    private final JRadioButtonMenuItem russianButton = new JRadioButtonMenuItem();

    private final JList<String> methodsList = new JList<>();

    private final JLabel firstParameterLabel = new JLabel();
    private final JTextField firstParameter = new JTextField();

    private final JLabel secondParameterLabel = new JLabel();
    private final JTextField secondParameter = new JTextField();

    private final JLabel thirdParameterLabel = new JLabel();
    private final JTextField thirdParameter = new JTextField();

    private final JButton calcButton = new JButton();

    private final JLabel resultLabel = new JLabel();

    public void setLocale(Locale locale){
        ResourceBundle resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME, locale);

        fileMenu.setText(resourceBundle.getString(MENU_FILE));
        optionMenu.setText(resourceBundle.getString(MENU_OPTION));

        exitItem.setText(resourceBundle.getString(MENU_FILE_EXIT));

        englishButton.setText(resourceBundle.getString(MENU_OPTION_ENGLISH));
        russianButton.setText(resourceBundle.getString(MENU_OPTION_RUSSIAN));

        firstParameterLabel.setText(resourceBundle.getString(PARAMETER_FIRST));
        secondParameterLabel.setText(resourceBundle.getString(PARAMETER_SECOND));
        thirdParameterLabel.setText(resourceBundle.getString(PARAMETER_THIRD));

        calcButton.setText(resourceBundle.getString(FUNC_CALC));
    }

    public JMenu getFileMenu() {
        return fileMenu;
    }

    public JMenu getOptionMenu() {
        return optionMenu;
    }

    public JMenuItem getExitItem() {
        return exitItem;
    }

    public JRadioButtonMenuItem getEnglishButton() {
        return englishButton;
    }

    public JRadioButtonMenuItem getRussianButton() {
        return russianButton;
    }

    public JList<String> getMethodsList() {
        return methodsList;
    }

    public JTextField getFirstParameter() {
        return firstParameter;
    }

    public JTextField getSecondParameter() {
        return secondParameter;
    }

    public JTextField getThirdParameter() {
        return thirdParameter;
    }

    public JLabel getFirstParameterLabel() {
        return firstParameterLabel;
    }

    public JLabel getSecondParameterLabel() {
        return secondParameterLabel;
    }

    public JLabel getThirdParameterLabel() {
        return thirdParameterLabel;
    }

    public JButton getCalcButton() {
        return calcButton;
    }

    public JLabel getResultLabel() {
        return resultLabel;
    }
}
