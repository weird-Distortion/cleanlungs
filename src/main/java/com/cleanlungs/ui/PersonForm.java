package com.cleanlungs.ui;

import com.cleanlungs.Person;
import org.omnifaces.cdi.ViewScoped;

import javax.inject.Named;
import java.io.Serializable;

@ViewScoped
@Named
public class PersonForm implements Serializable {

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