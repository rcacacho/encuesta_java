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
@Table(name = "queja")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Queja.findAll", query = "SELECT q FROM Queja q"),
    @NamedQuery(name = "Queja.findByIdqueja", query = "SELECT q FROM Queja q WHERE q.idqueja = :idqueja"),
    @NamedQuery(name = "Queja.findByNombrecomercio", query = "SELECT q FROM Queja q WHERE q.nombrecomercio = :nombrecomercio"),
    @NamedQuery(name = "Queja.findByDireccioncomercio", query = "SELECT q FROM Queja q WHERE q.direccioncomercio = :direccioncomercio"),
    @NamedQuery(name = "Queja.findByTelefonocomercio", query = "SELECT q FROM Queja q WHERE q.telefonocomercio = :telefonocomercio"),
    @NamedQuery(name = "Queja.findByFechacreacion", query = "SELECT q FROM Queja q WHERE q.fechacreacion = :fechacreacion")})
public class Queja implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idqueja")
    private Integer idqueja;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "nombrecomercio")
    private String nombrecomercio;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "direccioncomercio")
    private String direccioncomercio;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "telefonocomercio")
    private String telefonocomercio;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechacreacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechacreacion;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idqueja", fetch = FetchType.LAZY)
    private List<Encargado> encargadoList;
    
    @JoinColumn(name = "idestadoqueja", referencedColumnName = "idestadoqueja")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Estadoqueja idestadoqueja;
    
    @JoinColumn(name = "idgenero", referencedColumnName = "idgenero")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Genero idgenero;
    
    @JoinColumn(name = "idmunicipio", referencedColumnName = "idmunicipio")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Municipio idmunicipio;
    
    @JoinColumn(name = "idtipoconsumidor", referencedColumnName = "idtipoconsumidor")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tipoconsumidor idtipoconsumidor;

    public Queja() {
    }

    public Queja(Integer idqueja) {
        this.idqueja = idqueja;
    }

    public Queja(Integer idqueja, String nombrecomercio, String direccioncomercio, String telefonocomercio, Date fechacreacion) {
        this.idqueja = idqueja;
        this.nombrecomercio = nombrecomercio;
        this.direccioncomercio = direccioncomercio;
        this.telefonocomercio = telefonocomercio;
        this.fechacreacion = fechacreacion;
    }

    public Integer getIdqueja() {
        return idqueja;
    }

    public void setIdqueja(Integer idqueja) {
        this.idqueja = idqueja;
    }

    public String getNombrecomercio() {
        return nombrecomercio;
    }

    public void setNombrecomercio(String nombrecomercio) {
        this.nombrecomercio = nombrecomercio;
    }

    public String getDireccioncomercio() {
        return direccioncomercio;
    }

    public void setDireccioncomercio(String direccioncomercio) {
        this.direccioncomercio = direccioncomercio;
    }

    public String getTelefonocomercio() {
        return telefonocomercio;
    }

    public void setTelefonocomercio(String telefonocomercio) {
        this.telefonocomercio = telefonocomercio;
    }

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    @XmlTransient
    public List<Encargado> getEncargadoList() {
        return encargadoList;
    }

    public void setEncargadoList(List<Encargado> encargadoList) {
        this.encargadoList = encargadoList;
    }

    public Estadoqueja getIdestadoqueja() {
        return idestadoqueja;
    }

    public void setIdestadoqueja(Estadoqueja idestadoqueja) {
        this.idestadoqueja = idestadoqueja;
    }

    public Genero getIdgenero() {
        return idgenero;
    }

    public void setIdgenero(Genero idgenero) {
        this.idgenero = idgenero;
    }

    public Municipio getIdmunicipio() {
        return idmunicipio;
    }

    public void setIdmunicipio(Municipio idmunicipio) {
        this.idmunicipio = idmunicipio;
    }

    public Tipoconsumidor getIdtipoconsumidor() {
        return idtipoconsumidor;
    }

    public void setIdtipoconsumidor(Tipoconsumidor idtipoconsumidor) {
        this.idtipoconsumidor = idtipoconsumidor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idqueja != null ? idqueja.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Queja)) {
            return false;
        }
        Queja other = (Queja) object;
        if ((this.idqueja == null && other.idqueja != null) || (this.idqueja != null && !this.idqueja.equals(other.idqueja))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diaco.api.entity.Queja[ idqueja=" + idqueja + " ]";
    }
    
}
