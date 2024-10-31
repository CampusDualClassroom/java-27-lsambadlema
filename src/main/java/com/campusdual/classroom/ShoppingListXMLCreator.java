package com.campusdual.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class ShoppingListXMLCreator {
    public static void createDocument() throws ParserConfigurationException, TransformerException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();


        document.setXmlStandalone(false);


        Element root = document.createElement("shoppinglist");
        document.appendChild(root);
        Element items = document.createElement("items");
        root.appendChild(items);

        items.appendChild(createItem(document, "item", "quantity", "2", "Manzana"));
        items.appendChild(createItem(document, "item", "quantity", "1", "Leche"));
        items.appendChild(createItem(document, "item", "quantity", "3", "Pan"));
        items.appendChild(createItem(document, "item", "quantity", "2", "Huevo"));
        items.appendChild(createItem(document, "item", "quantity", "1", "Queso"));
        items.appendChild(createItem(document, "item", "quantity", "1", "Cereal"));
        items.appendChild(createItem(document, "item", "quantity", "4", "Agua"));
        items.appendChild(createItem(document, "item", "quantity", "6", "Yogur"));
        items.appendChild(createItem(document, "item", "quantity", "2", "Arroz"));
        writeToFile(document, "src/main/resources/shoppingList.xml");
    }

    private static void writeToFile(Document document, String pathFile) throws TransformerException {
        File file = new File("src/main/resources");
        if (!file.exists()) {
            file.mkdirs();
        }

        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "3");

        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new File(pathFile));
        transformer.transform(source, result);
    }

    private static Element createItem(Document document, String tagName, String attribute, String attrValue, String textContent) {
        Element item = document.createElement(tagName);
        item.setAttribute(attribute, attrValue);
        item.setTextContent(textContent);
        return item;
    }
}
