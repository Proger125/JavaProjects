package com.company.parser;

import com.company.entity.Gem;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MinEdgeAmountHandler extends DefaultHandler {
    private GemEnum currentEnum = null;
    private int answer = Integer.MAX_VALUE;
    public int getAnswer(){
        return answer;
    }
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (GemEnum.EDGE_AMOUNT.getValue().equals(localName)){
            currentEnum = GemEnum.EDGE_AMOUNT;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (GemEnum.EDGE_AMOUNT.getValue().equals(localName)){
            currentEnum = null;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentEnum != null){
            String s = new String(ch, start, length).trim();
            int amount = Integer.parseInt(s);
            if (amount < answer){
                answer = amount;
            }
        }
    }
}
