package com.kolomu.sppetclinic.repositories;

import com.kolomu.sppetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    // using dynamic query method for spring data jpa
    Owner findByLastName(String lastName);
}
