package com.kolomu.sppetclinic.services.map;

import com.kolomu.sppetclinic.model.Owner;
import com.kolomu.sppetclinic.model.Pet;
import com.kolomu.sppetclinic.services.OwnerService;
import com.kolomu.sppetclinic.services.PetService;
import com.kolomu.sppetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    // We take the petType that is assigned and save it, so we get the ID assigned to map object.
    @Override
    public Owner save(Owner object) {
        Owner savedOwner = null;
        if(object != null) {
            if(object.getPets() != null) {
                object.getPets().forEach(pet -> {
                    // 1. Handling Pet Type ID
                    if(pet.getPetType() != null) {
                        // when the pet has not been saved to our map yet -> save it.
                        if(pet.getPetType().getId() == null) {
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    } else {
                        throw new RuntimeException("Pet Type is required!");
                    }

                    // 2. Handling Pet ID
                    if(pet.getId() == null) {
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(object);
        } else {
            return null;
        }

    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
