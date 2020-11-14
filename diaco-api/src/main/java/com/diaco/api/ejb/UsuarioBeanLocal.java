package com.diaco.api.ejb;

import com.diaco.api.entity.QaPerfil;
import com.diaco.api.entity.QaUsuario;
import java.util.List;

/**
 *
 * @author elfo_
 */
public interface UsuarioBeanLocal {

    QaUsuario saveUsuario(QaUsuario usuario);

    QaUsuario findUsuario(Integer idQueja);

    List<QaUsuario> ListaUsuarios();

    QaUsuario reinicioPassword(Integer idusuario, String password);

    QaPerfil findPerfilIdUsuario(String usuario);

    QaUsuario eliminarUsuario(Integer idusuario);

}
