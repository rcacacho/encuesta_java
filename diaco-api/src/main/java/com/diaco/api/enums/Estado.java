package com.diaco.api.enums;

/**
 *
 * @author rcacacho
 */
public enum Estado {

    REGISTRADA(1),
    INVESTIGACION(2),
    RECHAZADA(3),
    FINALIZADA(4);

    Integer estado;

    private Estado(Integer estado) {
        this.estado = estado;
    }

    public Integer getValue() {
        return this.estado;
    }

}
