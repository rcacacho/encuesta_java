package com.diaco.bussines.ejb.imp;

import com.diaco.api.ejb.PerfilBeanLocal;
import com.diaco.api.entity.QaPerfil;
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
public class PerfilBean implements PerfilBeanLocal {

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
    public QaPerfil savePerfil(QaPerfil perfil) {
        try {
            perfil.setActivo(true);
            perfil.setFechacreacion(new Date());
            em.persist(perfil);
            em.flush();
            return (perfil);
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
    public QaPerfil findPerfil(Integer idperfil) {
        List<QaPerfil> lst = em.createQuery("SELECT per FROM QaPerfil per WHERE per.idperfil =:idperfil and per.activo = true", QaPerfil.class)
                .setParameter("idperfil", idperfil)
                .getResultList();

        if (lst == null || lst.isEmpty()) {
            return null;
        }

        return lst.get(0);
    }

    @Override
    public List<QaPerfil> ListPerfil() {
        List<QaPerfil> lst = em.createQuery("SELECT per FROM QaPerfil per WHERE per.activo = true ", QaPerfil.class)
                .getResultList();

        if (lst == null || lst.isEmpty()) {
            return null;
        }

        return lst;
    }

    @Override
    public QaPerfil eliminarPerfil(Integer idperfil) {
        if (idperfil == null) {
            context.setRollbackOnly();
            return null;
        }

        try {
            QaPerfil toUpdate = em.find(QaPerfil.class, idperfil);

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

    @Override
    public QaPerfil actualizarPerfil(QaPerfil perfil) {
        if (perfil == null) {
            context.setRollbackOnly();
            return null;
        }

        try {
            QaPerfil toUpdate = em.find(QaPerfil.class, perfil.getIdperfil());

            toUpdate.setNombre(perfil.getNombre());
            toUpdate.setDescripcion(perfil.getDescripcion());
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
    public QaPerfil findPerfilExistente(String nombre) {
        List<QaPerfil> lst = em.createQuery("SELECT per FROM QaPerfil per WHERE per.nombre =:nombre and per.activo = true", QaPerfil.class)
                .setParameter("nombre", nombre)
                .getResultList();

        if (lst == null || lst.isEmpty()) {
            return null;
        }

        return lst.get(0);
    }

}
