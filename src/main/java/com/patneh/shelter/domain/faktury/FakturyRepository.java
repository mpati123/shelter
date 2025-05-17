package com.patneh.shelter.domain.faktury;

import com.patneh.shelter.infrasructure.entities.FakturyEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FakturyRepository extends JpaRepository<FakturyEntity, Long> {

  List<FakturyEntity> findAllByLecznicaId(Long lecznicaId);
}
