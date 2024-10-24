package com.solvd.student.charles_borabon.solid_principles.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class HotelDAO extends AbstractDAO<Hotel, Integer> {

    private SqlSessionFactory sqlSessionFactory;

    public HotelDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public void create(Hotel hotel) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            session.insert("com.solvd.student.charles_borabon.mybatis.dao.HotelDAO.insertHotel", hotel);
            session.commit();
        }
    }

    @Override
    public Hotel read(Integer id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectOne("com.solvd.student.charles_borabon.mybatis.dao.HotelDAO.getHotelById", id);
        }
    }

    @Override
    public void update(Hotel hotel) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            session.update("com.solvd.student.charles_borabon.mybatis.dao.HotelDAO.updateHotel", hotel);
            session.commit();
        }
    }

    @Override
    public void delete(Integer id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            session.delete("com.solvd.student.charles_borabon.mybatis.dao.HotelDAO.deleteHotel", id);
            session.commit();
        }
    }

    @Override
    public List<Hotel> getAll() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            return session.selectList("com.solvd.student.charles_borabon.mybatis.dao.HotelDAO.getAllHotels");
        }
    }
}