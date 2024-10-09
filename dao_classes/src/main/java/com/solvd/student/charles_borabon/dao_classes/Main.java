package com.solvd.student.charles_borabon.dao_classes;

import java.sql.SQLException;
import java.util.List;

import com.solvd.student.charles_borabon.dao_classes.dao.Hotel;
import com.solvd.student.charles_borabon.dao_classes.dao.HotelDAO;
public class Main {
    public static void main(String[] args) {
        HotelDAO hotelDAO = new HotelDAO();
        
        // Test create operation
        Hotel newHotel = new Hotel();
        newHotel.setHotelName("Grand Palace");
        newHotel.setAddress("123 Royal St");
        newHotel.setCity("London");
        newHotel.setState("Greater London");
        newHotel.setCountry("UK");
        newHotel.setPhone("123-456-7890");

        try {
            // Create new hotel
            hotelDAO.create(newHotel);
            System.out.println("New hotel created with ID: " + newHotel.getHotelId());

            // Read the hotel back from the database
            Hotel retrievedHotel = hotelDAO.read(newHotel.getHotelId());
            if (retrievedHotel != null) {
                System.out.println("Hotel retrieved: " + retrievedHotel.getHotelName() + ", " + retrievedHotel.getAddress());
            }

            // Update the hotel
            if (retrievedHotel != null) {
                retrievedHotel.setPhone("987-654-3210");
                hotelDAO.update(retrievedHotel);
                System.out.println("Hotel updated with new phone: " + retrievedHotel.getPhone());
            } else {
                System.err.println("Error: Retrieved hotel is null, cannot update phone.");
            }

            // Retrieve all hotels
            List<Hotel> hotels = hotelDAO.getAll();
            System.out.println("All hotels:");
            for (Hotel hotel : hotels) {
                System.out.println(hotel.getHotelId() + ": " + hotel.getHotelName() + " - " + hotel.getAddress());
            }

            // Delete the hotel
            hotelDAO.delete(newHotel.getHotelId());
            System.out.println("Hotel deleted with ID: " + newHotel.getHotelId());

        } catch (SQLException e) {
            System.err.println("Error during HotelDAO operations: " + e.getMessage());
        }
    }
}