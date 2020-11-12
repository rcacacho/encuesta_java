package com.diaco.web.queja;

import com.diaco.api.ejb.CatalogoBeanLocal;
import com.diaco.api.ejb.QuejaBeanLocal;
import com.diaco.api.entity.QaDepartamento;
import com.diaco.api.entity.QaGenero;
import com.diaco.api.entity.QaMunicipio;
import com.diaco.api.entity.QaQueja;
import com.diaco.api.entity.QaRegion;
import com.diaco.api.entity.QaTipoConsumidor;
import com.diaco.web.utils.JsfUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;

/**
 *
 * @author rcacacho
 */
@ManagedBean(name = "registroQuejaMB")
@ViewScoped
public class RegistroQuejaMB implements Serializable {

    private static final Logger log = Logger.getLogger(RegistroQuejaMB.class);

    @EJB
    private QuejaBeanLocal quejaBean;
    @EJB
    private CatalogoBeanLocal catalogoBean;

    private QaQueja queja;
    private List<QaDepartamento> listDepartamentos;
    private List<QaMunicipio> listMunicipios;
    private QaMunicipio municipioSelected;
    private QaDepartamento departamentoSelected;
    private List<QaTipoConsumidor> listTipoConsumidor;
    private QaTipoConsumidor tipoConsumidor;
    private List<QaGenero> listGenero;
    private QaGenero genero;
    private List<QaRegion> listRegion;
    private QaRegion selectedRegion;
    private Integer codigoQueja;

    public RegistroQuejaMB() {
        queja = new QaQueja();
    }

    @PostConstruct
    void cargarDatos() {
        listRegion = catalogoBean.listRegion();
        listTipoConsumidor = catalogoBean.listTipoConsumidor();
        listGenero = catalogoBean.listGenero();
    }

    public void cargarMunicipio() {
        if (departamentoSelected != null) {
            listMunicipios = catalogoBean.listMunicipioByIdDepartamento(departamentoSelected.getIddepartamento());
        } else {
            listMunicipios = null;
            municipioSelected = null;
        }
    }

    public void cargarDepartamento() {
        if (selectedRegion != null) {
            listDepartamentos = catalogoBean.listDepartamentoByIdRegion(selectedRegion.getIdregion());
        } else {
            listDepartamentos = null;
            departamentoSelected = null;
        }
    }

    public void saveQueja() {
        queja.setIdmunicipio(municipioSelected);
        queja.setIdgenero(genero);
        queja.setIdtipoconsumidor(tipoConsumidor);

        quejaBean.saveQueja(queja);

        codigoQueja = queja.getIdqueja();
        JsfUtil.addSuccessMessage("Queja guardada exitosamente");
        RequestContext.getCurrentInstance().execute("PF('dlgCorrelativo').show()");
        selectedRegion = null;
        queja = null;
        departamentoSelected = null;
        municipioSelected = null;
        genero = null;
    }

    public void regresar() {
        JsfUtil.redirectTo("index.xhtml");
    }

    public void limpiarCampos() {

    }

    /*Metodos getters y setters*/
    public QaQueja getQueja() {
        return queja;
    }

    public void setQueja(QaQueja queja) {
        this.queja = queja;
    }

    public List<QaDepartamento> getListDepartamentos() {
        return listDepartamentos;
    }

    public void setListDepartamentos(List<QaDepartamento> listDepartamentos) {
        this.listDepartamentos = listDepartamentos;
    }

    public List<QaMunicipio> getListMunicipios() {
        return listMunicipios;
    }

    public void setListMunicipios(List<QaMunicipio> listMunicipios) {
        this.listMunicipios = listMunicipios;
    }

    public QaMunicipio getMunicipioSelected() {
        return municipioSelected;
    }

    public void setMunicipioSelected(QaMunicipio municipioSelected) {
        this.municipioSelected = municipioSelected;
    }

    public QaDepartamento getDepartamentoSelected() {
        return departamentoSelected;
    }

    public void setDepartamentoSelected(QaDepartamento departamentoSelected) {
        this.departamentoSelected = departamentoSelected;
    }

    public List<QaTipoConsumidor> getListTipoConsumidor() {
        return listTipoConsumidor;
    }

    public void setListTipoConsumidor(List<QaTipoConsumidor> listTipoConsumidor) {
        this.listTipoConsumidor = listTipoConsumidor;
    }

    public QaTipoConsumidor getTipoConsumidor() {
        return tipoConsumidor;
    }

    public void setTipoConsumidor(QaTipoConsumidor tipoConsumidor) {
        this.tipoConsumidor = tipoConsumidor;
    }

    public List<QaGenero> getListGenero() {
        return listGenero;
    }

    public void setListGenero(List<QaGenero> listGenero) {
        this.listGenero = listGenero;
    }

    public QaGenero getGenero() {
        return genero;
    }

    public void setGenero(QaGenero genero) {
        this.genero = genero;
    }

    public List<QaRegion> getListRegion() {
        return listRegion;
    }

    public void setListRegion(List<QaRegion> listRegion) {
        this.listRegion = listRegion;
    }

    public QaRegion getSelectedRegion() {
        return selectedRegion;
    }

    public void setSelectedRegion(QaRegion selectedRegion) {
        this.selectedRegion = selectedRegion;
    }

    public Integer getCodigoQueja() {
        return codigoQueja;
    }

    public void setCodigoQueja(Integer codigoQueja) {
        this.codigoQueja = codigoQueja;
    }

}
