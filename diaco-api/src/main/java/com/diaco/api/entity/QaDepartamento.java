package com.diaco.api.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author elfo_
 */
@Entity
@Table(name = "qa_departamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaDepartamento.findAll", query = "SELECT q FROM QaDepartamento q"),
    @NamedQuery(name = "QaDepartamento.findByIddepartamento", query = "SELECT q FROM QaDepartamento q WHERE q.iddepartamento = :iddepartamento"),
    @NamedQuery(name = "QaDepartamento.findByDepartamento", query = "SELECT q FROM QaDepartamento q WHERE q.departamento = :departamento"),
    @NamedQuery(name = "QaDepartamento.findByFechacreacion", query = "SELECT q FROM QaDepartamento q WHERE q.fechacreacion = :fechacreacion"),
    @NamedQuery(name = "QaDepartamento.findByUsuariocreacion", query = "SELECT q FROM QaDepartamento q WHERE q.usuariocreacion = :usuariocreacion"),
    @NamedQuery(name = "QaDepartamento.findByFechaeliminacion", query = "SELECT q FROM QaDepartamento q WHERE q.fechaeliminacion = :fechaeliminacion"),
    @NamedQuery(name = "QaDepartamento.findByUsuarioeliminacion", query = "SELECT q FROM QaDepartamento q WHERE q.usuarioeliminacion = :usuarioeliminacion"),
    @NamedQuery(name = "QaDepartamento.findByActivo", query = "SELECT q FROM QaDepartamento q WHERE q.activo = :activo")})
public class QaDepartamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddepartamento")
    private Integer iddepartamento;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "departamento")
    private String departamento;
    
    @Column(name = "fechacreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacreacion;
    
    @Size(max = 25)
    @Column(name = "usuariocreacion")
    private String usuariocreacion;
    
    @Column(name = "fechaeliminacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaeliminacion;
    
    @Size(max = 25)
    @Column(name = "usuarioeliminacion")
    private String usuarioeliminacion;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private Boolean activo;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddepartamento", fetch = FetchType.LAZY)
    private List<QaMunicipio> qaMunicipioList;
    
    @JoinColumn(name = "idregion", referencedColumnName = "idregion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private QaRegion idregion;

    public QaDepartamento() {
    }

    public QaDepartamento(Integer iddepartamento) {
        this.iddepartamento = iddepartamento;
    }

    public QaDepartamento(Integer iddepartamento, String departamento, boolean activo) {
        this.iddepartamento = iddepartamento;
        this.departamento = departamento;
        this.activo = activo;
    }

    public Integer getIddepartamento() {
        return iddepartamento;
    }

    public void setIddepartamento(Integer iddepartamento) {
        this.iddepartamento = iddepartamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public String getUsuariocreacion() {
        return usuariocreacion;
    }

    public void setUsuariocreacion(String usuariocreacion) {
        this.usuariocreacion = usuariocreacion;
    }

    public Date getFechaeliminacion() {
        return fechaeliminacion;
    }

    public void setFechaeliminacion(Date fechaeliminacion) {
        this.fechaeliminacion = fechaeliminacion;
    }

    public String getUsuarioeliminacion() {
        return usuarioeliminacion;
    }

    public void setUsuarioeliminacion(String usuarioeliminacion) {
        this.usuarioeliminacion = usuarioeliminacion;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @XmlTransient
    public List<QaMunicipio> getQaMunicipioList() {
        return qaMunicipioList;
    }

    public void setQaMunicipioList(List<QaMunicipio> qaMunicipioList) {
        this.qaMunicipioList = qaMunicipioList;
    }

    public QaRegion getIdregion() {
        return idregion;
    }

    public void setIdregion(QaRegion idregion) {
        this.idregion = idregion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddepartamento != null ? iddepartamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QaDepartamento)) {
            return false;
        }
        QaDepartamento other = (QaDepartamento) object;
        if ((this.iddepartamento == null && other.iddepartamento != null) || (this.iddepartamento != null && !this.iddepartamento.equals(other.iddepartamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diaco.api.entity.QaDepartamento[ iddepartamento=" + iddepartamento + " ]";
    }
    
}
