package com.cleanlungs.ui;

import com.cleanlungs.Person;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

/**
 * Controller for the Person UI page.
 */

@RequestScoped
@Named
public class PersonController {

    @PersistenceContext
    EntityManager entityManager;

    private Date registeredAfter;

    @Produces
    @Named
    public List<Person> getPersons() {
        TypedQuery<Person> query = entityManager
                .createQuery("select e from Person e where e.registrationDate >= :registeredAfter", Person.class);
        query.setParameter("registeredAfter", registeredAfter);
        return query.getResultList();
    }

    public Date getRegisteredAfter() {
        return registeredAfter;
    }

    public void setRegisteredAfter(final Date registeredAfter) {
        this.registeredAfter = registeredAfter;
    }
}
