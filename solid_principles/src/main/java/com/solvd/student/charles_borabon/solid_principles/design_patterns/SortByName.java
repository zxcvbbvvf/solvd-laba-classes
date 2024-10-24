package com.solvd.student.charles_borabon.solid_principles.design_patterns;

import java.util.List;

import com.solvd.student.charles_borabon.solid_principles.dao.Hotel;

public class SortByName implements SortingStrategy {
    @Override
    public List<Hotel> sort(List<Hotel> hotels) {
        hotels.sort((h1, h2) -> h1.getHotelName().compareTo(h2.getHotelName()));
        return hotels;
    }
}
