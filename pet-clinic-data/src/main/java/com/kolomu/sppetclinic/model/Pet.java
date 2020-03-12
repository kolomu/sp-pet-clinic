package com.kolomu.sppetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="pets")
public class Pet extends BaseEntity {
    @Column(name="name")
    private String name;

    @ManyToOne // every pet has a pet type which is in the table petType and take the field type_id there!
    @JoinColumn(name="type_id")
    private PetType petType;
    @ManyToOne // tell hibernate how to do the mapping, we expect on the db level that we have an owner_id column on the pet column.
    // every pet has an owner.
    @JoinColumn(name="owner_id")
    private Owner owner;

    @Column(name="birth_date")
    private LocalDate birthDate;

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();
}
