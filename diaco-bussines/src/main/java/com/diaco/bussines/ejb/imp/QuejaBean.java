package com.diaco.bussines.ejb.imp;

import com.diaco.api.ejb.CatalogoBeanLocal;
import com.diaco.api.ejb.QuejaBeanLocal;
import com.diaco.api.entity.QaEncargado;
import com.diaco.api.entity.QaEstadoQueja;
import com.diaco.api.entity.QaQueja;
import com.diaco.api.enums.Estado;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
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
public class QuejaBean implements QuejaBeanLocal {

    private static final Logger log = Logger.getLogger(CatalagoBean.class);

    @PersistenceContext(unitName = "DiacoPU")
    EntityManager em;

    @Resource
    private EJBContext context;

    @EJB
    private CatalogoBeanLocal catalogoBean;

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
    public List<QaQueja> ListaQuejas() {
        List<QaQueja> lst = em.createQuery("SELECT qj FROM QaQueja qj ", QaQueja.class)
                .getResultList();

        if (lst == null || lst.isEmpty()) {
            return null;
        }

        return lst;
    }

    @Override
    public QaQueja saveQueja(QaQueja queja) {
        try {
            QaEstadoQueja estado = catalogoBean.findEstadoQuejaById(Estado.REGISTRADA.getValue());

            queja.setIdestadoqueja(estado);
            queja.setFechacreacion(new Date());
            em.persist(queja);
            em.flush();
            return (queja);
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
    public QaQueja findQueja(Integer idQueja) {
        List<QaQueja> lst = em.createQuery("SELECT qj FROM QaQueja qj WHERE qj.idqueja =:idqueja", QaQueja.class)
                .setParameter("idqueja", idQueja)
                .getResultList();

        if (lst == null || lst.isEmpty()) {
            return null;
        }

        return lst.get(0);
    }

    @Override
    public List<QaQueja> listQuejaByIdQueja(Integer idqueja) {
        List<QaQueja> lst = em.createQuery("SELECT qj FROM QaQueja qj WHERE qj.idqueja =:idqueja", QaQueja.class)
                .setParameter("idqueja", idqueja)
                .getResultList();

        if (lst == null || lst.isEmpty()) {
            return null;
        }

        return lst;
    }

    @Override
    public List<QaQueja> listAllQueja() {
        List<QaQueja> lst = em.createQuery("SELECT qj FROM QaQueja qj", QaQueja.class)
                .getResultList();

        if (lst == null || lst.isEmpty()) {
            return null;
        }

        return lst;
    }

    @Override
    public List<QaQueja> listQuejaByFechaCreacion(Date fechainicio, Date fechafin) {
        List<QaQueja> lst = em.createQuery("SELECT qj FROM QaQueja qj WHERE qj.fechacreacion >=:fechainicio and qj.fechacreacion <=:fechafin", QaQueja.class)
                .setParameter("fechainicio", fechainicio)
                .setParameter("fechafin", fechafin)
                .getResultList();

        if (lst == null || lst.isEmpty()) {
            return null;
        }

        return lst;
    }

    @Override
    public QaEncargado asignacionQueja(QaEncargado asignacion) {
        try {
            asignacion.setFechacreacion(new Date());
            asignacion.setActivo(true);
            em.persist(asignacion);
            em.flush();
            return (asignacion);
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
    public List<QaEncargado> listEncagardoByIdQueja(Integer idqueja) {
        List<QaEncargado> lst = em.createQuery("SELECT qj FROM Encargado qj WHERE QaEncargado =:idqueja and qj.activo = true ", QaEncargado.class)
                .setParameter("idqueja", idqueja)
                .getResultList();

        if (lst == null || lst.isEmpty()) {
            return null;
        }

        return lst;
    }

    @Override
    public QaQueja rechazoQueja(Integer idQueja) {
        if (idQueja == null) {
            context.setRollbackOnly();
            return null;
        }

        try {
            QaEstadoQueja estado = catalogoBean.findEstadoQuejaById(Estado.RECHAZADA.getValue());
            QaQueja toUpdate = em.find(QaQueja.class, idQueja);

            toUpdate.setIdestadoqueja(estado);
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
    public QaQueja seguimientoQueja(Integer idQueja) {
        if (idQueja == null) {
            context.setRollbackOnly();
            return null;
        }

        try {
            QaEstadoQueja estado = catalogoBean.findEstadoQuejaById(Estado.INVESTIGACION.getValue());
            QaQueja toUpdate = em.find(QaQueja.class, idQueja);

            toUpdate.setIdestadoqueja(estado);
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
    public List<QaEncargado> listEncagardo() {
        List<QaEncargado> lst = em.createQuery("SELECT qj FROM QaEncargado qj WHERE qj.activo = true ", QaEncargado.class)
                .getResultList();

        if (lst == null || lst.isEmpty()) {
            return null;
        }

        return lst;
    }

}
