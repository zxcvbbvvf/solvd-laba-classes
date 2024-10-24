package com.solvd.student.charles_borabon.default_parsers.jaxb;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "bookings")
@XmlType(propOrder = {"bookings"})
public class BookingList {
    @JsonProperty("bookings")
    private List<Booking> bookings;

    @XmlElement(name = "booking")
    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}