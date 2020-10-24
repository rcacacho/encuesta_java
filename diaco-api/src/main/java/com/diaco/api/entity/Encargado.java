package com.diaco.api.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author rcacacho
 */
@Entity
@Table(name = "encargado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Encargado.findAll", query = "SELECT e FROM Encargado e"),
    @NamedQuery(name = "Encargado.findByIdencargado", query = "SELECT e FROM Encargado e WHERE e.idencargado = :idencargado"),
    @NamedQuery(name = "Encargado.findByObservacion", query = "SELECT e FROM Encargado e WHERE e.observacion = :observacion"),
    @NamedQuery(name = "Encargado.findByFechacreacion", query = "SELECT e FROM Encargado e WHERE e.fechacreacion = :fechacreacion"),
    @NamedQuery(name = "Encargado.findByUsuariocreacion", query = "SELECT e FROM Encargado e WHERE e.usuariocreacion = :usuariocreacion"),
    @NamedQuery(name = "Encargado.findByActivo", query = "SELECT e FROM Encargado e WHERE e.activo = :activo")})
public class Encargado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idencargado")
    private Integer idencargado;
    
    @Size(min = 1, max = 250)
    @Column(name = "observacion")
    private String observacion;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechacreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacreacion;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "usuariocreacion")
    private String usuariocreacion;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    
    @JoinColumn(name = "idqueja", referencedColumnName = "idqueja")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Queja idqueja;
    
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario idusuario;

    public Encargado() {
    }

    public Encargado(Integer idencargado) {
        this.idencargado = idencargado;
    }

    public Encargado(Integer idencargado, String observacion, Date fechacreacion, String usuariocreacion, boolean activo) {
        this.idencargado = idencargado;
        this.observacion = observacion;
        this.fechacreacion = fechacreacion;
        this.usuariocreacion = usuariocreacion;
        this.activo = activo;
    }

    public Integer getIdencargado() {
        return idencargado;
    }

    public void setIdencargado(Integer idencargado) {
        this.idencargado = idencargado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
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

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Queja getIdqueja() {
        return idqueja;
    }

    public void setIdqueja(Queja idqueja) {
        this.idqueja = idqueja;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idencargado != null ? idencargado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Encargado)) {
            return false;
        }
        Encargado other = (Encargado) object;
        if ((this.idencargado == null && other.idencargado != null) || (this.idencargado != null && !this.idencargado.equals(other.idencargado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diaco.api.entity.Encargado[ idencargado=" + idencargado + " ]";
    }

}
