package com.company.parser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MaxTransparencyHandler extends DefaultHandler {
    private GemEnum currentEnum = null;
    private int answer;
    public int getAnswer(){
        return answer;
    }
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (GemEnum.TRANSPARENCY.getValue().equals(localName)){
            currentEnum = GemEnum.TRANSPARENCY;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (GemEnum.TRANSPARENCY.getValue().equals(localName)){
            currentEnum = null;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentEnum != null){
            String s = new String(ch, start, length).trim();
            int transparency = Integer.parseInt(s);
            if (transparency > answer){
                answer = transparency;
            }
        }
    }
}
