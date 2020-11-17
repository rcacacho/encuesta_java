package com.diaco.web.usuario;

import com.diaco.api.ejb.CatalogoBeanLocal;
import com.diaco.api.ejb.UsuarioBeanLocal;
import com.diaco.api.entity.QaPerfil;
import com.diaco.api.entity.QaUsuario;
import com.diaco.web.utils.JsfUtil;
import com.diaco.web.utils.SesionUsuarioMB;
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

    private QaUsuario usuario;
    private QaPerfil selectedPerfil;
    private List<QaPerfil> listPerfil;
    private String password;

    public RegistroUsuarioMB() {
        usuario = new QaUsuario();
    }

    @PostConstruct
    void cargarDatos() {
        listPerfil = catalogoBean.listPerfiles();
    }

    public void crearUsuario() throws IOException {
        usuario.setIdperfil(selectedPerfil);
        String contra = md5(password);
        usuario.setPassword(contra);
        usuario.setUsuariocreacion(SesionUsuarioMB.getUserName());
        QaUsuario response = usuarioBean.saveUsuario(usuario);
         JsfUtil.redirectTo("/usuario/lista.xhtml");
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
        JsfUtil.redirectTo("/usuario/lista.xhtml");
    }

    /*Metodos getters y setters*/
    public QaUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(QaUsuario usuario) {
        this.usuario = usuario;
    }

    public QaPerfil getSelectedPerfil() {
        return selectedPerfil;
    }

    public void setSelectedPerfil(QaPerfil selectedPerfil) {
        this.selectedPerfil = selectedPerfil;
    }

    public List<QaPerfil> getListPerfil() {
        return listPerfil;
    }

    public void setListPerfil(List<QaPerfil> listPerfil) {
        this.listPerfil = listPerfil;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
