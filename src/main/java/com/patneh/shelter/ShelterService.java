package com.patneh.shelter;

import com.patneh.shelter.entities.AnimalEntity;
import com.patneh.shelter.entities.DonationEntity;
import com.patneh.shelter.entities.InvoiceEntity;
import com.patneh.shelter.repositories.AnimalRepository;
import com.patneh.shelter.repositories.DonationRepository;
import com.patneh.shelter.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShelterService {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private DonationRepository donationRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;

    public void addAnimal(AnimalEntity animalEntity) {
        animalRepository.save(animalEntity);
    }

    public List<AnimalEntity> getAnimals() {
        return animalRepository.findAll();
    }

    public AnimalEntity findAnimal(String name){
        return animalRepository.findAnimalEntitiesByName(name);
    }

    public void adoptAnimal(String animalName) {
        animalRepository.delete(animalRepository.findAnimalEntitiesByName(animalName));
    }


    public void addDonation(DonationEntity donation, String name) {
        donation.setAnimal(animalRepository.findAnimalEntitiesByName(name));
        donationRepository.save(donation);
    }

    public void addInvoice(InvoiceEntity invoice, String name) {
        invoice.setAnimal(animalRepository.findAnimalEntitiesByName(name));
        invoiceRepository.save(invoice);
    }

    public List<DonationEntity> getDonations(String name) {
        return donationRepository.findDonationEntitiesByAnimal_Name(name);
    }

    public DonationEntity getDonation(Long id) {
        if (donationRepository.findById(id).isPresent()) {
            return donationRepository.findById(id).get();
        }
        else return null;
    }

    public List<InvoiceEntity> getInvoices(String name) {
        return invoiceRepository.findInvoiceEntitiesByAnimal_Name(name);
    }

    public InvoiceEntity getInvoice(Long id) {
        if (invoiceRepository.findById(id).isPresent()) {
            return invoiceRepository.findById(id).get();
        }
        else return null;
    }


}
