package com.solvd.student.charles_borabon.mybatis.dao;

public class Hotel {
    private int hotel_id;
    private String hotel_name;
    private String address;
    private String city;
    private String state;
    private String country;
    private String phone;

    // Getters and Setters
    public int getHotelId() {
        return hotel_id;
    }

    public void setHotelId(int hotelId) {
        this.hotel_id = hotelId;
    }

    public String getHotelName() {
        return hotel_name;
    }

    public void setHotelName(String hotelName) {
        this.hotel_name = hotelName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}