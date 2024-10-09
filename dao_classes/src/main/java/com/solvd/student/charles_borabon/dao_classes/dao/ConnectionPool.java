package com.solvd.student.charles_borabon.dao_classes.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionPool {
    Connection getConnection() throws SQLException;

    void releaseConnection(Connection connection) throws SQLException;
}