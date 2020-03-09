package com.kolomu.sppetclinic.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass // establish this entitiy as base class for JPA. (Many class will inherit from this class)
public class BaseEntity implements Serializable {
    @Id // tell JPA that this is the ID value
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
