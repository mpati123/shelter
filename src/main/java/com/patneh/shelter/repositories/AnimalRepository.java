package com.patneh.shelter.repositories;

import com.patneh.shelter.entities.AnimalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<AnimalEntity, Long> {

    AnimalEntity findAnimalEntitiesByName(String name);
}
