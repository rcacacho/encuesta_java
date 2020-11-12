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
@Table(name = "qa_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaUsuario.findAll", query = "SELECT q FROM QaUsuario q"),
    @NamedQuery(name = "QaUsuario.findByIdusuario", query = "SELECT q FROM QaUsuario q WHERE q.idusuario = :idusuario"),
    @NamedQuery(name = "QaUsuario.findByUsuario", query = "SELECT q FROM QaUsuario q WHERE q.usuario = :usuario"),
    @NamedQuery(name = "QaUsuario.findByEmail", query = "SELECT q FROM QaUsuario q WHERE q.email = :email"),
    @NamedQuery(name = "QaUsuario.findByPassword", query = "SELECT q FROM QaUsuario q WHERE q.password = :password"),
    @NamedQuery(name = "QaUsuario.findByNombres", query = "SELECT q FROM QaUsuario q WHERE q.nombres = :nombres"),
    @NamedQuery(name = "QaUsuario.findByApellidos", query = "SELECT q FROM QaUsuario q WHERE q.apellidos = :apellidos"),
    @NamedQuery(name = "QaUsuario.findByTelefono", query = "SELECT q FROM QaUsuario q WHERE q.telefono = :telefono"),
    @NamedQuery(name = "QaUsuario.findByFechacreacion", query = "SELECT q FROM QaUsuario q WHERE q.fechacreacion = :fechacreacion"),
    @NamedQuery(name = "QaUsuario.findByUsuariocreacion", query = "SELECT q FROM QaUsuario q WHERE q.usuariocreacion = :usuariocreacion"),
    @NamedQuery(name = "QaUsuario.findByFechaeliminacion", query = "SELECT q FROM QaUsuario q WHERE q.fechaeliminacion = :fechaeliminacion"),
    @NamedQuery(name = "QaUsuario.findByUsuarioelminacion", query = "SELECT q FROM QaUsuario q WHERE q.usuarioelminacion = :usuarioelminacion"),
    @NamedQuery(name = "QaUsuario.findByActivo", query = "SELECT q FROM QaUsuario q WHERE q.activo = :activo")})
public class QaUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idusuario")
    private Integer idusuario;
    
    @Size(max = 50)
    @Column(name = "usuario")
    private String usuario;
    
    @Size(max = 30)
    @Column(name = "email")
    private String email;
    
    @Size(max = 500)
    @Column(name = "password")
    private String password;
    
    @Size(max = 20)
    @Column(name = "nombres")
    private String nombres;
    
    @Size(max = 30)
    @Column(name = "apellidos")
    private String apellidos;
    
    @Size(max = 25)
    @Column(name = "telefono")
    private String telefono;
    
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
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "usuarioelminacion")
    private String usuarioelminacion;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    
    @JoinColumn(name = "idperfil", referencedColumnName = "idperfil")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private QaPerfil idperfil;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idusuario", fetch = FetchType.LAZY)
    private List<QaEncargado> qaEncargadoList;

    public QaUsuario() {
    }

    public QaUsuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public QaUsuario(Integer idusuario, String usuariocreacion, String usuarioelminacion, boolean activo) {
        this.idusuario = idusuario;
        this.usuariocreacion = usuariocreacion;
        this.usuarioelminacion = usuarioelminacion;
        this.activo = activo;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    public QaPerfil getIdperfil() {
        return idperfil;
    }

    public void setIdperfil(QaPerfil idperfil) {
        this.idperfil = idperfil;
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
        hash += (idusuario != null ? idusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QaUsuario)) {
            return false;
        }
        QaUsuario other = (QaUsuario) object;
        if ((this.idusuario == null && other.idusuario != null) || (this.idusuario != null && !this.idusuario.equals(other.idusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diaco.api.entity.QaUsuario[ idusuario=" + idusuario + " ]";
    }
    
}
