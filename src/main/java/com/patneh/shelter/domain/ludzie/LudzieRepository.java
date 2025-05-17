package com.patneh.shelter.domain.ludzie;

import com.patneh.shelter.infrasructure.entities.LudzieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LudzieRepository extends JpaRepository<LudzieEntity, Long> {
}
