package com.solvd.student.charles_borabon.default_parsers.jaxb;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "room_types")
@XmlType(propOrder = {"roomTypes"})
public class RoomTypeList {

    @JsonProperty("room_types")
    private List<RoomType> roomTypes;

    @XmlElement(name = "room_type")
    @JsonProperty("room_types")
    public List<RoomType> getRoomTypes() {
        return roomTypes;
    }

    public void setRoomTypes(List<RoomType> roomTypes) {
        this.roomTypes = roomTypes;
    }
}