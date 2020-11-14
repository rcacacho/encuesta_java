package com.diaco.bussines.ejb.imp;

import com.diaco.api.ejb.UsuarioBeanLocal;
import com.diaco.api.entity.QaPerfil;
import com.diaco.api.entity.QaUsuario;
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
 * @author elfo_
 */
@Singleton
public class UsuarioBean implements UsuarioBeanLocal {

    private static final Logger log = Logger.getLogger(CatalagoBean.class);

    @PersistenceContext(unitName = "DiacoPU")
    EntityManager em;

    @Resource
    private EJBContext context;

    private void processException(Exception ex) {
        log.error(ex.getMessage(), ex);
    }

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

    @Override
    public QaUsuario saveUsuario(QaUsuario usuario) {
        try {
            usuario.setFechacreacion(new Date());
            usuario.setActivo(true);
            em.persist(usuario);
            em.flush();
            return (usuario);
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
    }

    @Override
    public QaUsuario findUsuario(Integer idusuario) {
        List<QaUsuario> lst = em.createQuery("SELECT us FROM QaUsuario us WHERE us.idusuario =:idsuario and us.activo = true", QaUsuario.class)
                .setParameter("idusuario", idusuario)
                .getResultList();

        if (lst == null || lst.isEmpty()) {
            return null;
        }

        return lst.get(0);
    }

    @Override
    public List<QaUsuario> ListaUsuarios() {
        List<QaUsuario> lst = em.createQuery("SELECT us FROM QaUsuario us WHERE us.activo = true ", QaUsuario.class)
                .getResultList();

        if (lst == null || lst.isEmpty()) {
            return null;
        }

        return lst;
    }

    @Override
    public QaUsuario reinicioPassword(Integer idusuario, String password) {
        if (idusuario == null) {
            context.setRollbackOnly();
            return null;
        }

        try {
            QaUsuario toUpdate = em.find(QaUsuario.class, idusuario);

            toUpdate.setPassword(password);
            em.merge(toUpdate);

            return toUpdate;
        } catch (ConstraintViolationException ex) {
            String validationError = getConstraintViolationExceptionAsString(ex);
            log.error(validationError);
            context.setRollbackOnly();
            return null;
        } catch (Exception ex) {
            processException(ex);
            return null;
        }
    }

    @Override
    public QaPerfil findPerfilIdUsuario(String usuario) {
        List<QaPerfil> lst = em.createQuery("SELECT us.idperfil FROM QaUsuario us WHERE us.usuario =:usuario and us.activo = true", QaPerfil.class)
                .setParameter("usuario", usuario)
                .getResultList();

        if (lst == null || lst.isEmpty()) {
            return null;
        }

        return lst.get(0);
    }

    @Override
    public QaUsuario eliminarUsuario(Integer idusuario) {
        if (idusuario == null) {
            context.setRollbackOnly();
            return null;
        }

        try {
            QaUsuario toUpdate = em.find(QaUsuario.class, idusuario);

            toUpdate.setActivo(false);
            em.merge(toUpdate);

            return toUpdate;
        } catch (ConstraintViolationException ex) {
            String validationError = getConstraintViolationExceptionAsString(ex);
            log.error(validationError);
            context.setRollbackOnly();
            return null;
        } catch (Exception ex) {
            processException(ex);
            return null;
        }
    }

}
