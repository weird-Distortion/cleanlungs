package com.cleanlungs.ui;

import com.cleanlungs.Person;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Controller for the Person UI page.
 */

@RequestScoped
@Named
public class PersonController {

    @PersistenceContext
    EntityManager entityManager;

    public List<Person> getPersons() {
        TypedQuery<Person> query = entityManager.createQuery("select e from Person e", Person.class);
        return query.getResultList();
    }
}
