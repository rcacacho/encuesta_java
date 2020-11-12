package com.diaco.api.ejb;

import com.diaco.api.entity.QaUsuario;

/**
 *
 * @author rcacacho
 */
public interface LoginBeanLocal {

    QaUsuario verificarUsuario(String usuario, String password);

    QaUsuario saveUsuario(QaUsuario colaborador);

    String findUsuario(String usuario);

}
