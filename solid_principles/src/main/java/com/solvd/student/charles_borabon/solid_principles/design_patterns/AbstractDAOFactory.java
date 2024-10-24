package com.solvd.student.charles_borabon.solid_principles.design_patterns;

import com.solvd.student.charles_borabon.solid_principles.dao.HotelDAO;

public interface AbstractDAOFactory {
    HotelDAO create();
}
