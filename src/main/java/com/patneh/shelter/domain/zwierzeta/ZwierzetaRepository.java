package com.patneh.shelter.domain.zwierzeta;

import com.patneh.shelter.infrasructure.entities.ZwierzetaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZwierzetaRepository extends JpaRepository<ZwierzetaEntity, Long> {
}
