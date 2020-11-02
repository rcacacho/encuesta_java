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
@Table(name = "tipoconsumidor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoconsumidor.findAll", query = "SELECT t FROM Tipoconsumidor t"),
    @NamedQuery(name = "Tipoconsumidor.findByIdtipoconsumidor", query = "SELECT t FROM Tipoconsumidor t WHERE t.idtipoconsumidor = :idtipoconsumidor"),
    @NamedQuery(name = "Tipoconsumidor.findByConsumidor", query = "SELECT t FROM Tipoconsumidor t WHERE t.consumidor = :consumidor"),
    @NamedQuery(name = "Tipoconsumidor.findByFechacreacion", query = "SELECT t FROM Tipoconsumidor t WHERE t.fechacreacion = :fechacreacion"),
    @NamedQuery(name = "Tipoconsumidor.findByUsuariocreacion", query = "SELECT t FROM Tipoconsumidor t WHERE t.usuariocreacion = :usuariocreacion"),
    @NamedQuery(name = "Tipoconsumidor.findByFechaeliminacion", query = "SELECT t FROM Tipoconsumidor t WHERE t.fechaeliminacion = :fechaeliminacion"),
    @NamedQuery(name = "Tipoconsumidor.findByUsuarioeliminacion", query = "SELECT t FROM Tipoconsumidor t WHERE t.usuarioeliminacion = :usuarioeliminacion"),
    @NamedQuery(name = "Tipoconsumidor.findByActivo", query = "SELECT t FROM Tipoconsumidor t WHERE t.activo = :activo")})
public class Tipoconsumidor implements Serializable {

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
    private List<Queja> quejaList;

    public Tipoconsumidor() {
    }

    public Tipoconsumidor(Integer idtipoconsumidor) {
        this.idtipoconsumidor = idtipoconsumidor;
    }

    public Tipoconsumidor(Integer idtipoconsumidor, String consumidor, boolean activo) {
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
    public List<Queja> getQuejaList() {
        return quejaList;
    }

    public void setQuejaList(List<Queja> quejaList) {
        this.quejaList = quejaList;
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
        if (!(object instanceof Tipoconsumidor)) {
            return false;
        }
        Tipoconsumidor other = (Tipoconsumidor) object;
        if ((this.idtipoconsumidor == null && other.idtipoconsumidor != null) || (this.idtipoconsumidor != null && !this.idtipoconsumidor.equals(other.idtipoconsumidor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diaco.api.entity.Tipoconsumidor[ idtipoconsumidor=" + idtipoconsumidor + " ]";
    }
    
}
