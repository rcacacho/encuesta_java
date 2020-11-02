package com.diaco.web.perfil;

import com.diaco.api.ejb.PerfilBeanLocal;
import com.diaco.api.entity.Perfil;
import com.diaco.web.utils.JsfUtil;
import java.io.Serializable;
import java.util.List;
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

    private static final Logger log = Logger.getLogger(BuzonPerfilMB.class);

    @EJB
    private PerfilBeanLocal perfilBean;

    private List<Perfil> listPerfil;

   public void cargarPerfiles() {
        listPerfil = perfilBean.ListPerfil();
    }

    public void editarPerfil(Perfil per) {
        Perfil response = perfilBean.actualizarPerfil(per);
        if (response != null) {
            JsfUtil.addSuccessMessage("Se actualizo el perfil exitosamente");
            return;
        }

        JsfUtil.addErrorMessage("Sucedio un error al actualizar");
    }

    public void eliminarPerfil(Integer idperfil) {
        Perfil response = perfilBean.eliminarPerfil(idperfil);
        if (response != null) {
            JsfUtil.addSuccessMessage("Se elimino el perfil exitosamente");
            return;
        }

        JsfUtil.addErrorMessage("Sucedio un error al elimnar");
    }

    /*Metdos getters y setters*/
    public List<Perfil> getListPerfil() {
        return listPerfil;
    }

    public void setListPerfil(List<Perfil> listPerfil) {
        this.listPerfil = listPerfil;
    }
}
