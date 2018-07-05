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

    public Person find(Integer id) {
        return entityManager.find(Person.class, id);
    }

    public Person merge(Person person) {
        return entityManager.merge(person);
    }

    public void persist(Person person) {
        entityManager.persist(person);
    }

    public void remove(Person person) {
        Person attached = find(person.getPersonId());
        entityManager.remove(attached);
    }
}
