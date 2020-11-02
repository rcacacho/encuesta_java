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
 * @author rcacacho
 */
@Entity
@Table(name = "estadoqueja")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadoqueja.findAll", query = "SELECT e FROM Estadoqueja e"),
    @NamedQuery(name = "Estadoqueja.findByIdestadoqueja", query = "SELECT e FROM Estadoqueja e WHERE e.idestadoqueja = :idestadoqueja"),
    @NamedQuery(name = "Estadoqueja.findByEstado", query = "SELECT e FROM Estadoqueja e WHERE e.estado = :estado"),
    @NamedQuery(name = "Estadoqueja.findByFechacreacion", query = "SELECT e FROM Estadoqueja e WHERE e.fechacreacion = :fechacreacion"),
    @NamedQuery(name = "Estadoqueja.findByUsuariocreacion", query = "SELECT e FROM Estadoqueja e WHERE e.usuariocreacion = :usuariocreacion"),
    @NamedQuery(name = "Estadoqueja.findByActivo", query = "SELECT e FROM Estadoqueja e WHERE e.activo = :activo")})
public class Estadoqueja implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idestadoqueja")
    private Integer idestadoqueja;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "estado")
    private String estado;

    @Basic(optional = false)
    @NotNull
    @Column(name = "fechacreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacreacion;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idestadoqueja", fetch = FetchType.LAZY)
    private List<Queja> quejaList;

    public Estadoqueja() {
    }

    public Estadoqueja(Integer idestadoqueja) {
        this.idestadoqueja = idestadoqueja;
    }

    public Estadoqueja(Integer idestadoqueja, String estado, Date fechacreacion, String usuariocreacion, boolean activo) {
        this.idestadoqueja = idestadoqueja;
        this.estado = estado;
        this.fechacreacion = fechacreacion;
        this.usuariocreacion = usuariocreacion;
        this.activo = activo;
    }

    public Integer getIdestadoqueja() {
        return idestadoqueja;
    }

    public void setIdestadoqueja(Integer idestadoqueja) {
        this.idestadoqueja = idestadoqueja;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
    public List<Queja> getQuejaList() {
        return quejaList;
    }

    public void setQuejaList(List<Queja> quejaList) {
        this.quejaList = quejaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestadoqueja != null ? idestadoqueja.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadoqueja)) {
            return false;
        }
        Estadoqueja other = (Estadoqueja) object;
        if ((this.idestadoqueja == null && other.idestadoqueja != null) || (this.idestadoqueja != null && !this.idestadoqueja.equals(other.idestadoqueja))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diaco.api.entity.Estadoqueja[ idestadoqueja=" + idestadoqueja + " ]";
    }

}
