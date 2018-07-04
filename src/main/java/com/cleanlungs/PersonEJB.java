package com.cleanlungs;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

@Stateless
public class PersonEJB {

    @PersistenceContext
    EntityManager entityManager;

    public List<Person> queryRegisteredAfter(Date registeredAfter) {
        TypedQuery<Person> query = entityManager
                .createQuery("select e from Person e where e.registrationDate > :registeredAfter", Person.class);
        query.setParameter("registeredAfter", registeredAfter);
        return query.getResultList();
    }

    public List<Person> queryAll() {
        TypedQuery<Person> query = entityManager
                .createQuery("select e from Person e", Person.class);
        return query.getResultList();
    }
}
