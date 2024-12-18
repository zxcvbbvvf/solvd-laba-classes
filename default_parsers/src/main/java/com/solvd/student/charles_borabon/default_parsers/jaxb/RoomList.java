package com.solvd.student.charles_borabon.default_parsers.jaxb;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "rooms")
@XmlType(propOrder = {"rooms"})
public class RoomList {
    @JsonProperty("rooms")
    private List<Room> rooms;

    @XmlElement(name = "room")
    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}