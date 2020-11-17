package com.diaco.api.entity;

import com.diaco.api.enums.Estado;
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
@Table(name = "qa_queja")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaQueja.findAll", query = "SELECT q FROM QaQueja q"),
    @NamedQuery(name = "QaQueja.findByIdqueja", query = "SELECT q FROM QaQueja q WHERE q.idqueja = :idqueja"),
    @NamedQuery(name = "QaQueja.findByNombrecomercio", query = "SELECT q FROM QaQueja q WHERE q.nombrecomercio = :nombrecomercio"),
    @NamedQuery(name = "QaQueja.findByDireccioncomercio", query = "SELECT q FROM QaQueja q WHERE q.direccioncomercio = :direccioncomercio"),
    @NamedQuery(name = "QaQueja.findByTelefonocomercio", query = "SELECT q FROM QaQueja q WHERE q.telefonocomercio = :telefonocomercio"),
    @NamedQuery(name = "QaQueja.findByFechacreacion", query = "SELECT q FROM QaQueja q WHERE q.fechacreacion = :fechacreacion")})
public class QaQueja implements Serializable {

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

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5000)
    @Column(name = "descripcion")
    private String descripcion;

    @JoinColumn(name = "idestadoqueja", referencedColumnName = "idestadoqueja")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private QaEstadoQueja idestadoqueja;

    @JoinColumn(name = "idgenero", referencedColumnName = "idgenero")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private QaGenero idgenero;

    @JoinColumn(name = "idmunicipio", referencedColumnName = "idmunicipio")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private QaMunicipio idmunicipio;

    @JoinColumn(name = "idtipoconsumidor", referencedColumnName = "idtipoconsumidor")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private QaTipoConsumidor idtipoconsumidor;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idqueja", fetch = FetchType.LAZY)
    private List<QaEncargado> qaEncargadoList;

    public QaQueja() {
    }

    public QaQueja(Integer idqueja) {
        this.idqueja = idqueja;
    }

    public QaQueja(Integer idqueja, String nombrecomercio, String direccioncomercio, String telefonocomercio, Date fechacreacion) {
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

    public QaEstadoQueja getIdestadoqueja() {
        return idestadoqueja;
    }

    public void setIdestadoqueja(QaEstadoQueja idestadoqueja) {
        this.idestadoqueja = idestadoqueja;
    }

    public QaGenero getIdgenero() {
        return idgenero;
    }

    public void setIdgenero(QaGenero idgenero) {
        this.idgenero = idgenero;
    }

    public QaMunicipio getIdmunicipio() {
        return idmunicipio;
    }

    public void setIdmunicipio(QaMunicipio idmunicipio) {
        this.idmunicipio = idmunicipio;
    }

    public QaTipoConsumidor getIdtipoconsumidor() {
        return idtipoconsumidor;
    }

    public void setIdtipoconsumidor(QaTipoConsumidor idtipoconsumidor) {
        this.idtipoconsumidor = idtipoconsumidor;
    }

    @XmlTransient
    public List<QaEncargado> getQaEncargadoList() {
        return qaEncargadoList;
    }

    public void setQaEncargadoList(List<QaEncargado> qaEncargadoList) {
        this.qaEncargadoList = qaEncargadoList;
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
        if (!(object instanceof QaQueja)) {
            return false;
        }
        QaQueja other = (QaQueja) object;
        if ((this.idqueja == null && other.idqueja != null) || (this.idqueja != null && !this.idqueja.equals(other.idqueja))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diaco.api.entity.QaQueja[ idqueja=" + idqueja + " ]";
    }

    public String getStyleClass() {
        if (idestadoqueja != null) {
            if (Estado.RECHAZADA.getValue() == idestadoqueja.getIdestadoqueja()) {
                return "rowColorRojo";
            } else if (Estado.REGISTRADA.getValue() == idestadoqueja.getIdestadoqueja()) {
                return "rowColorBlanco";
            } else if (Estado.INVESTIGACION.getValue() == idestadoqueja.getIdestadoqueja()) {
                return "rowColorCeleste";
            } else if (Estado.FINALIZADA.getValue() == idestadoqueja.getIdestadoqueja()) {
                return "rowColorVerdeClaro";
            }
        }
        return "";
    }

}
