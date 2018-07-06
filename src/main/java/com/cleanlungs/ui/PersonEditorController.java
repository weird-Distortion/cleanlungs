package com.cleanlungs.ui;

import com.cleanlungs.Person;
import com.cleanlungs.PersonEJB;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named
public class PersonEditorController {

    @Inject
    private
    PersonForm personForm;

    @Inject
    private
    PersonEJB personEJB;

    public void save() {
        personEJB.merge(personForm.getPerson());
    }

    public void preRenderViewEvent() {
        if (personForm.getPerson() == null) {
            initializePerson();
        }
    }

    private void initializePerson() {
        if (personForm.getPersonId() == null) {
            personForm.setPerson(new Person());
            return;
        }
        Person person = personEJB.find(personForm.getPersonId());
        personForm.setPerson(person);
    }
}
