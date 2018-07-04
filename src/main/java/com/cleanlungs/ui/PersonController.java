package com.cleanlungs.ui;

import com.cleanlungs.Person;
import com.cleanlungs.PersonEJB;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Controller for the Person UI page.
 */

@RequestScoped
@Named
public class PersonController {

    @PersistenceContext
    EntityManager entityManager;

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
}
