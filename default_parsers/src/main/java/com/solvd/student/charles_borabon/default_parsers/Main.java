package com.solvd.student.charles_borabon.default_parsers;

import com.solvd.student.charles_borabon.default_parsers.parsers.XMLStAXParser;
import com.solvd.student.charles_borabon.default_parsers.validators.XMLValidator;

public class Main {

    public static void main(String[] args) {
        // XMLVAlidator test
        // Create an XMLValidator object for hotels
        XMLValidator validator = new XMLValidator("src/main/java/com/solvd/student/charles_borabon/default_parsers/xsd/hotels.xsd", "src/main/java/com/solvd/student/charles_borabon/default_parsers/xml/hotels.xml");
        
        // Validate the XML file against the XSD schema
        validator.validateXMLSchema();

        // set xml path and xsd path to room_types
        validator.setXmlPath("src/main/java/com/solvd/student/charles_borabon/default_parsers/xml/room_types.xml");
        validator.setXsdPath("src/main/java/com/solvd/student/charles_borabon/default_parsers/xsd/room_types.xsd");

        // Validate the XML file against the XSD schema
        validator.validateXMLSchema();

        // set xml path and xsd path to rooms
        validator.setXmlPath("src/main/java/com/solvd/student/charles_borabon/default_parsers/xml/rooms.xml");
        validator.setXsdPath("src/main/java/com/solvd/student/charles_borabon/default_parsers/xsd/rooms.xsd");

        // Validate the XML file against the XSD schema
        validator.validateXMLSchema();

        // set xml path and xsd path to customers
        validator.setXmlPath("src/main/java/com/solvd/student/charles_borabon/default_parsers/xml/customers.xml");
        validator.setXsdPath("src/main/java/com/solvd/student/charles_borabon/default_parsers/xsd/customers.xsd");

        // Validate the XML file against the XSD schema
        validator.validateXMLSchema();

        // set xml path and xsd path to bookings
        validator.setXmlPath("src/main/java/com/solvd/student/charles_borabon/default_parsers/xml/bookings.xml");
        validator.setXsdPath("src/main/java/com/solvd/student/charles_borabon/default_parsers/xsd/bookings.xsd");

        // Validate the XML file against the XSD schema
        validator.validateXMLSchema();

        
        // XMLStAXParser test
         // Create an instance of XMLStAXParser for hotels.xml
        XMLStAXParser hotelsParser = new XMLStAXParser("src/main/java/com/solvd/student/charles_borabon/default_parsers/xml/hotels.xml");
        System.out.println("Parsing Hotels XML:");
        hotelsParser.parseXML("hotel"); // "hotel" is the root element for hotels

        // Create an instance of XMLStAXParser for room_types.xml
        XMLStAXParser roomTypesParser = new XMLStAXParser("src/main/java/com/solvd/student/charles_borabon/default_parsers/xml/room_types.xml");
        System.out.println("\nParsing Room Types XML:");
        roomTypesParser.parseXML("room_type"); // "room_type" is the root element for room types

        // Create an instance of XMLStAXParser for rooms.xml
        XMLStAXParser roomsParser = new XMLStAXParser("src/main/java/com/solvd/student/charles_borabon/default_parsers/xml/rooms.xml");
        System.out.println("\nParsing Rooms XML:");
        roomsParser.parseXML("room"); // "room" is the root element for rooms

        // Create an instance of XMLStAXParser for customers.xml
        XMLStAXParser customersParser = new XMLStAXParser("src/main/java/com/solvd/student/charles_borabon/default_parsers/xml/customers.xml");
        System.out.println("\nParsing Customers XML:");
        customersParser.parseXML("customer"); // "customer" is the root element for customers

        // Create an instance of XMLStAXParser for bookings.xml
        XMLStAXParser bookingsParser = new XMLStAXParser("src/main/java/com/solvd/student/charles_borabon/default_parsers/xml/bookings.xml");
        System.out.println("\nParsing Bookings XML:");
        bookingsParser.parseXML("booking"); // "booking" is the root element for bookings
    }
}
