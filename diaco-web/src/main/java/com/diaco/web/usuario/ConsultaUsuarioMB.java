package com.diaco.web.usuario;

import com.diaco.api.ejb.UsuarioBeanLocal;
import com.diaco.api.entity.QaUsuario;
import com.diaco.web.utils.JsfUtil;
import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

    private List<QaUsuario> listUsuario;
    private String password;
    private Integer idUsuario;

    @PostConstruct
    void cargarDatos() {
        listUsuario = usuarioBean.ListaUsuarios();
    }

    public void dialogReinicioPassword(Integer id) {
        idUsuario = id;
        RequestContext.getCurrentInstance().execute("PF('dlgReinicio').show()");
    }

    public void reinicioPassword() {
        password = md5(password);
        QaUsuario response = usuarioBean.reinicioPassword(idUsuario, password);
        if (response != null) {
            JsfUtil.addSuccessMessage("Reinicio de contraseña exitoso");
        }
    }

    public void cerraDialog() {
        RequestContext.getCurrentInstance().execute("PF('dlgReinicio').hide()");
    }

    public static String md5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    
       public void eliminarUsuario(Integer idusuario) {
        QaUsuario response = usuarioBean.eliminarUsuario(idusuario);
        if (response != null) {
            JsfUtil.addSuccessMessage("Se elimino el usuario exitosamente");
            return;
        }

        JsfUtil.addErrorMessage("Sucedio un error al elimnar");
    }

    /*Metodos getters y setters*/
    public List<QaUsuario> getListUsuario() {
        return listUsuario;
    }

    public void setListUsuario(List<QaUsuario> listUsuario) {
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
