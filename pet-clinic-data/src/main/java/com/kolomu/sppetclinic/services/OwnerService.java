package com.kolomu.sppetclinic.services;

import com.kolomu.sppetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{
    Owner findByLastName(String lastName);
}
