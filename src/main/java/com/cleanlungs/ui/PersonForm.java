package com.cleanlungs.ui;

import com.cleanlungs.Person;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named
public class PersonForm {

    private Integer personId;
    private Person person;

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(final Integer personId) {
        this.personId = personId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(final Person person) {
        this.person = person;
    }
}