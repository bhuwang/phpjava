package com.lftechnology.phpjava.assignment.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public interface DataAccessInterface<T> {

    List<T> findAll() throws SQLException;
    
    int insert(T t) throws SQLException;    

    int update(T t) throws SQLException;
    
    int delete(T t) throws SQLException;

}