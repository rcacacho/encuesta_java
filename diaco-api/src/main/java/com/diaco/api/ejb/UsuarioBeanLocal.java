package com.diaco.api.ejb;

import com.diaco.api.entity.Usuario;
import java.util.List;

/**
 *
 * @author elfo_
 */
public interface UsuarioBeanLocal {

    Usuario saveUsuario(Usuario usuario);

    Usuario findUsuario(Integer idQueja);
    
    List<Usuario> ListaUsuarios();

}
