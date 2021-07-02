package com.company.writer;

import com.company.entity.ArtificialGem;
import com.company.entity.Gem;
import com.company.entity.NaturalGem;
import com.company.parser.GemEnum;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

public class DOMWriter {
    private DocumentBuilder builder;
    private Transformer transformer;

    public DOMWriter(){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        try {
            builder = factory.newDocumentBuilder();
            transformer = transformerFactory.newTransformer();
        } catch (TransformerConfigurationException e) {
            JOptionPane.showMessageDialog(null, "Problems with transformer");
        } catch (ParserConfigurationException e) {
            JOptionPane.showMessageDialog(null, "Problems with parser");
        }
    }
    public void write(List<Gem> list, String pathName) throws TransformerException {
        Document document = builder.newDocument();
        Element root = document.createElement(GemEnum.GEMS.getValue());
        root.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
        root.setAttribute("xmlns", "http://www.example.org/gems");
        root.setAttribute("xsi:schemaLocation", "http://www.example.org/gems gems.xsd");
        document.appendChild(root);
        for (var element : list){
            root.appendChild(getGem(document, element));
        }
        DOMSource source = new DOMSource(document);
        StreamResult file = new StreamResult(new File(pathName));
        transformer.transform(source, file);

    }
    private Node getGem(Document document, Gem gem){
        Element element;
        if (gem.getClass() == NaturalGem.class){
            NaturalGem naturalGem = (NaturalGem) gem;
            element = document.createElement(GemEnum.NATURAL_GEM.getValue());
            element.setAttribute(GemEnum.ID.getValue(), gem.getId());
            element.setAttribute(GemEnum.WEIGHT.getValue(), Integer.toString(gem.getValue()));
            element.appendChild(getGemElement(document, GemEnum.NAME.getValue(), gem.getName()));
            element.appendChild(getGemElement(document, GemEnum.PRECIOUSNESS.getValue(), gem.getPreciousness().toString()));
            element.appendChild(getGemNestedElement(document, GemEnum.VISUAL_PARAMETERS.getValue(), gem.getParameters()));
            element.appendChild(getGemElement(document, GemEnum.CREATION_DATE.getValue(), gem.getCreationDate().toString()));
            element.appendChild(getGemElement(document, GemEnum.EXTRACTION_PLACE.getValue(), naturalGem.getPlace().toString()));
        }else{
            ArtificialGem artificialGem = (ArtificialGem) gem;
            element = document.createElement(GemEnum.ARTIFICIAL_GEM.getValue());
            element.setAttribute(GemEnum.ID.getValue(), gem.getId());
            element.setAttribute(GemEnum.WEIGHT.getValue(), Integer.toString(gem.getValue()));
            element.appendChild(getGemElement(document, GemEnum.NAME.getValue(), gem.getName()));
            element.appendChild(getGemElement(document, GemEnum.PRECIOUSNESS.getValue(), gem.getPreciousness().toString()));
            element.appendChild(getGemNestedElement(document, GemEnum.VISUAL_PARAMETERS.getValue(), gem.getParameters()));
            element.appendChild(getGemElement(document, GemEnum.CREATION_DATE.getValue(), gem.getCreationDate().toString()));
            element.appendChild(getGemElement(document, GemEnum.GROWING_TIME.getValue(), Integer.toString(artificialGem.getGrowingTime())));
        }
        /*element.setAttribute(GemEnum.ID.getValue(), gem.getId());
        element.setAttribute(GemEnum.WEIGHT.getValue(), Integer.toString(gem.getValue()));
        element.appendChild(getGemElement(document, GemEnum.NAME.getValue(), gem.getName()));
        element.appendChild(getGemElement(document, GemEnum.PRECIOUSNESS.getValue(), gem.getPreciousness().toString()));
        element.appendChild(getGemNestedElement(document, GemEnum.VISUAL_PARAMETERS.getValue(), gem.getParameters()));
        element.appendChild(getGemElement(document, GemEnum.CREATION_DATE.getValue(), gem.getCreationDate().toString()));
        */return element;
    }
    private Node getGemElement(Document document, String name, String value){
        Element node = document.createElement(name);
        node.appendChild(document.createTextNode(value));
        return node;
    }
    private Node getGemNestedElement(Document document, String name, Gem.VisualParameters parameters){
        Element node = document.createElement(name);
        node.appendChild(getGemElement(document, GemEnum.COLOR.getValue(), parameters.getColor()));
        node.appendChild(getGemElement(document, GemEnum.TRANSPARENCY.getValue(), Integer.toString(parameters.getTransparency())));
        node.appendChild(getGemElement(document, GemEnum.EDGE_AMOUNT.getValue(), Integer.toString(parameters.getEdgeAmount())));
        return node;
    }
}
