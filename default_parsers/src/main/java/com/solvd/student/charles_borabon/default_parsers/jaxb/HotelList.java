package com.solvd.student.charles_borabon.default_parsers.jaxb;

import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name = "hotels")
@XmlType(propOrder = {"hotels"})
public class HotelList {

    @JsonProperty("hotels")
    private List<Hotel> hotels;

    @XmlElement(name = "hotel")
    public List<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }
}