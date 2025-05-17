package com.patneh.shelter.infrasructure.entities;

import com.patneh.shelter.common.jpa.entity.BaseEntity;
import com.patneh.shelter.infrasructure.enums.MiejsceEnum;
import com.patneh.shelter.infrasructure.enums.StanEnum;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "zwierzeta")
public class ZwierzetaEntity extends BaseEntity {

    @Id
    @SequenceGenerator(name = "zwierzeta_faktury_id_seq", allocationSize = 1, sequenceName = "zwierzeta_faktury_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "zwierzeta_faktury_id_seq")
    private Long id;

    @Column(nullable = false)
    private String imie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gatunek_id", nullable = false)
    private GatunekEntity gatunek;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "opiekun_id", nullable = false)
    private PracownicyEntity opiekun;
    
    private Integer wiek;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StanEnum stan;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MiejsceEnum miejsce;

    public void setGatunek(GatunekEntity gatunek) {
        this.gatunek = gatunek;
    }
    public void setOpiekun(PracownicyEntity opiekun) {
        this.opiekun = opiekun;
    }

}
