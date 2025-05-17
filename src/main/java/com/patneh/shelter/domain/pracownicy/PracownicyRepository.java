package com.patneh.shelter.domain.pracownicy;

import com.patneh.shelter.infrasructure.entities.PracownicyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PracownicyRepository extends JpaRepository<PracownicyEntity, Long> {
}
