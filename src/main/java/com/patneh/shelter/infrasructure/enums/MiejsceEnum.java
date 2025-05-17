
package com.patneh.shelter.infrasructure.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum MiejsceEnum {
    LECZNICA("Lecznica"),
    SCHRONISKO("Schronisko"),
    DOM_TYMCZASOWY("Dom_tymczasowy"),
    DOM_STALY("Dom_staly");

    @Getter
    private final String label;
}
