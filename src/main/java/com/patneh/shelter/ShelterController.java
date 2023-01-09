package com.patneh.shelter;

import com.patneh.shelter.entities.AnimalEntity;
import com.patneh.shelter.entities.DonationEntity;
import com.patneh.shelter.entities.InvoiceEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shelter")
class ShelterController {

    private final ShelterService service;

    ShelterController(ShelterService service) {
        this.service = service;
    }

    @GetMapping("/animals")
    public List<AnimalEntity> getAnimals() {
        return service.getAnimals();
    }

    @GetMapping("/animal/{name}")
    public AnimalEntity findAnimal(@PathVariable String name){
        return service.findAnimal(name);
    }

    @GetMapping("/animal/{name}/donations")
    public List<DonationEntity> getDonations(@PathVariable String name) {
        return service.getDonations(name);
    }

    @GetMapping("/animal/{name}/donations/{id}")
    public DonationEntity getDonation(@PathVariable Long id) {
        return service.getDonation(id);
    }

    @GetMapping("/animal/{name}/invoices")
    public List<InvoiceEntity> getInvoices(@PathVariable String name) {
        return service.getInvoices(name);
    }

    @GetMapping("/animal/{name}/invoices/{id}")
    public InvoiceEntity getInvoices(@PathVariable Long id) {
        return service.getInvoice(id);
    }

    @PostMapping("/animal")
    public ResponseEntity<AnimalEntity> addAnimal(@RequestBody AnimalEntity animalEntity) {
        service.addAnimal(animalEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(animalEntity);
    }

    @PostMapping("/animal/{name}/donation")
    public ResponseEntity<DonationEntity> addDonation(@PathVariable String name, @RequestBody DonationEntity donationEntity) {
        service.addDonation(donationEntity, name);
        return ResponseEntity.status(HttpStatus.CREATED).body(donationEntity);
    }

    @PostMapping("/animal/{name}/invoice")
    public ResponseEntity<InvoiceEntity> addInvoice(@PathVariable String name, @RequestBody InvoiceEntity invoiceEntity) {
        service.addInvoice(invoiceEntity, name);
        return ResponseEntity.status(HttpStatus.CREATED).body(invoiceEntity);
    }

    @DeleteMapping("/animal/{name}")
    public void adoptAnimal(@PathVariable String name) {
        service.adoptAnimal(name);
    }
}
