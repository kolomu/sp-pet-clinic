package com.kolomu.sppetclinic.services;

import java.util.Set;

/** We are mimicking the Spring Data Repository */
public interface CrudService<T, ID> {
    Set<T> findAll();
    T findById(ID id);
    T save(T object);
    void delete(T object);
    void deleteById(ID id);
}
