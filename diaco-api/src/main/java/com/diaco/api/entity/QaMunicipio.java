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
@Table(name = "qa_municipio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaMunicipio.findAll", query = "SELECT q FROM QaMunicipio q"),
    @NamedQuery(name = "QaMunicipio.findByIdmunicipio", query = "SELECT q FROM QaMunicipio q WHERE q.idmunicipio = :idmunicipio"),
    @NamedQuery(name = "QaMunicipio.findByMunicipio", query = "SELECT q FROM QaMunicipio q WHERE q.municipio = :municipio"),
    @NamedQuery(name = "QaMunicipio.findByFechacreacion", query = "SELECT q FROM QaMunicipio q WHERE q.fechacreacion = :fechacreacion"),
    @NamedQuery(name = "QaMunicipio.findByUsuariocreacion", query = "SELECT q FROM QaMunicipio q WHERE q.usuariocreacion = :usuariocreacion"),
    @NamedQuery(name = "QaMunicipio.findByFechaeliminacion", query = "SELECT q FROM QaMunicipio q WHERE q.fechaeliminacion = :fechaeliminacion"),
    @NamedQuery(name = "QaMunicipio.findByUsuarioeliminacion", query = "SELECT q FROM QaMunicipio q WHERE q.usuarioeliminacion = :usuarioeliminacion"),
    @NamedQuery(name = "QaMunicipio.findByActivo", query = "SELECT q FROM QaMunicipio q WHERE q.activo = :activo")})
public class QaMunicipio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmunicipio")
    private Integer idmunicipio;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "municipio")
    private String municipio;
    
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
    private boolean activo;
    
    @JoinColumn(name = "iddepartamento", referencedColumnName = "iddepartamento")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private QaDepartamento iddepartamento;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmunicipio", fetch = FetchType.LAZY)
    private List<QaQueja> qaQuejaList;

    public QaMunicipio() {
    }

    public QaMunicipio(Integer idmunicipio) {
        this.idmunicipio = idmunicipio;
    }

    public QaMunicipio(Integer idmunicipio, String municipio, boolean activo) {
        this.idmunicipio = idmunicipio;
        this.municipio = municipio;
        this.activo = activo;
    }

    public Integer getIdmunicipio() {
        return idmunicipio;
    }

    public void setIdmunicipio(Integer idmunicipio) {
        this.idmunicipio = idmunicipio;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
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

    public QaDepartamento getIddepartamento() {
        return iddepartamento;
    }

    public void setIddepartamento(QaDepartamento iddepartamento) {
        this.iddepartamento = iddepartamento;
    }

    @XmlTransient
    public List<QaQueja> getQaQuejaList() {
        return qaQuejaList;
    }

    public void setQaQuejaList(List<QaQueja> qaQuejaList) {
        this.qaQuejaList = qaQuejaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmunicipio != null ? idmunicipio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QaMunicipio)) {
            return false;
        }
        QaMunicipio other = (QaMunicipio) object;
        if ((this.idmunicipio == null && other.idmunicipio != null) || (this.idmunicipio != null && !this.idmunicipio.equals(other.idmunicipio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diaco.api.entity.QaMunicipio[ idmunicipio=" + idmunicipio + " ]";
    }
    
}
