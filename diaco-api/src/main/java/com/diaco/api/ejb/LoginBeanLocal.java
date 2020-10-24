package com.diaco.api.ejb;

import com.diaco.api.entity.Usuario;

/**
 *
 * @author rcacacho
 */
public interface LoginBeanLocal {

    Usuario verificarUsuario(String usuario, String password);

    Usuario saveUsuario(Usuario colaborador);

    String findUsuario(String usuario);

}
