package com.solvd.student.charles_borabon.dao_classes.dao;

import java.sql.SQLException;
import java.util.List;

public abstract class AbstractService<T, ID> {
    protected GenericDAO<T, ID> dao;

    public AbstractService(GenericDAO<T, ID> dao) {
        this.dao = dao;
    }

    public void save(T entity) throws SQLException {
        dao.create(entity);
    }

    public T findById(ID id) throws SQLException {
        return dao.read(id);
    }

    public void update(T entity) throws SQLException {
        dao.update(entity);
    }

    public void delete(ID id) throws SQLException {
        dao.delete(id);
    }

    public List<T> findAll() throws SQLException {
        return dao.getAll();
    }
}