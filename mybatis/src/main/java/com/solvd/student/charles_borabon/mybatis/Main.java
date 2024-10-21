package com.solvd.student.charles_borabon.mybatis;

import org.apache.ibatis.session.SqlSessionFactory;

import com.solvd.student.charles_borabon.mybatis.dao.Hotel;
import com.solvd.student.charles_borabon.mybatis.dao.HotelDAO;
import com.solvd.student.charles_borabon.mybatis.util.MyBatisUtil;

public class Main {
    public static void main(String[] args) {
        // Initialize the MyBatis SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();

        // Create an instance of HotelDAO
        HotelDAO hotelDAO = new HotelDAO(sqlSessionFactory);

        try {
            // Create a new hotel and insert it into the database
            Hotel newHotel = new Hotel();
            newHotel.setHotelName("Grand Plaza");
            newHotel.setAddress("123 Main St");
            newHotel.setCity("New York");
            newHotel.setState("NY");
            newHotel.setCountry("USA");
            newHotel.setPhone("555-1234");

            hotelDAO.create(newHotel);
            System.out.println("Inserted Hotel ID: " + newHotel.getHotelId());

            // Read the hotel by ID
            Hotel hotelFromDB = hotelDAO.read(newHotel.getHotelId());
            
            // Debugging: Check if hotelFromDB is null
            if (hotelFromDB == null) {
                System.out.println("Hotel could not be found with ID: " + newHotel.getHotelId());
            } else {
                System.out.println("Hotel retrieved: " + hotelFromDB.getHotelName());
                System.out.println("Hotel Phone: " + hotelFromDB.getPhone());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}