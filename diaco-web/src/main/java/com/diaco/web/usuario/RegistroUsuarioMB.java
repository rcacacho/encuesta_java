package com.diaco.web.usuario;

import com.diaco.api.ejb.CatalogoBeanLocal;
import com.diaco.api.ejb.UsuarioBeanLocal;
import com.diaco.api.entity.Perfil;
import com.diaco.api.entity.Usuario;
import com.diaco.web.utils.JsfUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.apache.log4j.Logger;
import sun.misc.BASE64Encoder;

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

    public void crearUsuario() {
        usuario.setIdperfil(selectedPerfil);
        String contra = md5(password);
        usuario.setPassword(contra);
        Usuario response = usuarioBean.saveUsuario(usuario);
    }

    public String md5(String contra) {
        try {
            String cipherText, decryptedText;
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);
            SecretKey secretKey = keyGen.generateKey();
            Cipher aesCipher = Cipher.getInstance("AES");
            aesCipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] byteDataToEncrypt = password.getBytes();
            byte[] byteCipherText = aesCipher.doFinal(byteDataToEncrypt);
            cipherText = new BASE64Encoder().encode(byteCipherText);
            aesCipher.init(Cipher.DECRYPT_MODE, secretKey, aesCipher.getParameters());
            byte[] byteDecryptedText = aesCipher.doFinal(byteCipherText);
            decryptedText = new String(byteDecryptedText);
            return cipherText;
            //System.out.println("\n Plain Data : " + plainData + " \n Cipher Data : " + cipherText + " \n Decrypted Data : " + decryptedText);
        } catch (Exception e) {
        }
        return null;
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
