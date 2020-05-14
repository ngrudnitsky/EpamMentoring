package by.epam.nickgrudnitsky.homework5.examples;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DomParser {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        File file = new File(
                "/Users/Nikita/IdeaProjects/EpamMentoring/src/main/resources/items.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);

        System.out.println("Root element " + document.getDocumentElement().getNodeName());

        NodeList books = document.getElementsByTagName("book");
        for (int i = 0; i < books.getLength(); i++) {
            Node node = books.item(i);
            System.out.println(node.getNodeName());

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("Book id " + element.getAttribute("id"));
                System.out.println("Author " + element.getElementsByTagName("author").item(0).getTextContent());
            }
        }

    }
}
