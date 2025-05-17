package com.patneh.shelter.domain.lecznice;

import com.patneh.shelter.infrasructure.entities.LecznicaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LecznicaRepository extends JpaRepository<LecznicaEntity, Long> {
}
