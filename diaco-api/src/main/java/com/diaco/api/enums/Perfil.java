package com.diaco.api.enums;

/**
 *
 * @author elfo_
 */
public enum Perfil {

    ADMINISTRADOR(1),
    OPERADOR(2);

    Integer perfil;

    private Perfil(Integer perfil) {
        this.perfil = perfil;
    }

    public Integer getValue() {
        return this.perfil;
    }

}
