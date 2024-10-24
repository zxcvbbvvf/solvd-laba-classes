package com.solvd.student.charles_borabon.solid_principles.design_patterns;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;

import com.solvd.student.charles_borabon.solid_principles.dao.Hotel;
import com.solvd.student.charles_borabon.solid_principles.dao.HotelDAO;

public class HotelDAOProxy extends HotelDAO {
    private HotelDAO real_hotel_dao;

    public HotelDAOProxy(HotelDAO real_hotel_dao, SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
        this.real_hotel_dao = real_hotel_dao;
    }

    @Override
    public void create(Hotel hotel) {
        // Add additional logic before delegating to the real HotelDAO
        System.out.println("Proxy: Creating hotel...");
        real_hotel_dao.create(hotel);
    }

    @Override
    public Hotel read(Integer id) {
        // Add additional logic before delegating to the real HotelDAO
        System.out.println("Proxy: Reading hotel with ID: " + id);
        return real_hotel_dao.read(id);
    }

    @Override
    public void update(Hotel hotel) {
        // Add additional logic before delegating to the real HotelDAO
        System.out.println("Proxy: Updating hotel...");
        real_hotel_dao.update(hotel);
    }

    @Override
    public void delete(Integer id) {
        // Add additional logic before delegating to the real HotelDAO
        System.out.println("Proxy: Deleting hotel with ID: " + id);
        real_hotel_dao.delete(id);
    }

    @Override
    public List<Hotel> getAll() {
        // Add additional logic before delegating to the real HotelDAO
        System.out.println("Proxy: Retrieving all hotels...");
        return real_hotel_dao.getAll();
    }
}