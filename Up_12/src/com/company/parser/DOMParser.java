package com.company.parser;

import com.company.entity.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class DOMParser {
    private final static DOMParser parser = new DOMParser();
    private DocumentBuilder builder;
    private final List<Gem> gems = new ArrayList<>();
    public static DOMParser getInstance(){
        return parser;
    }
    private DOMParser(){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            JOptionPane.showMessageDialog(null, "Problems with parser");
        }
    }
    public List<Gem> getGems(){
        ArrayList<Gem> newGems = new ArrayList<>(gems);
        gems.clear();
        return newGems;
    }
    public void buildSetGems(String filename){
        Document document = null;
        try{
            document = builder.parse(filename);
            Element root = document.getDocumentElement();
            NodeList naturalGemList = root.getElementsByTagName(GemEnum.NATURAL_GEM.getValue());
            for (int i = 0; i < naturalGemList.getLength(); i++){
                Element gemElement = (Element) naturalGemList.item(i);
                NaturalGem gem = buildNaturalGem(gemElement);
                gems.add(gem);
            }
            NodeList artificialGemList = root.getElementsByTagName(GemEnum.ARTIFICIAL_GEM.getValue());
            for (int i = 0; i < artificialGemList.getLength(); i++){
                Element gemElement = (Element) artificialGemList.item(i);
                ArtificialGem gem = buildArtificialGem(gemElement);
                gems.add(gem);
            }
        } catch (SAXException e) {
            JOptionPane.showMessageDialog(null, "Problems with parsing");
        } catch (IOException exception) {
            JOptionPane.showMessageDialog(null, "Problems with file");
        }
    }
    private NaturalGem buildNaturalGem(Element gemElement){
        NaturalGem gem = new NaturalGem();
        buildGem(gem, gemElement);
        String extractionPlace = getElementTextContent(gemElement, GemEnum.EXTRACTION_PLACE.getValue()).toUpperCase().replace('-', '_');
        gem.setPlace(ExtractionPlace.valueOf(extractionPlace));
        return gem;
    }
    private ArtificialGem buildArtificialGem(Element gemElement){
        ArtificialGem gem = new ArtificialGem();
        buildGem(gem, gemElement);
        gem.setGrowingTime(Integer.parseInt(getElementTextContent(gemElement, GemEnum.GROWING_TIME.getValue())));
        return gem;
    }
    private void buildGem(Gem gem, Element gemElement){
        gem.setId(gemElement.getAttribute(GemEnum.ID.getValue()));
        if (gemElement.hasAttribute(GemEnum.WEIGHT.getValue())){
            gem.setWeight(Integer.parseInt(gemElement.getAttribute(GemEnum.WEIGHT.getValue())));
        }else{
            gem.setWeight(1);
        }
        gem.setName(getElementTextContent(gemElement, GemEnum.NAME.getValue()));
        String preciousness = getElementTextContent(gemElement, GemEnum.PRECIOUSNESS.getValue()).toUpperCase();
        gem.setPreciousness(Preciousness.valueOf(preciousness));
        gem.setCreationDate(YearMonth.parse(getElementTextContent(gemElement, GemEnum.CREATION_DATE.getValue())));
        Gem.VisualParameters parameters = gem.getParameters();
        Element parameter = (Element) gemElement.getElementsByTagName(GemEnum.VISUAL_PARAMETERS.getValue()).item(0);
        parameters.setColor(getElementTextContent(parameter, GemEnum.COLOR.getValue()));
        parameters.setEdgeAmount(Integer.parseInt(getElementTextContent(parameter, GemEnum.EDGE_AMOUNT.getValue())));
        parameters.setTransparency(Integer.parseInt(getElementTextContent(parameter, GemEnum.TRANSPARENCY.getValue())));
    }
    private static String getElementTextContent(Element element, String elementName){
        NodeList list = element.getElementsByTagName(elementName);
        Node node = list.item(0);
        String text = node.getTextContent();
        return text;
    }
}
