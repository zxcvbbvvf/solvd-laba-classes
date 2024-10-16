package com.solvd.student.charles_borabon.default_parsers;

import java.io.File;

import com.solvd.student.charles_borabon.default_parsers.jaxb.Booking;
import com.solvd.student.charles_borabon.default_parsers.jaxb.BookingList;
import com.solvd.student.charles_borabon.default_parsers.jaxb.Customer;
import com.solvd.student.charles_borabon.default_parsers.jaxb.CustomerList;
import com.solvd.student.charles_borabon.default_parsers.jaxb.Hotel;
import com.solvd.student.charles_borabon.default_parsers.jaxb.HotelList;
import com.solvd.student.charles_borabon.default_parsers.jaxb.Room;
import com.solvd.student.charles_borabon.default_parsers.jaxb.RoomList;
import com.solvd.student.charles_borabon.default_parsers.jaxb.RoomType;
import com.solvd.student.charles_borabon.default_parsers.jaxb.RoomTypeList;
import com.solvd.student.charles_borabon.default_parsers.parsers.XMLStAXParser;
import com.solvd.student.charles_borabon.default_parsers.validators.XMLValidator;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

public class Main {

    public static void main(String[] args) {
        System.out.println("XML Parsing and Validation\n");
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

        
        System.out.println("\n\nXML Parsing\n");
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


        System.out.println("\n\n JAXB Test\n");
        // JAXB test
        try {
            // Unmarshal Hotels XML
            JAXBContext hotelsContext = JAXBContext.newInstance(HotelList.class);
            Unmarshaller hotelsUnmarshaller = hotelsContext.createUnmarshaller();
            File hotelsFile = new File("src/main/java/com/solvd/student/charles_borabon/default_parsers/xml/hotels.xml");
            HotelList hotelList = (HotelList) hotelsUnmarshaller.unmarshal(hotelsFile);
            System.out.println("Hotels:");
            for (Hotel hotel : hotelList.getHotels()) {
                System.out.println("Hotel ID: " + hotel.getHotel_id());
                System.out.println("Hotel Name: " + hotel.getHotel_name());
                System.out.println("Address: " + hotel.getAddress());
                System.out.println("City: " + hotel.getCity());
                System.out.println("State: " + hotel.getState());
                System.out.println("Country: " + hotel.getCountry());
                System.out.println("Phone: " + hotel.getPhone());
                System.out.println("---------------------------------");
            }

            // Unmarshal Room Types XML
            JAXBContext roomTypesContext = JAXBContext.newInstance(RoomTypeList.class);
            Unmarshaller roomTypesUnmarshaller = roomTypesContext.createUnmarshaller();
            File roomTypesFile = new File("src/main/java/com/solvd/student/charles_borabon/default_parsers/xml/room_types.xml");
            RoomTypeList roomTypeList = (RoomTypeList) roomTypesUnmarshaller.unmarshal(roomTypesFile);
            System.out.println("Room Types:");
            for (RoomType roomType : roomTypeList.getRoomTypes()) {
                System.out.println("Room Type ID: " + roomType.getRoom_type_id());
                System.out.println("Room Type Name: " + roomType.getRoom_type_name());
                System.out.println("---------------------------------");
            }

            // Unmarshal Rooms XML
            JAXBContext roomsContext = JAXBContext.newInstance(RoomList.class);
            Unmarshaller roomsUnmarshaller = roomsContext.createUnmarshaller();
            File roomsFile = new File("src/main/java/com/solvd/student/charles_borabon/default_parsers/xml/rooms.xml");
            RoomList roomList = (RoomList) roomsUnmarshaller.unmarshal(roomsFile);
            System.out.println("Rooms:");
            for (Room room : roomList.getRooms()) {
                System.out.println("Room ID: " + room.getRoom_id());
                System.out.println("Hotel ID: " + room.getHotel_id());
                System.out.println("Room Type ID: " + room.getRoom_type_id());
                System.out.println("Room Number: " + room.getRoom_number());
                System.out.println("Price per Night: " + room.getPrice_per_night());
                System.out.println("Availability Status: " + room.isAvailability_status());
                System.out.println("---------------------------------");
            }

            // Unmarshal Customers XML
            JAXBContext customersContext = JAXBContext.newInstance(CustomerList.class);
            Unmarshaller customersUnmarshaller = customersContext.createUnmarshaller();
            File customersFile = new File("src/main/java/com/solvd/student/charles_borabon/default_parsers/xml/customers.xml");
            CustomerList customerList = (CustomerList) customersUnmarshaller.unmarshal(customersFile);
            System.out.println("Customers:");
            for (Customer customer : customerList.getCustomers()) {
                System.out.println("Customer ID: " + customer.getCustomer_id());
                System.out.println("First Name: " + customer.getFirst_name());
                System.out.println("Last Name: " + customer.getLast_name());
                System.out.println("Email: " + customer.getEmail());
                System.out.println("Phone: " + customer.getPhone());
                System.out.println("---------------------------------");
            }

            // Unmarshal Bookings XML
            JAXBContext bookingsContext = JAXBContext.newInstance(BookingList.class);
            Unmarshaller bookingsUnmarshaller = bookingsContext.createUnmarshaller();
            File bookingsFile = new File("src/main/java/com/solvd/student/charles_borabon/default_parsers/xml/bookings.xml");
            BookingList bookingList = (BookingList) bookingsUnmarshaller.unmarshal(bookingsFile);
            System.out.println("Bookings:");
            for (Booking booking : bookingList.getBookings()) {
                System.out.println("Booking ID: " + booking.getBooking_id());
                System.out.println("Customer ID: " + booking.getCustomer_id());
                System.out.println("Room ID: " + booking.getRoom_id());
                System.out.println("Booking Date: " + booking.getBooking_date());
                System.out.println("Check-in Date: " + booking.getCheck_in_date());
                System.out.println("Check-out Date: " + booking.getCheck_out_date());
                System.out.println("Total Price: " + booking.getTotal_price());
                System.out.println("Payment Status: " + booking.isPayment_status());
                System.out.println("---------------------------------");
            }

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}