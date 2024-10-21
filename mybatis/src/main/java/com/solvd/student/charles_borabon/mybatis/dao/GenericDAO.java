package com.solvd.student.charles_borabon.mybatis.dao;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO<T, ID> {
    void create(T entity) throws SQLException;
    T read(ID id) throws SQLException;
    void update(T entity) throws SQLException;
    void delete(ID id) throws SQLException;
    List<T> getAll() throws SQLException;
}