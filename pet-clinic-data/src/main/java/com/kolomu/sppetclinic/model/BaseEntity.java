package com.kolomu.sppetclinic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@MappedSuperclass // establish this entitiy as base class for JPA. (Many class will inherit from this class)
public class BaseEntity implements Serializable {
    @Id // tell JPA that this is the ID value
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
}
