package com.cleanlungs;

import com.cleanlungs.ui.PersonDatatable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

@SessionScoped
@Named
public class Simulator implements Serializable {

    @Inject
    private PersonDatatable personDatatable;

    private List<Person> personList;
    private Map<Person, Timer> personMap = new HashMap<>();

    public void buttonStartAction(ActionEvent actionEvent) {
        startSimulator("Button works!");
    }

    private void startSimulator(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);

        /**
         *TAKE LIST OF EXISTING USERS - OK
         * Every user has to has his own timer.
         * Button New->Save - has to add new user to personList (if it's new user)
         * and every new user has to get his timer either.
         * Delete button has to delete user from person list.
         */
        if (personMap.isEmpty()) {
            personList = personDatatable.getValues();
            personMap = personList.parallelStream().collect(toMap(person -> person, person -> new Timer()));
        }

        personMap = personList.parallelStream().collect(toMap(person -> person, person -> new Timer()));
        personMap.forEach((person, timer) -> timer.schedule(new TimerTask() {
            @Override
            public void run() {
//                System.out.println("simulator " + Thread.currentThread().getName() + " works!");
                switchStatus(person);
            }
        }, 1000 * 10, 1000 * 5 * (new Random().nextInt(10) + 1)));
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

    private void switchStatus(Person person) {
        System.out.println("STATUS SWITCHED " + person.getFirstName() + " " + person.getLastName());

        if (person.getStatus().equals("OK")) {
            person.setStatus("DETECTED");
        } else if (person.getStatus().equals("DETECTED")) {
            person.setStatus("OK");
        }
    }
}
