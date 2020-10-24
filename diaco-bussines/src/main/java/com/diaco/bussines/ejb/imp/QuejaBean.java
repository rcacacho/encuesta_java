package com.diaco.bussines.ejb.imp;

import com.diaco.api.ejb.CatalogoBeanLocal;
import com.diaco.api.ejb.QuejaBeanLocal;
import com.diaco.api.entity.Estadoqueja;
import com.diaco.api.entity.Queja;
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
    public List<Queja> ListaQuejas() {
        List<Queja> lst = em.createQuery("SELECT qj FROM Queja qj ", Queja.class)
                .getResultList();
        
        if (lst == null || lst.isEmpty()) {
            return null;
        }
        
        return lst;
    }
    
    @Override
    public Queja saveQueja(Queja queja) {
        try {
            Estadoqueja estado = catalogoBean.findEstadoQuejaById(Estado.REGISTRADA.getValue());
            
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
    public Queja findQueja(Integer idQueja) {
        List<Queja> lst = em.createQuery("SELECT qj FROM Queja qj WHERE qj.idqueja =:idqueja", Queja.class)
                .setParameter("idQueja", idQueja)
                .getResultList();
        
        if (lst == null || lst.isEmpty()) {
            return null;
        }
        
        return lst.get(0);
    }
    
    @Override
    public List<Queja> listQuejaByIdQueja(Integer idqueja) {
        List<Queja> lst = em.createQuery("SELECT qj FROM Queja qj WHERE qj.idqueja =:idqueja", Queja.class)
                .setParameter("idqueja", idqueja)
                .getResultList();
        
        if (lst == null || lst.isEmpty()) {
            return null;
        }
        
        return lst;
    }
    
}
