package com.kolomu.sppetclinic.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass // means that the object is not created in the DB, instead it is created based from other objects.
public class Person extends BaseEntity {
    @Column(name="first_name") // by default hibernate does snake_case. E.g. all lowercase separated by underscore.
    private String firstName; // this is camelCase

    @Column(name="last_name")
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
