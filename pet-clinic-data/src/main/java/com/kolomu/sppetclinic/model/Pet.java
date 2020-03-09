package com.kolomu.sppetclinic.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="pets")
public class Pet extends BaseEntity {
    @Column(name="name")
    private String name;


    @ManyToOne
    // every pet has a pet type which is in the table petType and take the field type_id there!
    @JoinColumn(name="type_id")
    private PetType petType;
    @ManyToOne
    // tell hibernate how to do the mapping, we expect on the db level that we have an owner_id column on the pet column.
    // every pet has an owner.
    @JoinColumn(name="owner_id")
    private Owner owner;

    @Column(name="birth_date")
    private LocalDate birthDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
