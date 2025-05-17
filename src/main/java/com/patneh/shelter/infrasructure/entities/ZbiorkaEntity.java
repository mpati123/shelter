package com.patneh.shelter.infrasructure.entities;

import com.patneh.shelter.common.jpa.entity.BaseEntity;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "zbiorka")
public class ZbiorkaEntity extends BaseEntity {

    @Id
    @SequenceGenerator(name = "zbiorka_id_seq", allocationSize = 1, sequenceName = "zbiorka_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "zbiorka_id_seq")
    private Long id;

    @Column(nullable = false)
    private String nazwa;

    @Column(nullable = false)
    private String cel;

    @Column(precision = 10, scale = 2)
    private BigDecimal kwotaDocelowa;

    @Column(precision = 10, scale = 2)
    private BigDecimal kwotaZebrana;

    @ManyToMany
    @JoinTable(
        name = "zwierzeta_zbiorki",
        joinColumns = @JoinColumn(name = "zbiorka_id", insertable = false, updatable = false),
        inverseJoinColumns = @JoinColumn(name = "zwierze_id", insertable = false, updatable = false))
    @Builder.Default
    private Set<ZwierzetaEntity> zwierzeta = new HashSet<>();

}
