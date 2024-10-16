package com.solvd.student.charles_borabon.default_parsers.validators;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class XMLValidator {
    private String xmlPath;
    private String xsdPath;

    // Constructor to initialize paths
    public XMLValidator(String xsdPath, String xmlPath) {
        this.xsdPath = xsdPath;
        this.xmlPath = xmlPath;
    }

    // Method to set XML path dynamically
    public void setXmlPath(String xmlPath) {
        this.xmlPath = xmlPath;
    }

    // Method to set XSD path dynamically
    public void setXsdPath(String xsdPath) {
        this.xsdPath = xsdPath;
    }

    // Method to validate XML against the current XSD
    public boolean validateXMLSchema() {
        try {
            // Create a SchemaFactory for the W3C XML Schema (XSD)
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            
            // Load the XSD file
            Schema schema = factory.newSchema(new File(this.xsdPath));
            
            // Create a Validator object based on the schema
            Validator validator = schema.newValidator();
            
            // Validate the XML file
            validator.validate(new StreamSource(new File(this.xmlPath)));
            System.out.println("The XML file is valid against the XSD schema.");
            return true;
        } catch (IOException | SAXException e) {
            System.out.println("Validation error: " + e.getMessage());
            return false;
        }
    }
}
