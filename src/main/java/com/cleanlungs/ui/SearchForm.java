package com.cleanlungs.ui;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;

@SessionScoped
@Named
public class SearchForm implements Serializable {

    private Date registeredAfter;

    public Date getRegisteredAfter() {
        return registeredAfter;
    }

    public void setRegisteredAfter(final Date registeredAfter) {
        this.registeredAfter = registeredAfter;
    }
}