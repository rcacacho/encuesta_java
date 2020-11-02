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
@Table(name = "genero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Genero.findAll", query = "SELECT g FROM Genero g"),
    @NamedQuery(name = "Genero.findByIdgenero", query = "SELECT g FROM Genero g WHERE g.idgenero = :idgenero"),
    @NamedQuery(name = "Genero.findByGenero", query = "SELECT g FROM Genero g WHERE g.genero = :genero"),
    @NamedQuery(name = "Genero.findByFechacreacion", query = "SELECT g FROM Genero g WHERE g.fechacreacion = :fechacreacion"),
    @NamedQuery(name = "Genero.findByUsuariocreacion", query = "SELECT g FROM Genero g WHERE g.usuariocreacion = :usuariocreacion"),
    @NamedQuery(name = "Genero.findByFechaeliminacion", query = "SELECT g FROM Genero g WHERE g.fechaeliminacion = :fechaeliminacion"),
    @NamedQuery(name = "Genero.findByUsuarioeliminacion", query = "SELECT g FROM Genero g WHERE g.usuarioeliminacion = :usuarioeliminacion"),
    @NamedQuery(name = "Genero.findByActivo", query = "SELECT g FROM Genero g WHERE g.activo = :activo")})
public class Genero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idgenero")
    private Integer idgenero;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "genero")
    private String genero;

    @Column(name = "fechacreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacreacion;

    @Column(name = "usuariocreacion")
    private String usuariocreacion;

    @Column(name = "fechaeliminacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaeliminacion;

    @Column(name = "usuarioeliminacion")
    private String usuarioeliminacion;

    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idgenero", fetch = FetchType.LAZY)
    private List<Queja> quejaList;

    public Genero() {
    }

    public Genero(Integer idgenero) {
        this.idgenero = idgenero;
    }

    public Genero(Integer idgenero, String genero, boolean activo) {
        this.idgenero = idgenero;
        this.genero = genero;
        this.activo = activo;
    }

    public Integer getIdgenero() {
        return idgenero;
    }

    public void setIdgenero(Integer idgenero) {
        this.idgenero = idgenero;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public Date getFechaeliminacion() {
        return fechaeliminacion;
    }

    public void setFechaeliminacion(Date fechaeliminacion) {
        this.fechaeliminacion = fechaeliminacion;
    }

    public String getUsuariocreacion() {
        return usuariocreacion;
    }

    public void setUsuariocreacion(String usuariocreacion) {
        this.usuariocreacion = usuariocreacion;
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
        hash += (idgenero != null ? idgenero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Genero)) {
            return false;
        }
        Genero other = (Genero) object;
        if ((this.idgenero == null && other.idgenero != null) || (this.idgenero != null && !this.idgenero.equals(other.idgenero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diaco.api.entity.Genero[ idgenero=" + idgenero + " ]";
    }

}
