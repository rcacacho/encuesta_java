package com.diaco.web.perfil;

import com.diaco.api.ejb.PerfilBeanLocal;
import com.diaco.api.entity.Perfil;
import com.diaco.web.utils.JsfUtil;
import com.diaco.web.utils.UtilMB;
import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.apache.log4j.Logger;

/**
 *
 * @author elfo_
 */
@ManagedBean(name = "registroPerfilMB")
@ViewScoped
public class RegistroPerfilMB implements Serializable {

    private static final Logger log = Logger.getLogger(RegistroPerfilMB.class);

    @EJB
    private PerfilBeanLocal perfilBean;

    private Perfil perfil;

    public RegistroPerfilMB() {
        perfil = new Perfil();
    }

    public void crearPerfil() throws IOException {
        perfil.setUsuariocreacion(UtilMB.getUserName());
        Perfil response = perfilBean.savePerfil(perfil);
        if (response != null) {
            JsfUtil.addSuccessMessage("Se creo el perfil exitosamente!");
            perfil = null;
        }
    }

    public void regresarMenu() {
        JsfUtil.redirectTo("/menu/menu.xhtml");
    }

    /*Metodos getters y setters*/
    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

}
