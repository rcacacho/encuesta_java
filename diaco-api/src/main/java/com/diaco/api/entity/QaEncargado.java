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
 * @author elfo_
 */
@Entity
@Table(name = "qa_encargado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaEncargado.findAll", query = "SELECT q FROM QaEncargado q"),
    @NamedQuery(name = "QaEncargado.findByIdencargado", query = "SELECT q FROM QaEncargado q WHERE q.idencargado = :idencargado"),
    @NamedQuery(name = "QaEncargado.findByObservacion", query = "SELECT q FROM QaEncargado q WHERE q.observacion = :observacion"),
    @NamedQuery(name = "QaEncargado.findByFechacreacion", query = "SELECT q FROM QaEncargado q WHERE q.fechacreacion = :fechacreacion"),
    @NamedQuery(name = "QaEncargado.findByUsuariocreacion", query = "SELECT q FROM QaEncargado q WHERE q.usuariocreacion = :usuariocreacion"),
    @NamedQuery(name = "QaEncargado.findByFechaeliminacion", query = "SELECT q FROM QaEncargado q WHERE q.fechaeliminacion = :fechaeliminacion"),
    @NamedQuery(name = "QaEncargado.findByUsuarioelminacion", query = "SELECT q FROM QaEncargado q WHERE q.usuarioelminacion = :usuarioelminacion"),
    @NamedQuery(name = "QaEncargado.findByActivo", query = "SELECT q FROM QaEncargado q WHERE q.activo = :activo")})
public class QaEncargado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idencargado")
    private Integer idencargado;
    
    @Size(max = 250)
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
    
    @Column(name = "fechaeliminacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaeliminacion;
    
    @Size(max = 25)
    @Column(name = "usuarioelminacion")
    private String usuarioelminacion;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    
    @JoinColumn(name = "idqueja", referencedColumnName = "idqueja")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private QaQueja idqueja;
    
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private QaUsuario idusuario;

    public QaEncargado() {
    }

    public QaEncargado(Integer idencargado) {
        this.idencargado = idencargado;
    }

    public QaEncargado(Integer idencargado, Date fechacreacion, String usuariocreacion, boolean activo) {
        this.idencargado = idencargado;
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

    public Date getFechaeliminacion() {
        return fechaeliminacion;
    }

    public void setFechaeliminacion(Date fechaeliminacion) {
        this.fechaeliminacion = fechaeliminacion;
    }

    public String getUsuarioelminacion() {
        return usuarioelminacion;
    }

    public void setUsuarioelminacion(String usuarioelminacion) {
        this.usuarioelminacion = usuarioelminacion;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public QaQueja getIdqueja() {
        return idqueja;
    }

    public void setIdqueja(QaQueja idqueja) {
        this.idqueja = idqueja;
    }

    public QaUsuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(QaUsuario idusuario) {
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
        if (!(object instanceof QaEncargado)) {
            return false;
        }
        QaEncargado other = (QaEncargado) object;
        if ((this.idencargado == null && other.idencargado != null) || (this.idencargado != null && !this.idencargado.equals(other.idencargado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diaco.api.entity.QaEncargado[ idencargado=" + idencargado + " ]";
    }
    
}
