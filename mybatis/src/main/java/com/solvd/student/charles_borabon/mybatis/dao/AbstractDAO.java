package com.solvd.student.charles_borabon.mybatis.dao;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class AbstractDAO<T, ID> implements GenericDAO<T, ID> {
    protected ConnectionPool connectionPool;

    public AbstractDAO() {
        this.connectionPool = ConnectionPool.getInstance();
    }

    protected Connection getConnection() throws SQLException {
        return connectionPool.getConnection();
    }

    protected void closeConnection(Connection connection) {
        connectionPool.releaseConnection(connection);
    }

    // CRUD operations will be partially implemented or left for concrete classes
}