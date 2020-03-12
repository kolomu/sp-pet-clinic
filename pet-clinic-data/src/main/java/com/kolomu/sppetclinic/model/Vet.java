package com.kolomu.sppetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

// Vet = Tierarzt
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="vets")
public class Vet extends Person {
    @ManyToMany(fetch = FetchType.EAGER) // when we load vet it should also load speciality table and then continue, so we have the value when we need it.
    @JoinTable(
            name="vet_specialties",
            joinColumns = @JoinColumn(name="vet_id"),
            inverseJoinColumns = @JoinColumn(name="speciality_id")
    )
    private Set<Speciality> specialities = new HashSet<>();
}
