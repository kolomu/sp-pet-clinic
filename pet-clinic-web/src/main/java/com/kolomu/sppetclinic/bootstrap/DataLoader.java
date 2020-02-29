package com.kolomu.sppetclinic.bootstrap;

import com.kolomu.sppetclinic.model.Owner;
import com.kolomu.sppetclinic.model.Vet;
import com.kolomu.sppetclinic.services.OwnerService;
import com.kolomu.sppetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/* When Spring Context is completely up and ready, it will call the run method */
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    // Spring DI -> via Spring IoC Container (constructor DI)
    // no longer required... @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Mustermann");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Susan");
        owner2.setLastName("Sonnenschein");
        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Bob");
        vet2.setLastName("Boss");
        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
