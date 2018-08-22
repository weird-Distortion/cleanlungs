package com.cleanlungs;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@Named
public class Simulator {

    private List<Person> personList;

    Simulator() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("simulator " + Thread.currentThread().getName() + " works!");
            }
        }, 1000 * 5, 1000 * 5);
    }

    public void buttonAction(ActionEvent actionEvent) {
        startSimulator("Button works!");
    }

    private void startSimulator(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
