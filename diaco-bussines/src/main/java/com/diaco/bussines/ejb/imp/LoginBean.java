package com.diaco.bussines.ejb.imp;

import com.diaco.api.ejb.LoginBeanLocal;
import com.diaco.api.entity.Usuario;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.apache.log4j.Logger;

/**
 *
 * @author rcacacho
 */
@Singleton
public class LoginBean implements LoginBeanLocal {

    private static final Logger log = Logger.getLogger(LoginBean.class);

    @PersistenceContext(unitName = "DiacoPU")
    EntityManager em;

    @Resource
    private EJBContext context;

    private String getConstraintViolationExceptionAsString(ConstraintViolationException ex) {
        StringBuilder sb = new StringBuilder();
        sb.append("Error de validación:\n");
        for (ConstraintViolation c : ex.getConstraintViolations()) {
            sb.append(String.format("[bean: %s; field: %s; message: %s; value: %s]",
                    c.getRootBeanClass().getName(),
                    c.getPropertyPath().toString(),
                    c.getMessage(), c.getInvalidValue()));
        }
        return sb.toString();
    }

    private void processException(Exception ex) {
        log.error(ex.getMessage(), ex);
    }

    @Override
    public Usuario verificarUsuario(String usuario, String password) {
        List<Usuario> lst = em.createQuery("SELECT usuario FROM Usuario usuario WHERE usuario.usuario =:usuario and usuario.password =:password ", Usuario.class)
                .setParameter("usuario", usuario)
                .setParameter("password", password)
                .getResultList();

        if (lst == null || lst.isEmpty()) {
            return null;
        }

        return lst.get(0);
    }

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        try {

            usuario.setFechacreacion(new Date());
            usuario.setActivo(true);

            em.persist(usuario);
            em.flush();

        } catch (ConstraintViolationException ex) {
            String validationError = getConstraintViolationExceptionAsString(ex);
            log.error(validationError);
            context.setRollbackOnly();
            return null;
        } catch (Exception ex) {
            processException(ex);
            context.setRollbackOnly();
            return null;
        }

        return usuario;
    }

    @Override
    public String findUsuario(String usuario) {
        List<Usuario> lst = em.createQuery("SELECT usu FROM Usuario usu WHERE usu.usuario =:usuario ", Usuario.class)
                .setParameter("usuario", usuario)
                .getResultList();

        if (lst == null || lst.isEmpty()) {
            return null;
        }
        // return new Response(lst.get(0), ResponseStatus.OK_QUERY);
        return lst.get(0).getUsuario();
    }

}
