package com.company.parser;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.swing.*;
import java.io.IOException;

public class SAXParser {
    private final static SAXParser parser = new SAXParser();
    private DefaultHandler handler;
    private XMLReader reader;
    public static SAXParser getInstance(){
        return parser;
    }
    private SAXParser(){
        try {
            reader = XMLReaderFactory.createXMLReader();
        } catch (SAXException e) {
            JOptionPane.showMessageDialog(null, "Problems with parsing");
        }
    }
    public int calcMinEdgeAmount(String filename){
        this.handler = new MinEdgeAmountHandler();
        reader.setContentHandler(this.handler);
        try{
            reader.parse(filename);
        } catch (SAXException e) {
            JOptionPane.showMessageDialog(null, "Problems with parsing");
        } catch (IOException exception) {
            JOptionPane.showMessageDialog(null, "Incorrect filename");
        }
        return ((MinEdgeAmountHandler) handler).getAnswer();
    }
    public int calcMaxTransparency(String filename){
        this.handler = new MaxTransparencyHandler();
        reader.setContentHandler(this.handler);
        try {
            reader.parse(filename);
        } catch (SAXException e) {
            JOptionPane.showMessageDialog(null, "Problems with parsing");
        } catch (IOException exception) {
            JOptionPane.showMessageDialog(null, "Incorrect filename");
        }
        return ((MaxTransparencyHandler) handler).getAnswer();
    }
}
