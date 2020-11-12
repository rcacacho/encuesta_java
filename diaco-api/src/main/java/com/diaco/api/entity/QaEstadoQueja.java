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
@Table(name = "qa_estado_queja")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaEstadoQueja.findAll", query = "SELECT q FROM QaEstadoQueja q"),
    @NamedQuery(name = "QaEstadoQueja.findByIdestadoqueja", query = "SELECT q FROM QaEstadoQueja q WHERE q.idestadoqueja = :idestadoqueja"),
    @NamedQuery(name = "QaEstadoQueja.findByEstado", query = "SELECT q FROM QaEstadoQueja q WHERE q.estado = :estado"),
    @NamedQuery(name = "QaEstadoQueja.findByFechacreacion", query = "SELECT q FROM QaEstadoQueja q WHERE q.fechacreacion = :fechacreacion"),
    @NamedQuery(name = "QaEstadoQueja.findByUsuariocreacion", query = "SELECT q FROM QaEstadoQueja q WHERE q.usuariocreacion = :usuariocreacion"),
    @NamedQuery(name = "QaEstadoQueja.findByFechaeliminacion", query = "SELECT q FROM QaEstadoQueja q WHERE q.fechaeliminacion = :fechaeliminacion"),
    @NamedQuery(name = "QaEstadoQueja.findByUsuarioelminacion", query = "SELECT q FROM QaEstadoQueja q WHERE q.usuarioelminacion = :usuarioelminacion"),
    @NamedQuery(name = "QaEstadoQueja.findByActivo", query = "SELECT q FROM QaEstadoQueja q WHERE q.activo = :activo")})
public class QaEstadoQueja implements Serializable {

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
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idestadoqueja", fetch = FetchType.LAZY)
    private List<QaQueja> qaQuejaList;

    public QaEstadoQueja() {
    }

    public QaEstadoQueja(Integer idestadoqueja) {
        this.idestadoqueja = idestadoqueja;
    }

    public QaEstadoQueja(Integer idestadoqueja, String estado, Date fechacreacion, String usuariocreacion, boolean activo) {
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
    public List<QaQueja> getQaQuejaList() {
        return qaQuejaList;
    }

    public void setQaQuejaList(List<QaQueja> qaQuejaList) {
        this.qaQuejaList = qaQuejaList;
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
        if (!(object instanceof QaEstadoQueja)) {
            return false;
        }
        QaEstadoQueja other = (QaEstadoQueja) object;
        if ((this.idestadoqueja == null && other.idestadoqueja != null) || (this.idestadoqueja != null && !this.idestadoqueja.equals(other.idestadoqueja))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diaco.api.entity.QaEstadoQueja[ idestadoqueja=" + idestadoqueja + " ]";
    }
    
}
