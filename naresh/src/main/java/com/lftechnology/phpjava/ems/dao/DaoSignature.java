package com.lftechnology.phpjava.ems.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * DaoSignature
 *
 * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
 * @since August, 08 2016
 */
public interface DaoSignature<T> {

    /**
     * @return
     * @throws SQLException
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    List<T> findAll() throws SQLException;


    /**
     * @param s
     * @return
     * @throws SQLException
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    int insert(T t) throws SQLException;

    /**
     * @param s
     * @return
     * @throws SQLException
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    int update(T t) throws SQLException;


    /**
     * @param s
     * @return
     * @throws SQLException
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    int delete(T t) throws SQLException;
}
