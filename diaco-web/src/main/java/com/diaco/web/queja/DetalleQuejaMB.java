package com.diaco.web.queja;

import com.diaco.api.ejb.QuejaBeanLocal;
import com.diaco.api.entity.QaQueja;
import com.diaco.web.utils.JsfUtil;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.apache.log4j.Logger;

/**
 *
 * @author elfo_
 */
@ManagedBean(name = "detalleQuejaMB")
@ViewScoped
public class DetalleQuejaMB implements Serializable {

    private static final Logger log = Logger.getLogger(RegistroQuejaMB.class);

    @EJB
    private QuejaBeanLocal quejaBean;

    private Integer idQueja;
    private QaQueja queja;

    public DetalleQuejaMB() {
        queja = new QaQueja();
    }

    public void cargarDatos() {
        QaQueja response = quejaBean.findQueja(idQueja);
        if (response != null) {
            queja = response;
        }
    }

    public void regresar() {
        JsfUtil.redirectTo("/queja-configuracion/bandeja.xhtml");
    }

    public void rechazar() {
        QaQueja response = quejaBean.rechazoQueja(idQueja);
        if (response != null) {
            JsfUtil.addSuccessMessage("Se rechazo la queja exitosamente!");
        }
    }

    public void aprobar() {
        QaQueja response = quejaBean.seguimientoQueja(idQueja);
        if (response != null) {
            JsfUtil.addSuccessMessage("Se dio seguimiento la queja exitosamente!");
        }
    }

    /*Metodos getters y setters*/
    public Integer getIdQueja() {
        return idQueja;
    }

    public void setIdQueja(Integer idQueja) {
        this.idQueja = idQueja;
    }

    public QaQueja getQueja() {
        return queja;
    }

    public void setQueja(QaQueja queja) {
        this.queja = queja;
    }

}
