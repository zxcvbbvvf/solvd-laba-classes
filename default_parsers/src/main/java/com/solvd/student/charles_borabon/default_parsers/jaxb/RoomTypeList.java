package com.solvd.student.charles_borabon.default_parsers.jaxb;

import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "room_types")
@XmlType(propOrder = {"room_type_id", "room_type_name"})
public class RoomTypeList {

    private List<RoomType> room_types;

    @XmlElement(name = "room_type")
    public List<RoomType> getRoomTypes() {
        return room_types;
    }

    public void setRoomTypes(List<RoomType> room_types) {
        this.room_types = room_types;
    }
}

@XmlType(propOrder = {"room_type_id", "room_type_name"})
class RoomType {
    private int room_type_id;
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