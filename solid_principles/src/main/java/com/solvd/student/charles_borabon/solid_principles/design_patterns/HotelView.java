package com.solvd.student.charles_borabon.solid_principles.design_patterns;

import com.solvd.student.charles_borabon.solid_principles.dao.Hotel;

public class HotelView {
    public void printHotelDetails(Hotel hotel) {
        System.out.println("Hotel Name: " + hotel.getHotelName());
        System.out.println("Address: " + hotel.getAddress());
        System.out.println("City: " + hotel.getCity());
        System.out.println("State: " + hotel.getState());
        System.out.println("Country: " + hotel.getCountry());
        System.out.println("Phone: " + hotel.getPhone());
    }
}
