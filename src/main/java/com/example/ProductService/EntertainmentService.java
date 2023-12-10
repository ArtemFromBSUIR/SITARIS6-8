package com.example.ProductService;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

public class EntertainmentService {
    private List<Entertainment> entertainments;

    public List<Entertainment> getAllEntertainments() {
        return entertainments;
    }

    public EntertainmentService(String filePath) {
        loadEntertainments(filePath);
    }

    private void loadEntertainments(String filePath) {
        try {
            entertainments = new ArrayList<>();

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            Document doc = factory.newDocumentBuilder().parse(filePath);

            NodeList entertainmentList = doc.getElementsByTagName("entertainment");

            for (int i = 0; i < entertainmentList.getLength(); i++) {
                Element entertainmentElement = (Element) entertainmentList.item(i);
                String name = entertainmentElement.getElementsByTagName("name").item(0).getTextContent();
                String category = entertainmentElement.getElementsByTagName("category").item(0).getTextContent();
                String description = entertainmentElement.getElementsByTagName("description").item(0).getTextContent();
                String place = entertainmentElement.getElementsByTagName("place").item(0).getTextContent();
                double price = Double.parseDouble(entertainmentElement.getElementsByTagName("price").item(0).getTextContent());

                Entertainment entertainment = new Entertainment(name, category, description, place, price);
                entertainments.add(entertainment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public double calculateTotalCost() {
        double totalCost = 0;
        for (Entertainment entertainment : entertainments) {
            totalCost += entertainment.getPrice();
        }
        return totalCost;
    }

}
