package com.diaco.api.ejb;

import com.diaco.api.entity.Perfil;
import java.util.List;

/**
 *
 * @author elfo_
 */
public interface PerfilBeanLocal {

    Perfil savePerfil(Perfil perfil);

    Perfil findPerfil(Integer idperfil);

    List<Perfil> ListPerfil();

}
