package com.diaco.api.ejb;

import com.diaco.api.entity.Perfil;
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
    
    Usuario reinicioPassword(Integer idusuario, String password);
    
    Perfil findPerfilIdUsuario(Integer idPerfil);
    
        Usuario eliminarUsuario(Integer idusuario);

}
