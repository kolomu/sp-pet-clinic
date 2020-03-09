package com.kolomu.sppetclinic.repositories;

import com.kolomu.sppetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
