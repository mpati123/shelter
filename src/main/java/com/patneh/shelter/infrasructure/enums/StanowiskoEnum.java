
package com.patneh.shelter.infrasructure.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum StanowiskoEnum {
    DYREKTOR("Dyrektor"),
    PRACOWNIK("Pracownik"),
    WOLONTARIUSZ("Wolontariusz"),
    LEKARZ("Lekarz");

    @Getter
    private final String label;
}
