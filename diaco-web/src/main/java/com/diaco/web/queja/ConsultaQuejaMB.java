package com.diaco.web.queja;

import com.diaco.api.ejb.QuejaBeanLocal;
import com.diaco.api.entity.Queja;
import com.diaco.web.utils.JsfUtil;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.apache.log4j.Logger;

/**
 *
 * @author rcacacho
 */
@ManagedBean(name = "consultaQuejaMB")
@ViewScoped
public class ConsultaQuejaMB implements Serializable {

    private static final Logger log = Logger.getLogger(RegistroQuejaMB.class);

    @EJB
    private QuejaBeanLocal quejaBean;

    private List<Queja> listQueja;
    private Integer idqueja;

    public void buscarQueja() {
        List<Queja> response = quejaBean.listQuejaByIdQueja(idqueja);
        if (response.size() > 0) {
            listQueja = response;
        } else {
            JsfUtil.addErrorMessage("No se encontraron datos");
        }
    }
    
    public void limpiarCampos(){
        idqueja = null;
        listQueja = null;
    }

    /*Metodos getters y setters*/
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

}
