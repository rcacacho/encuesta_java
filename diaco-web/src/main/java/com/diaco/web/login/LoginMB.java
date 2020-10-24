package com.diaco.web.login;

import com.diaco.api.ejb.LoginBeanLocal;
import com.diaco.api.entity.Usuario;
import com.diaco.web.utils.UtilMB;
import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

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
