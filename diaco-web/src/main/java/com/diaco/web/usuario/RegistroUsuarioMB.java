package com.diaco.web.usuario;

import com.diaco.api.ejb.CatalogoBeanLocal;
import com.diaco.api.ejb.UsuarioBeanLocal;
import com.diaco.api.entity.Perfil;
import com.diaco.api.entity.Usuario;
import com.diaco.web.utils.JsfUtil;
import com.diaco.web.utils.UtilMB;
import java.io.IOException;
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

/**
 *
 * @author elfo_
 */
@ManagedBean(name = "registroUsuarioMB")
@ViewScoped
public class RegistroUsuarioMB implements Serializable {

    private static final Logger log = Logger.getLogger(RegistroUsuarioMB.class);

    @EJB
    private UsuarioBeanLocal usuarioBean;
    @EJB
    private CatalogoBeanLocal catalogoBean;

    private Usuario usuario;
    private Perfil selectedPerfil;
    private List<Perfil> listPerfil;
    private String password;

    public RegistroUsuarioMB() {
        usuario = new Usuario();
    }

    @PostConstruct
    void cargarDatos() {
        listPerfil = catalogoBean.listPerfiles();
    }

    public void crearUsuario() throws IOException {
        usuario.setIdperfil(selectedPerfil);
        String contra = md5(password);
        usuario.setPassword(contra);
        usuario.setUsuariocreacion(UtilMB.getUserName());
        Usuario response = usuarioBean.saveUsuario(usuario);
    }

    public String md5(String input) {
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

    public void regresarMenu() {
        JsfUtil.redirectTo("/menu/menu.xhtml");
    }

    /*Metodos getters y setters*/
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Perfil getSelectedPerfil() {
        return selectedPerfil;
    }

    public void setSelectedPerfil(Perfil selectedPerfil) {
        this.selectedPerfil = selectedPerfil;
    }

    public List<Perfil> getListPerfil() {
        return listPerfil;
    }

    public void setListPerfil(List<Perfil> listPerfil) {
        this.listPerfil = listPerfil;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
