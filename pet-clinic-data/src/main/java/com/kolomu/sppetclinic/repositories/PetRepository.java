package com.kolomu.sppetclinic.repositories;

import com.kolomu.sppetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
