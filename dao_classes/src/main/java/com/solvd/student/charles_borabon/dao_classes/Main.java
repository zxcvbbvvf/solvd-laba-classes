package com.solvd.student.charles_borabon.dao_classes;

import java.sql.Connection;

import com.solvd.student.charles_borabon.dao_classes.dao.ConnectionPool;

public class Main {
    public static void main(String[] args) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();

        Connection[] connections = new Connection[10];

        try {
            for (int i = 0; i < 10; i++) {
                connections[i] = connectionPool.getConnection();
                if (connections[i] != null) {
                    System.out.println("Connection " + i + " acquired");
                } else {
                    System.out.println("Connection " + i + " not acquired");
                }
            }
        } catch (Exception e) {
            System.err.println("Error acquiring connection: " + e.getMessage());
        }

        for (int i = 0; i < 10; i++) {
            if (connections[i] != null) {
                connectionPool.releaseConnection(connections[i]);
                System.out.println("Connection " + i + " released");
            }
        }
    }
}
