package by.epam.nickgrudnitsky.homework5.examples;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class BookHandler extends DefaultHandler {
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Tag " + qName);
        if (qName.equals("book")){
            System.out.println("Book id " + attributes.getValue("id"));
            System.out.println("Amount of pages " + attributes.getValue("pages"));
        }
    }


    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println(new String(ch, start, length));
    }
}
