package com.solvd.student.charles_borabon.solid_principles.design_patterns;

import java.util.List;

import com.solvd.student.charles_borabon.solid_principles.dao.Hotel;

public interface SortingStrategy {
    List<Hotel> sort(List<Hotel> hotels);
}
