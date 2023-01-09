package com.patneh.shelter.repositories;

import com.patneh.shelter.entities.DonationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonationRepository extends JpaRepository<DonationEntity, Long>  {

    List<DonationEntity> findDonationEntitiesByAnimal_Name(String name);
}
