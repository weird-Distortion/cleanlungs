package com.cleanlungs.ui;

import com.cleanlungs.Person;
import com.cleanlungs.PersonEJB;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Controller for the Persons UI page.
 */

@RequestScoped
@Named
public class PersonController {

    @Inject
    private PersonEJB personEJB;

    @Inject
    private PersonDatatable personDatatable;

    public void remove(Person person) {
        personEJB.remove(person);
        personDatatable.refresh();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(person.getFirstName()
                + " " + person.getLastName() + " successfully deleted"));
    }
}
