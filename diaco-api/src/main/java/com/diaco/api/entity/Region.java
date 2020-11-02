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
@Table(name = "region")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Region.findAll", query = "SELECT r FROM Region r"),
    @NamedQuery(name = "Region.findByIdregion", query = "SELECT r FROM Region r WHERE r.idregion = :idregion"),
    @NamedQuery(name = "Region.findByRegion", query = "SELECT r FROM Region r WHERE r.region = :region"),
    @NamedQuery(name = "Region.findByFechacreacio", query = "SELECT r FROM Region r WHERE r.fechacreacio = :fechacreacio"),
    @NamedQuery(name = "Region.findByUsuariocreacion", query = "SELECT r FROM Region r WHERE r.usuariocreacion = :usuariocreacion"),
    @NamedQuery(name = "Region.findByFechaeliminacion", query = "SELECT r FROM Region r WHERE r.fechaeliminacion = :fechaeliminacion"),
    @NamedQuery(name = "Region.findByUsuarioeliminacion", query = "SELECT r FROM Region r WHERE r.usuarioeliminacion = :usuarioeliminacion"),
    @NamedQuery(name = "Region.findByActivo", query = "SELECT r FROM Region r WHERE r.activo = :activo")})
public class Region implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idregion")
    private Integer idregion;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "region")
    private String region;
    
    @Column(name = "fechacreacio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacreacio;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
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
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idregion", fetch = FetchType.LAZY)
    private List<Departamento> departamentoList;

    public Region() {
    }

    public Region(Integer idregion) {
        this.idregion = idregion;
    }

    public Region(Integer idregion, String region, String usuariocreacion, boolean activo) {
        this.idregion = idregion;
        this.region = region;
        this.usuariocreacion = usuariocreacion;
        this.activo = activo;
    }

    public Integer getIdregion() {
        return idregion;
    }

    public void setIdregion(Integer idregion) {
        this.idregion = idregion;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Date getFechacreacio() {
        return fechacreacio;
    }

    public void setFechacreacio(Date fechacreacio) {
        this.fechacreacio = fechacreacio;
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
    public List<Departamento> getDepartamentoList() {
        return departamentoList;
    }

    public void setDepartamentoList(List<Departamento> departamentoList) {
        this.departamentoList = departamentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idregion != null ? idregion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Region)) {
            return false;
        }
        Region other = (Region) object;
        if ((this.idregion == null && other.idregion != null) || (this.idregion != null && !this.idregion.equals(other.idregion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diaco.api.entity.Region[ idregion=" + idregion + " ]";
    }
    
}
