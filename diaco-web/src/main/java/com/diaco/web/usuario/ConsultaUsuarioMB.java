package com.diaco.web.usuario;

import com.diaco.api.ejb.UsuarioBeanLocal;
import com.diaco.api.entity.Usuario;
import com.diaco.web.utils.JsfUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;

/**
 *
 * @author elfo_
 */
@ManagedBean(name = "consultaUsuarioMB")
@ViewScoped
public class ConsultaUsuarioMB implements Serializable {

    private static final Logger log = Logger.getLogger(RegistroUsuarioMB.class);

    @EJB
    private UsuarioBeanLocal usuarioBean;

    private List<Usuario> listUsuario;
    private String password;
    private Integer idUsuario;

    @PostConstruct
    void cargarDatos() {
        listUsuario = usuarioBean.ListaUsuarios();
    }

    public void dialogReinicioPassword(Integer idUsuario) {
        idUsuario = this.idUsuario;
        RequestContext.getCurrentInstance().execute("PF('dlgReinicio').show()");
    }

    public void reinicioPassword() {
        Usuario response = usuarioBean.reinicioPassword(idUsuario, password);
        if (response != null){
            JsfUtil.addSuccessMessage("Reinicio de contraseña exitoso");
        }
    }

    public void cerraDialog() {
        RequestContext.getCurrentInstance().execute("PF('dlgReinicio').hide()");
    }

    /*Metodos getters y setters*/
    public List<Usuario> getListUsuario() {
        return listUsuario;
    }

    public void setListUsuario(List<Usuario> listUsuario) {
        this.listUsuario = listUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

}
