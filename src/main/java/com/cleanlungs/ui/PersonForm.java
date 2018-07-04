package com.cleanlungs.ui;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named
public class PersonForm {

    private Integer personId;

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(final Integer personId) {
        this.personId = personId;
    }
}