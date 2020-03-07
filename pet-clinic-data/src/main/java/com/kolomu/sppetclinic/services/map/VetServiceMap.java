package com.kolomu.sppetclinic.services.map;

import com.kolomu.sppetclinic.model.Speciality;
import com.kolomu.sppetclinic.model.Vet;
import com.kolomu.sppetclinic.services.SpecialtyService;
import com.kolomu.sppetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    private final SpecialtyService specialtyService;

    public VetServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet vet) {
        // We mimicking hibernate here (usually Hibernate will take care of that!)
        // If we have specialities created in vet which are not stored yet in DB, create them!
        if(vet.getSpecialities().size() > 0 ) {
            vet.getSpecialities().forEach( speciality -> {
                if(speciality.getId() == null) {
                    // creating ID of speciality
                    Speciality savedSpeciality = specialtyService.save(speciality);
                    // give the speciality in the list of vets the ID value which we received from creating it into the map
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }
        return super.save(vet);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
