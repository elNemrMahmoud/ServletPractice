package com.Dao;

import java.util.List;

public interface GenericDatabaseDao<T, ID> {

    void add(T entity);

    List<T> getAll();

    void update(T entity);

    void delete(T entity);

    T getById(ID id);
    
}
