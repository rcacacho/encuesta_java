package com.diaco.web.queja;

import com.diaco.api.ejb.QuejaBeanLocal;
import com.diaco.api.entity.QaEncargado;
import com.diaco.web.utils.JsfUtil;
import com.diaco.web.utils.SesionUsuarioMB;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.apache.log4j.Logger;

/**
 *
 * @author elfo_
 */
@ManagedBean(name = "bandejaEncargadoMB")
@ViewScoped
public class BandejaEncargadoMB implements Serializable {

    private static final Logger log = Logger.getLogger(BandejaQuejaMB.class);

    @EJB
    private QuejaBeanLocal quejaBean;

    private List<QaEncargado> listEncargado;
    private Date fechaInicio;
    private Date fechaFin;
    private Integer idQueja;

    public BandejaEncargadoMB() {
        listEncargado = new ArrayList<>();
    }

    public void cargarDatos() throws IOException {
        if (SesionUsuarioMB.getUserName() == null) {
            JsfUtil.redirectTo("/menu/menu.xhtml");
        }

        List<QaEncargado> responseEncargado = quejaBean.listEncagardo();
        if (responseEncargado != null) {
            listEncargado = responseEncargado;
        }
    }

    public void limpiarCampos() {
        fechaInicio = null;
        fechaFin = null;
        idQueja = null;
        listEncargado = null;
    }

    public void buscarQueja() {
        List<QaEncargado> response = quejaBean.listEncagardo();
        if (response != null) {
            listEncargado = response;
        } else {
            JsfUtil.addErrorMessage("No se encontraron datos");
            listEncargado = null;
        }
    }

    /*Metodos getters y setters*/
    public List<QaEncargado> getListEncargado() {
        return listEncargado;
    }

    public void setListEncargado(List<QaEncargado> listEncargado) {
        this.listEncargado = listEncargado;
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

    public Integer getIdQueja() {
        return idQueja;
    }

    public void setIdQueja(Integer idQueja) {
        this.idQueja = idQueja;
    }

}
