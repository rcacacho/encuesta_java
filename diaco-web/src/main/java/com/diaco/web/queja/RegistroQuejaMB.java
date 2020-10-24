package com.diaco.web.queja;

import com.diaco.api.ejb.CatalogoBeanLocal;
import com.diaco.api.ejb.QuejaBeanLocal;
import com.diaco.api.entity.Departamento;
import com.diaco.api.entity.Genero;
import com.diaco.api.entity.Municipio;
import com.diaco.api.entity.Queja;
import com.diaco.api.entity.Region;
import com.diaco.api.entity.Tipoconsumidor;
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

    private Queja queja;
    private List<Departamento> listDepartamentos;
    private List<Municipio> listMunicipios;
    private Municipio municipioSelected;
    private Departamento departamentoSelected;
    private List<Tipoconsumidor> listTipoConsumidor;
    private Tipoconsumidor tipoConsumidor;
    private List<Genero> listGenero;
    private Genero genero;
    private List<Region> listRegion;
    private Region selectedRegion;
    private Integer codigoQueja;

    public RegistroQuejaMB() {
        queja = new Queja();
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
    public Queja getQueja() {
        return queja;
    }

    public void setQueja(Queja queja) {
        this.queja = queja;
    }

    public List<Departamento> getListDepartamentos() {
        return listDepartamentos;
    }

    public void setListDepartamentos(List<Departamento> listDepartamentos) {
        this.listDepartamentos = listDepartamentos;
    }

    public List<Municipio> getListMunicipios() {
        return listMunicipios;
    }

    public void setListMunicipios(List<Municipio> listMunicipios) {
        this.listMunicipios = listMunicipios;
    }

    public Municipio getMunicipioSelected() {
        return municipioSelected;
    }

    public void setMunicipioSelected(Municipio municipioSelected) {
        this.municipioSelected = municipioSelected;
    }

    public Departamento getDepartamentoSelected() {
        return departamentoSelected;
    }

    public void setDepartamentoSelected(Departamento departamentoSelected) {
        this.departamentoSelected = departamentoSelected;
    }

    public List<Tipoconsumidor> getListTipoConsumidor() {
        return listTipoConsumidor;
    }

    public void setListTipoConsumidor(List<Tipoconsumidor> listTipoConsumidor) {
        this.listTipoConsumidor = listTipoConsumidor;
    }

    public Tipoconsumidor getTipoConsumidor() {
        return tipoConsumidor;
    }

    public void setTipoConsumidor(Tipoconsumidor tipoConsumidor) {
        this.tipoConsumidor = tipoConsumidor;
    }

    public List<Genero> getListGenero() {
        return listGenero;
    }

    public void setListGenero(List<Genero> listGenero) {
        this.listGenero = listGenero;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public List<Region> getListRegion() {
        return listRegion;
    }

    public void setListRegion(List<Region> listRegion) {
        this.listRegion = listRegion;
    }

    public Region getSelectedRegion() {
        return selectedRegion;
    }

    public void setSelectedRegion(Region selectedRegion) {
        this.selectedRegion = selectedRegion;
    }

    public Integer getCodigoQueja() {
        return codigoQueja;
    }

    public void setCodigoQueja(Integer codigoQueja) {
        this.codigoQueja = codigoQueja;
    }

}
