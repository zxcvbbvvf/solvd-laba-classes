package com.solvd.student.charles_borabon.default_parsers.jaxb;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"room_id", "hotel_id", "room_type_id", "room_number", "price_per_night", "availability_status"})
public class Room {
    @JsonProperty("room_id")
    private int room_id;

    @JsonProperty("hotel_id")
    private int hotel_id;

    @JsonProperty("room_type_id")
    private int room_type_id;

    @JsonProperty("room_number")
    private String room_number;

    @JsonProperty("price_per_night")
    private double price_per_night;

    @JsonProperty("availability_status")
    private boolean availability_status;

    public Room() {
    }

    public Room(int room_id, int hotel_id, int room_type_id, String room_number, double price_per_night, boolean availability_status) {

        this.room_id = room_id;

        this.hotel_id = hotel_id;

        this.room_type_id = room_type_id;

        this.room_number = room_number;

        this.price_per_night = price_per_night;

        this.availability_status = availability_status;

    }

    // Getters and Setters
    @XmlElement
    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    @XmlElement
    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    @XmlElement
    public int getRoom_type_id() {
        return room_type_id;
    }

    public void setRoom_type_id(int room_type_id) {
        this.room_type_id = room_type_id;
    }

    @XmlElement
    public String getRoom_number() {
        return room_number;
    }

    public void setRoom_number(String room_number) {
        this.room_number = room_number;
    }

    @XmlElement
    public double getPrice_per_night() {
        return price_per_night;
    }

    public void setPrice_per_night(double price_per_night) {
        this.price_per_night = price_per_night;
    }

    @XmlElement
    public boolean isAvailability_status() {
        return availability_status;
    }

    public void setAvailability_status(boolean availability_status) {
        this.availability_status = availability_status;
    }
}
