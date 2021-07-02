package com.company.validator;

import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;


public class XMLValidator {
    private XMLValidator(){}
    public static boolean validateXML(String fileName){
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try{
            Schema schema = factory.newSchema(Thread.currentThread().getContextClassLoader().getResource("gems.xsd"));
            Validator validator = schema.newValidator();
            Source source = new StreamSource(fileName);
            validator.validate(source);
        } catch (IOException exception) {
            JOptionPane.showMessageDialog(null, "Filename is incorrect");
        } catch (SAXException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
        return true;
    }
}
