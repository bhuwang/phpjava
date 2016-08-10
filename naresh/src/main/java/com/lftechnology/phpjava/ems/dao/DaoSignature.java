package com.lftechnology.phpjava.ems.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * DaoSignature
 *
 * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
 * @since August, 08 2016
 */
public interface DaoSignature<T> {

    /**
     *
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     * @return
     * @throws SQLException
     */
    List<T> findAll() throws SQLException;


    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     * @param s
     * @return
     * @throws SQLException
     */
    int insert(T t) throws SQLException;

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     * @param s
     * @return
     * @throws SQLException
     */
    int update(T t) throws SQLException;


    /**
     *
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     * @param s
     * @return
     * @throws SQLException
     */
    boolean delete(T t) throws SQLException;
}
