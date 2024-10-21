package com.solvd.student.charles_borabon.mybatis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HotelDAO extends AbstractDAO<Hotel, Integer> {
    private static final String INSERT_HOTEL_SQL = "INSERT INTO hotels (hotel_name, address, city, state, country, phone) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_HOTEL_BY_ID = "SELECT * FROM hotels WHERE hotel_id = ?";
    private static final String SELECT_ALL_HOTELS = "SELECT * FROM hotels";
    private static final String UPDATE_HOTEL_SQL = "UPDATE hotels SET hotel_name = ?, address = ?, city = ?, state = ?, country = ?, phone = ? WHERE hotel_id = ?";
    private static final String DELETE_HOTEL_SQL = "DELETE FROM hotels WHERE hotel_id = ?";

    @Override
    public void create(Hotel hotel) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_HOTEL_SQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, hotel.getHotelName());
            preparedStatement.setString(2, hotel.getAddress());
            preparedStatement.setString(3, hotel.getCity());
            preparedStatement.setString(4, hotel.getState());
            preparedStatement.setString(5, hotel.getCountry());
            preparedStatement.setString(6, hotel.getPhone());

            int affectedRows = preparedStatement.executeUpdate();

            // Retrieve the generated hotel_id
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        hotel.setHotelId(generatedKeys.getInt(1));
                    }
                }
            }
        }
    }

    @Override
    public Hotel read(Integer id) throws SQLException {
        Hotel hotel = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_HOTEL_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                hotel = new Hotel();
                hotel.setHotelId(rs.getInt("hotel_id"));
                hotel.setHotelName(rs.getString("hotel_name"));
                hotel.setAddress(rs.getString("address"));
                hotel.setCity(rs.getString("city"));
                hotel.setState(rs.getString("state"));
                hotel.setCountry(rs.getString("country"));
                hotel.setPhone(rs.getString("phone"));
            }
        }
        return hotel;
    }

    @Override
    public void update(Hotel hotel) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_HOTEL_SQL)) {
            preparedStatement.setString(1, hotel.getHotelName());
            preparedStatement.setString(2, hotel.getAddress());
            preparedStatement.setString(3, hotel.getCity());
            preparedStatement.setString(4, hotel.getState());
            preparedStatement.setString(5, hotel.getCountry());
            preparedStatement.setString(6, hotel.getPhone());
            preparedStatement.setInt(7, hotel.getHotelId());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_HOTEL_SQL)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public List<Hotel> getAll() throws SQLException {
        List<Hotel> hotels = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_HOTELS);
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                Hotel hotel = new Hotel();
                hotel.setHotelId(rs.getInt("hotel_id"));
                hotel.setHotelName(rs.getString("hotel_name"));
                hotel.setAddress(rs.getString("address"));
                hotel.setCity(rs.getString("city"));
                hotel.setState(rs.getString("state"));
                hotel.setCountry(rs.getString("country"));
                hotel.setPhone(rs.getString("phone"));
                hotels.add(hotel);
            }
        }
        return hotels;
    }
}
