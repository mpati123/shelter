package com.patneh.shelter.domain.zbiorki;

import com.patneh.shelter.infrasructure.entities.ZbiorkaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZbiorkaRepository extends JpaRepository<ZbiorkaEntity, Long> {
}
