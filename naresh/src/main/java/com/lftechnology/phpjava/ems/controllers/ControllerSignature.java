package com.lftechnology.phpjava.ems.controllers;

import java.util.Map;

/**
 * ControllerSignature
 *
 * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
 * @since August, 16 2016
 */
public interface ControllerSignature<T> {
    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     * @return
     */
    Map<String, T> getData();

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     * @param data
     */
    void setData(Map<String, T> data);

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     * @return
     */
    boolean isPost();
}
