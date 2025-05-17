package com.patneh.shelter.infrasructure.entities;

import com.patneh.shelter.common.jpa.entity.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "ludzie")
public class LudzieEntity extends BaseEntity {

    @Id
    @SequenceGenerator(name = "ludzie_id_seq", allocationSize = 1, sequenceName = "ludzie_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ludzie_id_seq")
    private Long id;

    @Column(nullable = false)
    private String imie;

    @Column(nullable = false)
    private String nazwisko;

    @Column(unique = true)
    private String email;
    
    private String telefon;
}
