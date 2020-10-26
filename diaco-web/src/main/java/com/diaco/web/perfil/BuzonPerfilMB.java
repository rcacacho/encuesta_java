package com.diaco.web.perfil;

import com.diaco.api.ejb.PerfilBeanLocal;
import com.diaco.api.entity.Perfil;
import com.diaco.web.usuario.RegistroUsuarioMB;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.apache.log4j.Logger;

/**
 *
 * @author elfo_
 */
@ManagedBean(name = "buzonPerfilMB")
@ViewScoped
public class BuzonPerfilMB implements Serializable {

    private static final Logger log = Logger.getLogger(RegistroUsuarioMB.class);

    @EJB
    private PerfilBeanLocal perfilBean;

    private List<Perfil> listPerfil;

    @PostConstruct
    void cargarDatos() {
        listPerfil = perfilBean.ListPerfil();
    }

    /*Metdos getters y setters*/
    public List<Perfil> getListPerfil() {
        return listPerfil;
    }

    public void setListPerfil(List<Perfil> listPerfil) {
        this.listPerfil = listPerfil;
    }
}
