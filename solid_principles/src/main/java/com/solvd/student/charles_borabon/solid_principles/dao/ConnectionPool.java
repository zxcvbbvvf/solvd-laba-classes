package com.solvd.student.charles_borabon.solid_principles.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Queue;

public class ConnectionPool {
    private static ConnectionPool instance;
    private Queue<Connection> pool = new LinkedList<>();

    private ConnectionPool() {
        for (int i = 0; i < 10; i++) {
            pool.add(createConnection());
        }
    }

    public static synchronized ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    private Connection createConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            return DriverManager.getConnection("jdbc:mysql://localhost:3307/hotel_booking_service", "Z", "password");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL JDBC Driver not found", e);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating connection", e);
        }
    }

    public synchronized Connection getConnection() {
        if (pool.isEmpty()) {
            pool.add(createConnection());
        }
        return pool.poll();
    }

    public synchronized void releaseConnection(Connection connection) {
        pool.add(connection);
    }
}