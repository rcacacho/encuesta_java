package com.diaco.web.login;

import com.diaco.api.ejb.LoginBeanLocal;
import com.diaco.api.entity.Usuario;
import com.diaco.web.utils.JsfUtil;
import com.diaco.web.utils.UtilMB;
import java.io.IOException;
import java.io.Serializable;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import sun.misc.BASE64Encoder;

/**
 *
 * @author rcacacho
 */
@ManagedBean(name = "loginMB")
@SessionScoped
public class LoginMB implements Serializable {

    private static final Logger log = Logger.getLogger(LoginMB.class);

    @EJB
    private LoginBeanLocal loginBeanLocal;

    public static String usuario;
    private String password;

    public LoginMB() {
    }

    public String loginProject() {
        Usuario usu = new Usuario();
        usu = loginBeanLocal.verificarUsuario(usuario, password);
        if (usu != null) {
            // get Http Session and store username
            HttpSession session = UtilMB.getSession();
            session.setAttribute("usuario", usuario);

            return "/menu/menu.xhtml";
        } else {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuario o Contraseña invalida", "Intente de nuevo!"));
            return "login.xhtml";
        }
    }

    public void logout() throws IOException {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.invalidateSession();
        ec.redirect(ec.getRequestContextPath() + "/login.xhtml");
    }

    public void regresar() {
        JsfUtil.redirectTo("index.xhtml");
    }

    public void md5() {
        try {
            String plainData = "hola", cipherText, decryptedText;
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(128);
            SecretKey secretKey = keyGen.generateKey();
            Cipher aesCipher = Cipher.getInstance("AES");
            aesCipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] byteDataToEncrypt = plainData.getBytes();
            byte[] byteCipherText = aesCipher.doFinal(byteDataToEncrypt);
            cipherText = new BASE64Encoder().encode(byteCipherText);
            aesCipher.init(Cipher.DECRYPT_MODE, secretKey, aesCipher.getParameters());
            byte[] byteDecryptedText = aesCipher.doFinal(byteCipherText);
            decryptedText = new String(byteDecryptedText);
            System.out.println("\n Plain Data : " + plainData + " \n Cipher Data : " + cipherText + " \n Decrypted Data : " + decryptedText);
        } catch (Exception e) {

        }
    }

    /*Metodos Getters y setters*/
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
