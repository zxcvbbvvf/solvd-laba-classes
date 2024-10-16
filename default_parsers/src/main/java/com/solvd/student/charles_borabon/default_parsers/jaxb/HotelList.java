package com.solvd.student.charles_borabon.default_parsers.jaxb;

import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "hotels")
@XmlType(propOrder = {"hotel_id", "hotel_name", "address", "city", "state", "country", "phone"})
public class HotelList {

    private List<Hotel> hotels;

    @XmlElement(name = "hotel")
    public List<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }
}

@XmlType(propOrder = {"hotel_id", "hotel_name", "address", "city", "state", "country", "phone"})
class Hotel {
    private int hotel_id;
    private String hotel_name;
    private String address;
    private String city;
    private String state;
    private String country;
    private String phone;

    // Getters and Setters
    @XmlElement
    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    @XmlElement
    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    @XmlElement
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @XmlElement
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @XmlElement
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @XmlElement
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @XmlElement
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}