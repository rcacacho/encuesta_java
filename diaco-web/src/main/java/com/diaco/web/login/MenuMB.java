package com.diaco.web.login;

import com.diaco.api.ejb.UsuarioBeanLocal;
import com.diaco.api.entity.QaPerfil;
import com.diaco.web.utils.SesionUsuarioMB;
import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.apache.log4j.Logger;

/**
 *
 * @author rcacacho
 */
@ManagedBean(name = "menuMB")
@ViewScoped
public class MenuMB implements Serializable {

    private static final Logger log = Logger.getLogger(MenuMB.class);

    private QaPerfil perfil;

    @EJB
    private UsuarioBeanLocal usuarioBean;

    public MenuMB() {
        perfil = new QaPerfil();
    }

    public void cargarDatos() throws IOException {
        if (SesionUsuarioMB.getUserName() != null) {
            QaPerfil response = usuarioBean.findPerfilIdUsuario(SesionUsuarioMB.getUserName());
            if (response != null) {
                perfil = response;
            }
        }
    }

    /*Metodos getters y setters*/
    public QaPerfil getPerfil() {
        return perfil;
    }

    public void setPerfil(QaPerfil perfil) {
        this.perfil = perfil;
    }

}
