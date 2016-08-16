package com.lftechnology.phpjava.ems.utlis;

import java.util.Map;

/**
 * AbstractDbAdapater
 *
 * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
 * @since August, 09 2016
 */
public abstract class AbstractDbAdapater {
    protected String query = "";

    protected AbstractDbAdapater where(Map<String, String> condition) {
        condition.entrySet();
        return this;
    }
}
