package com.solvd.student.charles_borabon.solid_principles.design_patterns;

import com.solvd.student.charles_borabon.solid_principles.dao.Hotel;

public class HotelBuilder {
    private String hotel_name;
    private String address;
    private String city;
    private String state;
    private String country;
    private String phone;

    public HotelBuilder setHotelName(String hotel_name) {
        this.hotel_name = hotel_name;
        return this;
    }

    public HotelBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public HotelBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public HotelBuilder setState(String state) {
        this.state = state;
        return this;
    }

    public HotelBuilder setCountry(String country) {
        this.country = country;
        return this;
    }

    public HotelBuilder setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Hotel build() {
        Hotel hotel = new Hotel();
        hotel.setHotelName(hotel_name);
        hotel.setAddress(address);
        hotel.setCity(city);
        hotel.setState(state);
        hotel.setCountry(country);
        hotel.setPhone(phone);
        return hotel;
    }
}