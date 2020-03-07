package com.kolomu.sppetclinic.bootstrap;

import com.kolomu.sppetclinic.model.Owner;
import com.kolomu.sppetclinic.model.Pet;
import com.kolomu.sppetclinic.model.PetType;
import com.kolomu.sppetclinic.model.Vet;
import com.kolomu.sppetclinic.services.OwnerService;
import com.kolomu.sppetclinic.services.PetTypeService;
import com.kolomu.sppetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/* When Spring Context is completely up and ready, it will call the run method */
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    // Spring DI -> via Spring IoC Container (constructor DI)
    // no longer required... @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Mustermann");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("1231231234");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Susan");
        owner2.setLastName("Sonnenschein");
        owner2.setAddress("123 Brickerel");
        owner2.setCity("Miami");
        owner2.setTelephone("1231231234");

        Pet susansCat = new Pet();
        susansCat.setPetType(savedCatPetType);
        susansCat.setOwner(owner2);
        susansCat.setName("Miau");
        susansCat.setBirthDate(LocalDate.now());
        owner2.getPets().add(susansCat);

        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Bob");
        vet2.setLastName("Boss");
        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
