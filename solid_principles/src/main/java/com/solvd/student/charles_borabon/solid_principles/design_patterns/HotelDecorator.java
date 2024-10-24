package com.solvd.student.charles_borabon.solid_principles.design_patterns;

import com.solvd.student.charles_borabon.solid_principles.dao.Hotel;

public abstract class HotelDecorator extends Hotel {
    protected Hotel decorated_hotel;

    public HotelDecorator(Hotel decorated_hotel) {
        this.decorated_hotel = decorated_hotel;
    }

    public abstract String getDescription();
}