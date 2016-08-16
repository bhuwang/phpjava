package com.lftechnology.phpjava.ems.views;

import java.util.Map;

/**
 * ViewSignature
 *
 * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
 * @since August, 15 2016
 */
public interface ViewSignature<T> {
    public void render();

    public String getAction();

    public void setAction(String action);

    public Map<String, T> getData();

    public void setData(Map<String, T> data);
}
