package com.diaco.api.ejb;

import com.diaco.api.entity.QaPerfil;
import java.util.List;

/**
 *
 * @author elfo_
 */
public interface PerfilBeanLocal {

    QaPerfil savePerfil(QaPerfil perfil);

    QaPerfil findPerfil(Integer idperfil);

    List<QaPerfil> ListPerfil();

    QaPerfil eliminarPerfil(Integer idperfil);

    QaPerfil actualizarPerfil(QaPerfil perfil);

}
