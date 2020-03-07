package com.kolomu.sppetclinic.model;

import java.util.HashSet;
import java.util.Set;

// Vet = Tierarzt
public class Vet extends Person {
    private Set<Speciality> specialities = new HashSet<>();

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }
}
