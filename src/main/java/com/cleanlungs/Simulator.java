package com.cleanlungs;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.*;

@SessionScoped
@Named
public class Simulator implements Serializable {

    @PersistenceContext
    private
    EntityManager entityManager;

    private List<Person> queryAll() {
        TypedQuery<Person> query = entityManager
                .createQuery("select e from Person e", Person.class);
        return query.getResultList();
    }

    private List<Person> personList;
    private Map<Person, Timer> personMap = new HashMap<>();

    public void buttonStartAction(ActionEvent actionEvent) {
        startSimulator("Button works!");
    }

    private void startSimulator(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);

        /**
         *TAKE LIST OF EXISTING USERS
         * Every user has to has his own timer.
         * Button New->Save - has to add new user to personList (if it's new user)
         * and every new user has to get his timer either.
         * Delete button has to delete user from person list.
         */
        if (personMap.isEmpty()) {
            personList = queryAll();
            personList.forEach(x -> personMap.put(x, new Timer()));
        }

        personList.forEach(x -> personMap.put(x, new Timer()));
        personMap.forEach((x, y) -> y.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("simulator " + Thread.currentThread().getName() + " works!");
            }
        }, 1000 * 5, 1000 * 5));
    }

    public void buttonStopAction(ActionEvent actionEvent) {
        stopSimulator("Button works!");
    }

    private void stopSimulator(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);

        if (personMap.isEmpty()) {
            System.out.println("PersonMap is EMPTY!!!");
            return;
        }

        personMap.forEach((x, y) -> {
            System.out.println(y.getClass().getName() + " is canceled!");
            y.cancel();
            y.purge();
        });

    }
}
