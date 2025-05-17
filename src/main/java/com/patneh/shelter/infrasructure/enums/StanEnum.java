
package com.patneh.shelter.infrasructure.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum StanEnum {
    NOWY("Nowy"),
    DO_SPRAWDZENIA("Do_sprawdzenia"),
    DO_ADOPCJI("Do_adopcji"),
    ADOPTOWANY("Adoptowany");

    @Getter
    private final String label;
}
