package com.kolomu.sppetclinic.repositories;

import com.kolomu.sppetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
