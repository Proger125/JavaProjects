package com.company;

import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class View extends JFrame {
    private final Model model;
    private final JList<Student> leftList = new JList<>();
    private final JList<Student> rightList = new JList<>();
    public View(String title){
        super(title);
        this.model = new Model();
        leftList.setModel(model.getModel());
        rightList.setModel(model.getSortedModel());
        this.setSize(800, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel(new BorderLayout());
        addComponents(mainPanel);
        this.setContentPane(mainPanel);
        this.setVisible(true);
    }
    private void addComponents(JPanel panel){
        panel.add(leftList, BorderLayout.WEST);
        panel.add(rightList, BorderLayout.EAST);
        JPanel centerPanel = new JPanel(new GridLayout(5,1));
        JButton openButton = new JButton("Открыть");
        openButton.addMouseListener(new OpenButtonListener());
        JButton handleButton = new JButton("Обработать");
        handleButton.addMouseListener(new HandleButtonListener());
        JButton addButton = new JButton("Добавить");
        addButton.addMouseListener(new AddButtonListener());
        JButton saveButton = new JButton("Сохранить");
        saveButton.addMouseListener(new SaveButtonListener());
        JButton saveButton1 = new JButton("Сохранить руками");
        saveButton1.addMouseListener(new SaveButton1Listener());
        centerPanel.add(openButton);
        centerPanel.add(handleButton);
        centerPanel.add(addButton);
        centerPanel.add(saveButton);
        centerPanel.add(saveButton1);
        panel.add(centerPanel, BorderLayout.CENTER);
    }
    private class SaveButton1Listener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File("./res/"));
            int result = chooser.showSaveDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File targetFile = chooser.getSelectedFile();
                try {
                    if (!targetFile.exists()) {
                        targetFile.createNewFile();
                    }
                    XMLSaver saver = new XMLSaver(model.getSortedModel());
                    saver.saveByHands(targetFile);
                } catch (IOException exception) {
                    JOptionPane.showMessageDialog(null, "Something wrong with file");
                } catch (ParserConfigurationException parserConfigurationException) {
                    JOptionPane.showMessageDialog(null, "Something wrong with data");
                } catch (TransformerConfigurationException transformerConfigurationException) {
                    JOptionPane.showMessageDialog(null, "Something wrong with parser");
                } catch (TransformerException transformerException) {
                    JOptionPane.showMessageDialog(null, "Something wrong with saving to File");
                }

            }
        }
    }
    private class OpenButtonListener extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File("./res/"));
            int result = chooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION){
                File targetFile = chooser.getSelectedFile();
                String targetFileExtension = getFileExtension(targetFile);
                try {
                    if (!targetFileExtension.equals("") && targetFileExtension.equals("txt")) {
                        FileReader reader = new FileReader();
                        model.setModel(reader.readFile(targetFile));
                    } else if (!targetFileExtension.equals("") && targetFileExtension.equals("xml")) {
                        XMLReader reader = new XMLReader();
                        model.setModel(reader.readData(targetFile));
                    }
                }
                catch (ParserConfigurationException parserConfigurationException) {
                    JOptionPane.showMessageDialog(null, "Something wrong with parser");
                } catch (SAXException saxException) {
                    JOptionPane.showMessageDialog(null, "Something wrong with SAX");
                } catch (IOException exception) {
                    JOptionPane.showMessageDialog(null, "File is incorrect");
                }
            }
        }
        private String getFileExtension(File file){
            String fileName = file.getName();
            if (fileName.lastIndexOf('.') != -1 && fileName.lastIndexOf('.') != 0){
                return fileName.substring(fileName.lastIndexOf('.') + 1);
            }
            return "";
        }
    }
    private class HandleButtonListener extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            if (model.getModel().size() != 0){
                DefaultListModel<Student> m = new DefaultListModel<>();
                List<Student> list = model.getArrayListModel().stream().filter(a -> !a.getUnique()).collect(Collectors.toList());
                list.stream().sorted((s1, s2) -> {
                    if (!s1.getCourse().equals(s2.getCourse())){
                        return s1.getCourse().compareTo(s2.getCourse());
                    } else if (!s1.getGroup().equals(s2.getGroup())){
                        return s1.getGroup().compareTo(s2.getGroup());
                    }else{
                        return s1.getSurname().compareTo(s2.getSurname());
                    }
                }).forEach(m::addElement);
                model.setSortedModel(m);
            }
        }
    }
    private class AddButtonListener extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            Dialog dialog = new Dialog("Dialog window", model);
        }
    }
    private class SaveButtonListener extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File("./res/"));
            int result = chooser.showSaveDialog(null);
            if (result == JFileChooser.APPROVE_OPTION){
                File targetFile = chooser.getSelectedFile();
                try {
                    if (!targetFile.exists()) {
                        targetFile.createNewFile();
                    }
                    XMLSaver saver = new XMLSaver(model.getSortedModel());
                    saver.save(targetFile);
                }
                catch (IOException exception){
                    JOptionPane.showMessageDialog(null, "Something wrong with file");
                } catch (ParserConfigurationException parserConfigurationException) {
                    JOptionPane.showMessageDialog(null, "Something wrong with data");
                } catch (TransformerConfigurationException transformerConfigurationException) {
                    JOptionPane.showMessageDialog(null, "Something wrong with parser");
                } catch (TransformerException transformerException) {
                    JOptionPane.showMessageDialog(null, "Something wrong with saving to File");
                }

            }
        }
    }
}
