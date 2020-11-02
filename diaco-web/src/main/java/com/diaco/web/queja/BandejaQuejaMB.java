package com.diaco.web.queja;

import com.diaco.api.ejb.CatalogoBeanLocal;
import com.diaco.api.ejb.QuejaBeanLocal;
import com.diaco.api.entity.Queja;
import com.diaco.api.entity.Usuario;
import com.diaco.web.utils.JsfUtil;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;

/**
 *
 * @author elfo_
 */
@ManagedBean(name = "bandejaQuejaMB")
@ViewScoped
public class BandejaQuejaMB implements Serializable {

    private static final Logger log = Logger.getLogger(BandejaQuejaMB.class);

    @EJB
    private QuejaBeanLocal quejaBean;
    @EJB
    private CatalogoBeanLocal catalogoBean;

    private List<Queja> listQueja;
    private Integer idqueja;
    private Date fechaInicio;
    private Date fechaFin;
    private List<Usuario> listUsuario;
    private Usuario selectedUsuario;

    public BandejaQuejaMB() {
        listQueja = new ArrayList<>();
        listUsuario = new ArrayList<>();
    }

    public void cargarDatos() {
        if (fechaInicio == null || fechaFin == null) {
            List<Queja> response = quejaBean.listAllQueja();
            if (response != null) {
                listQueja = response;
            }
        }
        List<Usuario> responseUsuario = catalogoBean.listUsuario();
        if (responseUsuario != null) {
            listUsuario = responseUsuario;
        }
    }

    public void buscarQueja() {
        List<Queja> response = quejaBean.listQuejaByFechaCreacion(fechaInicio, fechaFin);
        if (response.size() > 0) {
            listQueja = response;
        } else {
            JsfUtil.addErrorMessage("No se encontraron datos");
        }
    }

    public void limpiarCampos() {
        fechaInicio = null;
        fechaFin = null;
        listQueja = null;
    }

    public void dialogAsignacion(Integer id) {
        idqueja = id;
        RequestContext.getCurrentInstance().execute("PF('dlgAsignacion').show()");
    }

    public void cerraDialog() {
        RequestContext.getCurrentInstance().execute("PF('dlgAsignacion').hide()");
    }

    public void asignarUsuario() {
        if (selectedUsuario == null) {
            JsfUtil.addErrorMessage("Debe seleccionar un usuario");
            return;
        }
        
    }

    /*Metodos getters y setteres*/
    public List<Queja> getListQueja() {
        return listQueja;
    }

    public void setListQueja(List<Queja> listQueja) {
        this.listQueja = listQueja;
    }

    public Integer getIdqueja() {
        return idqueja;
    }

    public void setIdqueja(Integer idqueja) {
        this.idqueja = idqueja;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public List<Usuario> getListUsuario() {
        return listUsuario;
    }

    public void setListUsuario(List<Usuario> listUsuario) {
        this.listUsuario = listUsuario;
    }

    public Usuario getSelectedUsuario() {
        return selectedUsuario;
    }

    public void setSelectedUsuario(Usuario selectedUsuario) {
        this.selectedUsuario = selectedUsuario;
    }

}
