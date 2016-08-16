package com.lftechnology.phpjava.ems.views;

/**
 * AbstractBaseView
 *
 * @author Naresh Maharjan <nareshmaharjan@lftechnology.com>
 * @since August, 15 2016
 */
public abstract class AbstractBaseView implements ViewSignature {

    protected String action = "";

    public abstract void render();

    @Override
    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String getAction() {
        return this.action;
    }

}
