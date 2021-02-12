package com.company;

import javax.swing.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class XMLReader {
    private final DefaultListModel<Student> students = new DefaultListModel<>();
    public DefaultListModel<Student> readData(File file) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        XMLHandler handler = new XMLHandler();
        parser.parse(file, handler);
        return students;
    }
    private class XMLHandler extends DefaultHandler{
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("student")){
                int id = Integer.parseInt(attributes.getValue("id"));
                String name = attributes.getValue("name");
                int course = Integer.parseInt(attributes.getValue("course"));
                int group = Integer.parseInt(attributes.getValue("group"));
                students.addElement(new Student(id, name, course, group));
            }
        }
    }
}
