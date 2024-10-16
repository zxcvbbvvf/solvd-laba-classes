package com.solvd.student.charles_borabon.default_parsers.jaxb;

import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "room_types")
@XmlType(propOrder = {"roomTypes"})
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