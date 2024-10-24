package com.solvd.student.charles_borabon.solid_principles.design_patterns;

import com.solvd.student.charles_borabon.solid_principles.dao.Hotel;

public class LuxuryHotelDecorator extends HotelDecorator {
    public LuxuryHotelDecorator(Hotel decorated_hotel) {
        super(decorated_hotel);
    }

    @Override
    public String getDescription() {
        return decorated_hotel.getHotelName() + ", with luxury amenities";
    }
}
