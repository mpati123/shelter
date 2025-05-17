package com.patneh.shelter.infrasructure.entities;

import com.patneh.shelter.common.jpa.entity.BaseEntity;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "faktury")
@EqualsAndHashCode(callSuper = true)
@Builder
public class FakturyEntity extends BaseEntity {

    @Id
    @SequenceGenerator(name = "faktury_id_seq", allocationSize = 1, sequenceName = "faktury_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "faktury_id_seq")
    private Long id;

    @Column(nullable = false)
    private String numer;

    @Column(nullable = false)
    private LocalDate data;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal kwota;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecznica_id", nullable = false)
    private LecznicaEntity lecznica;

    @ManyToMany
    @JoinTable(
        name = "zwierzeta_faktury",
        joinColumns = @JoinColumn(name = "faktura_id", insertable = false, updatable = false),
        inverseJoinColumns = @JoinColumn(name = "zwierze_id", insertable = false, updatable = false))
    @Builder.Default
    private Set<ZwierzetaEntity> zwierzeta = new HashSet<>();

    public void setLecznica(LecznicaEntity lecznica) {
        this.lecznica = lecznica;
    }
}
