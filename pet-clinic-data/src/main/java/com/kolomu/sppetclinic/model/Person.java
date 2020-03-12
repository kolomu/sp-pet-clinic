package com.kolomu.sppetclinic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

// Intermediate Classes
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@MappedSuperclass // means that the object is not created in the DB, instead it is created based from other objects.
public class Person extends BaseEntity {
    @Column(name="first_name") // by default hibernate does snake_case. E.g. all lowercase separated by underscore.
    private String firstName; // this is camelCase

    @Column(name="last_name")
    private String lastName;

    public Person(Long id, String firstName, String lastName) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
