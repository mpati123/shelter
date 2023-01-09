package com.patneh.shelter.repositories;

import com.patneh.shelter.entities.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Long>  {

    List<InvoiceEntity> findInvoiceEntitiesByAnimal_Name(String name);
}
