/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saxparserdemo;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 *
 * @author Jurica
 */
public class SAXParserDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            File file = new File("klubovi.xml");

            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = parserFactory.newSAXParser();
            KluboviDefaultHandler kluboviDH = new KluboviDefaultHandler();

            saxParser.parse(file, kluboviDH);

        } catch (Exception ex) {
            Logger.getLogger(SAXParserDemo.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
}
