package edu.bsu.ds_01.view;

import edu.bsu.ds_01.controller.main.*;
import edu.bsu.ds_01.controller.option.CheckTransfersController;
import edu.bsu.ds_01.controller.option.OpenOptionFileController;
import edu.bsu.ds_01.model.OptionFileModel;
import edu.bsu.ds_01.model.TextModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CustomFrame extends JFrame {
    private final TextModel model = new TextModel(this);
    private final OptionFileModel optionFileModel = new OptionFileModel(this);
    private final JTextArea area = new JTextArea(2, 5);
    private final JButton checkTransferButton;
    private final JLabel mistakeAmountLabel = new JLabel();
    private final JLabel wordAmountLabel = new JLabel();
    private JMenuItem saveItem;

    public CustomFrame(String title){
        super(title);
        JPanel mainPanel = new JPanel(new BorderLayout());

        area.setLineWrap(true);
        area.getDocument().addDocumentListener(new ChangeTextController(model));
        mainPanel.add(new JScrollPane(area), BorderLayout.CENTER);

        checkTransferButton = new JButton("Проверить на правильность переносов");
        checkTransferButton.setEnabled(false);
        checkTransferButton.addActionListener(new CheckTransfersController(optionFileModel, model));
        mainPanel.add(checkTransferButton, BorderLayout.SOUTH);

        mainPanel.add(createInfoPanel(), BorderLayout.NORTH);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(createFileMenu());
        menuBar.add(createOptionMenu());

        this.addWindowListener(new ExitListener(model));
        this.setJMenuBar(menuBar);
        this.setContentPane(mainPanel);
        this.setSize(800, 500);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
    }

    public void setWordAmount(String amount){
        wordAmountLabel.setText(amount);
    }

    public void setMistakeAmount(String amount){
        mistakeAmountLabel.setText(amount);
    }

    public void setAreaText(String text){
        area.setText(text);
    }

    public void enableSaveItem(){
        saveItem.setEnabled(true);
    }

    public void enableCheckButton(){
        checkTransferButton.setEnabled(true);
    }

    private JPanel createInfoPanel(){
        JPanel infoPanel = new JPanel(new GridLayout(1, 4));
        JLabel mistakeLabel = new JLabel("Количество ошибок:");
        infoPanel.add(mistakeLabel);
        infoPanel.add(mistakeAmountLabel);

        JLabel wordLabel = new JLabel("Количество слов:");
        infoPanel.add(wordLabel);
        infoPanel.add(wordAmountLabel);
        return infoPanel;
    }

    private JMenu createFileMenu(){
        JMenu fileMenu = new JMenu("Файл");

        JMenuItem openItem = new JMenuItem("Открыть");
        openItem.addActionListener(new OpenFileController(model));
        saveItem = new JMenuItem("Сохранить");
        saveItem.addActionListener(new SaveFileController(model));
        saveItem.setEnabled(false);
        JMenuItem saveAsItem = new JMenuItem("Сохранить как");
        saveAsItem.addActionListener(new SaveAsFileController(model));
        JMenuItem exitItem = new JMenuItem(new ExitAction());

        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(saveAsItem);
        fileMenu.add(exitItem);

        return fileMenu;
    }
    private JMenu createOptionMenu(){
        JMenu optionMenu = new JMenu("Настройки");

        JMenuItem openOptionFileItem = new JMenuItem("Выбрать файл переносов");
        openOptionFileItem.addActionListener(new OpenOptionFileController(optionFileModel));

        optionMenu.add(openOptionFileItem);

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
