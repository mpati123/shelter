package com.patneh.shelter;

import com.example.shelter.entities.*;
import com.patneh.shelter.entities.AnimalEntity;
import com.patneh.shelter.entities.DonationEntity;
import com.patneh.shelter.entities.InvoiceEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShelterConfiguration {

    @Bean
    public AnimalEntity animal() {
        return new AnimalEntity();
    }

    @Bean
    public DonationEntity donation() {
        return new DonationEntity();
    }

    @Bean
    public InvoiceEntity invoice() {
        return new InvoiceEntity();
    }
}