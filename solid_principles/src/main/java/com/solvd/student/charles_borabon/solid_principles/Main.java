package com.solvd.student.charles_borabon.solid_principles;

import com.solvd.student.charles_borabon.solid_principles.dao.Hotel;
import com.solvd.student.charles_borabon.solid_principles.dao.HotelDAO;
import com.solvd.student.charles_borabon.solid_principles.design_patterns.AbstractDAOFactory;
import com.solvd.student.charles_borabon.solid_principles.design_patterns.HotelBuilder;
import com.solvd.student.charles_borabon.solid_principles.design_patterns.HotelDAOFactory;
import com.solvd.student.charles_borabon.solid_principles.design_patterns.HotelDAOProxy;
import com.solvd.student.charles_borabon.solid_principles.design_patterns.HotelFacade;
import com.solvd.student.charles_borabon.solid_principles.design_patterns.HotelView;

public class Main {
    public static void main(String[] args) {
        // Create a new HotelDAO object using the DAOFactory
        AbstractDAOFactory factory = new HotelDAOFactory();
        HotelDAO hotel_dao = factory.create();
        HotelDAOProxy hotel_dao_proxy = new HotelDAOProxy(hotel_dao, hotel_dao.getSqlSessionFactory()); // Pass SqlSessionFactory as needed
        HotelView hotel_view = new HotelView();

        try {
            // Create a new hotel using builder and insert it into the database
            Hotel new_hotel = new HotelBuilder()
                .setHotelName("Hotel California")
                .setAddress("1234 Hotel California St.")
                .setCity("Los Angeles")
                .setState("California")
                .setCountry("USA")
                .setPhone("123-456-7890")
                .build();

            HotelFacade hotel_facade = new HotelFacade(hotel_dao_proxy);
            hotel_facade.createHotel(new_hotel);
            System.out.println("Inserted Hotel ID: " + new_hotel.getHotelId());

            // Read the hotel by ID
            Hotel hotel_from_db = hotel_facade.getHotelById(new_hotel.getHotelId());
            
            // Debugging: Check if hotelFromDB is null
            if (hotel_from_db == null) {
                System.out.println("Hotel could not be found with ID: " + new_hotel.getHotelId());
            } else {
                hotel_view.printHotelDetails(hotel_from_db);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}