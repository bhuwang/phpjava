package com.lftechnology.phpjava.ems.views;

import java.util.Map;

/**
 * ViewSignature
 *
 * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
 * @since August, 15 2016
 */
public interface ViewSignature<T> {
    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     */
    void render();

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     * @return
     */
    String getAction();

    /**
     * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
     * @param action
     */
    void setAction(String action);

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
}
