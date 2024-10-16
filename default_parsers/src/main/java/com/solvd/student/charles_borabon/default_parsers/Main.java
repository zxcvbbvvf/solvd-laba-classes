package com.solvd.student.charles_borabon.default_parsers;

import com.solvd.student.charles_borabon.default_parsers.validators.XMLValidator;

public class Main {

    public static void main(String[] args) {
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
    }
}
