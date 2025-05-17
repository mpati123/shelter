package com.patneh.shelter.domain.gatunki;

import com.patneh.shelter.infrasructure.entities.GatunekEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GatunekRepository extends JpaRepository<GatunekEntity, Long> {
}
