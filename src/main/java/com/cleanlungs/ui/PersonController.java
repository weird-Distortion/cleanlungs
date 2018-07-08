package com.cleanlungs.ui;

import com.cleanlungs.Person;
import com.cleanlungs.PersonEJB;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Controller for the Person UI page.
 */

@RequestScoped
@Named
public class PersonController {

    @Inject
    private SearchForm searchForm;

    @Inject
    private PersonEJB personEJB;

    @Produces
    @Named
    public List<Person> getPersons() {
        if (searchForm.getRegisteredAfter() == null) {
            return personEJB.queryAll();
        } else {
            return personEJB.queryRegisteredAfter(searchForm.getRegisteredAfter());
        }
    }

    public void remove(Person person) {
        personEJB.remove(person);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Person *" + person.getPersonNo() + "* successfully deleted"));
    }
}
