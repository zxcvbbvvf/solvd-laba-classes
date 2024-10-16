package com.solvd.student.charles_borabon.default_parsers.parsers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class XMLStAXParser {

    private String xmlFilePath;

    // Constructor to initialize the XML file path
    public XMLStAXParser(String xmlFilePath) {
        this.xmlFilePath = xmlFilePath;
    }

    // Method to parse the XML file dynamically with rootElement argument
    public void parseXML(String rootElement) {
        FileInputStream inputStream = null;
        try {
            // Create an XMLInputFactory instance
            XMLInputFactory factory = XMLInputFactory.newInstance();
            
            // Open the input stream for the XML file
            inputStream = new FileInputStream(this.xmlFilePath);
            XMLEventReader eventReader = factory.createXMLEventReader(inputStream);

            // Variables to hold element data
            String currentElement = "";
            String elementValue = "";

            // Read through the XML file
            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();

                // Check if the event is a start element
                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();
                    currentElement = startElement.getName().getLocalPart();
                }

                // Check if the event is a character event (text inside an element)
                if (event.isCharacters()) {
                    Characters characters = event.asCharacters();
                    elementValue = characters.getData().trim();
                }

                // Check if the event is an end element (output and reset for each record)
                if (event.isEndElement()) {
                    if (event.asEndElement().getName().getLocalPart().equals(rootElement)) {
                        // Output collected data (for one complete record)
                        System.out.println("---------------------------------");
                    } else if (!elementValue.isEmpty()) {
                        // Print the element name and value
                        System.out.println(currentElement + ": " + elementValue);
                        elementValue = ""; // Reset the value for the next element
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: The XML file was not found. Please check the file path: " + this.xmlFilePath);
        } catch (XMLStreamException e) {
            System.out.println("Error: An issue occurred while processing the XML file. Details: " + e.getMessage());
        } finally {
            // Close the input stream in the finally block to ensure it's always closed
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    System.out.println("Error: Failed to close the input stream. Details: " + e.getMessage());
                }
            }
        }
    }
}