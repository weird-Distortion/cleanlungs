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
    private
    EntityManager entityManager;

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
        Person attached = find(person.getPersonNo());
        entityManager.remove(attached);
    }
}
