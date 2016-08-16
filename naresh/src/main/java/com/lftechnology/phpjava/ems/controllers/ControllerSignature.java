package com.lftechnology.phpjava.ems.controllers;

import java.util.Map;

/**
 * ControllerSignature
 *
 * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
 * @since August, 16 2016
 */
public interface ControllerSignature<T> {
    public Map<String, T> getData();

    public void setData(Map<String, T> data);

    public boolean isPost();
}
