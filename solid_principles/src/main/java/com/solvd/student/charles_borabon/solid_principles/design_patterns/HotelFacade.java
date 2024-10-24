package com.solvd.student.charles_borabon.solid_principles.design_patterns;

import java.util.List;

import com.solvd.student.charles_borabon.solid_principles.dao.Hotel;

public class HotelFacade {
    private final HotelDAOProxy hotel_dao;

    public HotelFacade(HotelDAOProxy hotelDAO) {
        this.hotel_dao = hotelDAO;
    }

    // Method to create a hotel
    public void createHotel(Hotel hotel) {
        hotel_dao.create(hotel);
        System.out.println("Hotel created: " + hotel.getHotelName());
    }

    // Method to get hotel by ID
    public Hotel getHotelById(int id) {
        Hotel hotel = hotel_dao.read(id);
        if (hotel != null) {
            System.out.println("Hotel found: " + hotel.getHotelName());
        } else {
            System.out.println("Hotel not found with ID: " + id);
        }
        return hotel;
    }

    // Method to update a hotel
    public void updateHotel(Hotel hotel) {
        hotel_dao.update(hotel);
        System.out.println("Hotel updated: " + hotel.getHotelName());
    }

    // Method to delete a hotel
    public void deleteHotel(int id) {
        hotel_dao.delete(id);
        System.out.println("Hotel deleted with ID: " + id);
    }

    // Method to get all hotels
    public List<Hotel> getAllHotels() {
        List<Hotel> hotels = hotel_dao.getAll();
        System.out.println("Retrieved " + hotels.size() + " hotels.");
        return hotels;
    }
}