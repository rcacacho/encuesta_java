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
@Table(name = "qa_perfil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaPerfil.findAll", query = "SELECT q FROM QaPerfil q"),
    @NamedQuery(name = "QaPerfil.findByIdperfil", query = "SELECT q FROM QaPerfil q WHERE q.idperfil = :idperfil"),
    @NamedQuery(name = "QaPerfil.findByNombre", query = "SELECT q FROM QaPerfil q WHERE q.nombre = :nombre"),
    @NamedQuery(name = "QaPerfil.findByDescripcion", query = "SELECT q FROM QaPerfil q WHERE q.descripcion = :descripcion"),
    @NamedQuery(name = "QaPerfil.findByFechacreacion", query = "SELECT q FROM QaPerfil q WHERE q.fechacreacion = :fechacreacion"),
    @NamedQuery(name = "QaPerfil.findByUsuariocreacion", query = "SELECT q FROM QaPerfil q WHERE q.usuariocreacion = :usuariocreacion"),
    @NamedQuery(name = "QaPerfil.findByFechaeliminacion", query = "SELECT q FROM QaPerfil q WHERE q.fechaeliminacion = :fechaeliminacion"),
    @NamedQuery(name = "QaPerfil.findByUsuarioelminacion", query = "SELECT q FROM QaPerfil q WHERE q.usuarioelminacion = :usuarioelminacion"),
    @NamedQuery(name = "QaPerfil.findByActivo", query = "SELECT q FROM QaPerfil q WHERE q.activo = :activo")})
public class QaPerfil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idperfil")
    private Integer idperfil;
    
    @Size(max = 250)
    @Column(name = "nombre")
    private String nombre;
    
    @Size(max = 500)
    @Column(name = "descripcion")
    private String descripcion;
    
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
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idperfil", fetch = FetchType.LAZY)
    private List<QaUsuario> qaUsuarioList;

    public QaPerfil() {
    }

    public QaPerfil(Integer idperfil) {
        this.idperfil = idperfil;
    }

    public QaPerfil(Integer idperfil, String usuariocreacion, boolean activo) {
        this.idperfil = idperfil;
        this.usuariocreacion = usuariocreacion;
        this.activo = activo;
    }

    public Integer getIdperfil() {
        return idperfil;
    }

    public void setIdperfil(Integer idperfil) {
        this.idperfil = idperfil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    @XmlTransient
    public List<QaUsuario> getQaUsuarioList() {
        return qaUsuarioList;
    }

    public void setQaUsuarioList(List<QaUsuario> qaUsuarioList) {
        this.qaUsuarioList = qaUsuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idperfil != null ? idperfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QaPerfil)) {
            return false;
        }
        QaPerfil other = (QaPerfil) object;
        if ((this.idperfil == null && other.idperfil != null) || (this.idperfil != null && !this.idperfil.equals(other.idperfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diaco.api.entity.QaPerfil[ idperfil=" + idperfil + " ]";
    }
    
}
