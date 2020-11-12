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
@Table(name = "qa_tipo_consumidor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaTipoConsumidor.findAll", query = "SELECT q FROM QaTipoConsumidor q"),
    @NamedQuery(name = "QaTipoConsumidor.findByIdtipoconsumidor", query = "SELECT q FROM QaTipoConsumidor q WHERE q.idtipoconsumidor = :idtipoconsumidor"),
    @NamedQuery(name = "QaTipoConsumidor.findByConsumidor", query = "SELECT q FROM QaTipoConsumidor q WHERE q.consumidor = :consumidor"),
    @NamedQuery(name = "QaTipoConsumidor.findByFechacreacion", query = "SELECT q FROM QaTipoConsumidor q WHERE q.fechacreacion = :fechacreacion"),
    @NamedQuery(name = "QaTipoConsumidor.findByUsuariocreacion", query = "SELECT q FROM QaTipoConsumidor q WHERE q.usuariocreacion = :usuariocreacion"),
    @NamedQuery(name = "QaTipoConsumidor.findByFechaeliminacion", query = "SELECT q FROM QaTipoConsumidor q WHERE q.fechaeliminacion = :fechaeliminacion"),
    @NamedQuery(name = "QaTipoConsumidor.findByUsuarioeliminacion", query = "SELECT q FROM QaTipoConsumidor q WHERE q.usuarioeliminacion = :usuarioeliminacion"),
    @NamedQuery(name = "QaTipoConsumidor.findByActivo", query = "SELECT q FROM QaTipoConsumidor q WHERE q.activo = :activo")})
public class QaTipoConsumidor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipoconsumidor")
    private Integer idtipoconsumidor;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "consumidor")
    private String consumidor;
    
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
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtipoconsumidor", fetch = FetchType.LAZY)
    private List<QaQueja> qaQuejaList;

    public QaTipoConsumidor() {
    }

    public QaTipoConsumidor(Integer idtipoconsumidor) {
        this.idtipoconsumidor = idtipoconsumidor;
    }

    public QaTipoConsumidor(Integer idtipoconsumidor, String consumidor, boolean activo) {
        this.idtipoconsumidor = idtipoconsumidor;
        this.consumidor = consumidor;
        this.activo = activo;
    }

    public Integer getIdtipoconsumidor() {
        return idtipoconsumidor;
    }

    public void setIdtipoconsumidor(Integer idtipoconsumidor) {
        this.idtipoconsumidor = idtipoconsumidor;
    }

    public String getConsumidor() {
        return consumidor;
    }

    public void setConsumidor(String consumidor) {
        this.consumidor = consumidor;
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
    public List<QaQueja> getQaQuejaList() {
        return qaQuejaList;
    }

    public void setQaQuejaList(List<QaQueja> qaQuejaList) {
        this.qaQuejaList = qaQuejaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoconsumidor != null ? idtipoconsumidor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QaTipoConsumidor)) {
            return false;
        }
        QaTipoConsumidor other = (QaTipoConsumidor) object;
        if ((this.idtipoconsumidor == null && other.idtipoconsumidor != null) || (this.idtipoconsumidor != null && !this.idtipoconsumidor.equals(other.idtipoconsumidor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diaco.api.entity.QaTipoConsumidor[ idtipoconsumidor=" + idtipoconsumidor + " ]";
    }
    
}
