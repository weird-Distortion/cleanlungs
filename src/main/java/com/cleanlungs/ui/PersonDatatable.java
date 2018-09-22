package com.cleanlungs.ui;

import com.cleanlungs.Person;
import com.cleanlungs.PersonEJB;
import org.omnifaces.cdi.ViewScoped;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@ViewScoped
@Named
public class PersonDatatable implements Serializable {
    @Inject
    private PersonEJB personEJB;

    private List<Person> values;

    public List<Person> getValues() {
        if (values == null)
            refresh();
        return values;
    }

    public void refresh() {
        values = personEJB.queryAll();
    }
}
