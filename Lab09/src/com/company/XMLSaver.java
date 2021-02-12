package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class XMLSaver {
    private final DefaultListModel<Student> students;
    private final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    public XMLSaver(DefaultListModel<Student> students){
        this.students = students;
    }
    public void save(File file) throws ParserConfigurationException, TransformerException {
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        Element rootElement = document.createElement("students");
        document.appendChild(rootElement);
        for (int i = 0; i < students.size(); i++){
            rootElement.appendChild(addStudent(document, i));
        }
        DOMSource source = new DOMSource(document);
        StreamResult saverFile = new StreamResult(file);
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer();
        transformer.transform(source, saverFile);
    }
    public void saveByHands(File file) throws IOException, ParserConfigurationException, TransformerException {
        FileWriter writer = new FileWriter(file);
        writer.write("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n");
        writer.write("<students>\n");
        for (int i = 0; i < students.size(); i++){
            StringBuilder builder = new StringBuilder();
            builder.append("\t<student ");
            builder.append("id = \"").append(students.getElementAt(i).getId()).append("\" ");
            builder.append("name = \"").append(students.getElementAt(i).getSurname()).append("\" ");
            builder.append("course = \"").append(students.getElementAt(i).getCourse()).append("\" ");
            builder.append("group = \"").append(students.getElementAt(i).getGroup()).append("\"");
            builder.append("/>\n");
            writer.write(String.valueOf(builder));
        }
        writer.write("</students>");
        writer.close();
    }
    private Element addStudent(Document document, int index){
        Element studentElement = document.createElement("student");
        studentElement.setAttribute("id", students.getElementAt(index).getId().toString());
        studentElement.setAttribute("name", students.getElementAt(index).getSurname());
        studentElement.setAttribute("course", students.getElementAt(index).getCourse().toString());
        studentElement.setAttribute("group", students.getElementAt(index).getGroup().toString());
        return studentElement;
    }
}
