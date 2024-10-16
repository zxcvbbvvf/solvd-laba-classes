package com.solvd.student.charles_borabon.default_parsers.jaxb;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"room_type_id", "room_type_name"})
public class RoomType {
    @JsonProperty("room_type_id")
    private int room_type_id;

    @JsonProperty("room_type_name")
    private String room_type_name;

    // Getters and Setters
    @XmlElement
    public int getRoom_type_id() {
        return room_type_id;
    }

    public void setRoom_type_id(int room_type_id) {
        this.room_type_id = room_type_id;
    }

    @XmlElement
    public String getRoom_type_name() {
        return room_type_name;
    }

    public void setRoom_type_name(String room_type_name) {
        this.room_type_name = room_type_name;
    }
}
