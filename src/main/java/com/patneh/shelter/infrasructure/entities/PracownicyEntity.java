package com.patneh.shelter.infrasructure.entities;

import com.patneh.shelter.common.jpa.entity.BaseEntity;
import com.patneh.shelter.infrasructure.enums.StanowiskoEnum;
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
@Table(name = "pracownicy")
public class PracownicyEntity extends BaseEntity {

    @Id
    @SequenceGenerator(name = "pracownicy_id_seq", allocationSize = 1, sequenceName = "pracownicy_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pracownicy_id_seq")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "czlowiek_id", nullable = false)
    private LudzieEntity czlowiek;

    @Enumerated(EnumType.STRING)
    @Column(name = "stanowisko", nullable = false)
    private StanowiskoEnum stanowisko;

    public void setCzlowiek(LudzieEntity czlowiek) {
        this.czlowiek = czlowiek;
    }
}
