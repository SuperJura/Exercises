/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saxparserdemo;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Jurica
 */
public class KluboviDefaultHandler extends DefaultHandler{
    
    String currentElement;
    @Override
    public void startDocument() throws SAXException {
        System.out.println("Hello startDocument");
    }
       

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("Klub") || qName.equals("Klubovi")) {
            currentElement = "";
        }
        else{
            currentElement = qName;
                
            if (attributes.getLength() > 0) {
                System.out.println("\tATTRIBUTES:");
            }
            for (int i = 0; i < attributes.getLength(); i++) {
                System.out.print("\t" + attributes.getLocalName(i) + ": ");
                System.out.println(attributes.getValue(i));
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (!"".equals(currentElement)) {
            System.out.println(currentElement + ": " + new String(ch, start, length));
            currentElement = "";
        }
    }
}
