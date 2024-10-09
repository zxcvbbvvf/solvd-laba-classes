package com.solvd.student.charles_borabon.dao_classes.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface GenericDAO<T, ID> {
    Optional<T> findById(ID id) throws SQLException;

    List<T> findAll() throws SQLException;

    boolean save(T entity) throws SQLException;

    boolean update(T entity) throws SQLException;

    boolean deleteById(ID id) throws SQLException;
}
