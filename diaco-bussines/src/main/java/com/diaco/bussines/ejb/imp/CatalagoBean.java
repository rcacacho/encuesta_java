package com.diaco.bussines.ejb.imp;

import com.diaco.api.ejb.CatalogoBeanLocal;
import com.diaco.api.entity.Departamento;
import com.diaco.api.entity.Estadoqueja;
import com.diaco.api.entity.Genero;
import com.diaco.api.entity.Municipio;
import com.diaco.api.entity.Region;
import com.diaco.api.entity.Tipoconsumidor;
import java.util.List;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.log4j.Logger;

/**
 *
 * @author rcacacho
 */
@Singleton
public class CatalagoBean implements CatalogoBeanLocal {

    private static final Logger log = Logger.getLogger(CatalagoBean.class);

    @PersistenceContext(unitName = "DiacoPU")
    EntityManager em;

    @Override
    public List<Departamento> listDepartamentos() {
        List<Departamento> lst = em.createQuery("SELECT dep FROM Departamento dep WHERE dep.activo  = true", Departamento.class)
                .getResultList();

        if (lst == null || lst.isEmpty()) {
            return null;
        }

        return lst;
    }

    @Override
    public List<Municipio> listMunicipioByIdDepartamento(Integer iddepartamento) {
        if (iddepartamento == null) {
            return null;
        }

        List<Municipio> lst = em.createQuery("SELECT muni FROM Municipio muni WHERE muni.iddepartamento.iddepartamento =:iddepartamento", Municipio.class)
                .setParameter("iddepartamento", iddepartamento)
                .getResultList();

        if (lst == null || lst.isEmpty()) {
            return null;
        }

        return lst;
    }

    @Override
    public List<Tipoconsumidor> listTipoConsumidor() {
        List<Tipoconsumidor> lst = em.createQuery("SELECT tipo FROM Tipoconsumidor tipo WHERE tipo.activo  = true", Tipoconsumidor.class)
                .getResultList();

        if (lst == null || lst.isEmpty()) {
            return null;
        }

        return lst;
    }

    @Override
    public List<Genero> listGenero() {
        List<Genero> lst = em.createQuery("SELECT gen FROM Genero gen WHERE gen.activo = true", Genero.class)
                .getResultList();

        if (lst == null || lst.isEmpty()) {
            return null;
        }

        return lst;
    }

    @Override
    public List<Region> listRegion() {
        List<Region> lst = em.createQuery("SELECT reg FROM Region reg WHERE reg.activo = true", Region.class)
                .getResultList();

        if (lst == null || lst.isEmpty()) {
            return null;
        }

        return lst;
    }

    @Override
    public List<Departamento> listDepartamentoByIdRegion(Integer idregion) {
        if (idregion == null) {
            return null;
        }

        List<Departamento> lst = em.createQuery("SELECT dep FROM Departamento dep WHERE dep.idregion.idregion =:idregion", Departamento.class)
                .setParameter("idregion", idregion)
                .getResultList();

        if (lst == null || lst.isEmpty()) {
            return null;
        }

        return lst;
    }

    @Override
    public Estadoqueja findEstadoQuejaById(Integer idestadoqueja) {
        if (idestadoqueja == null) {
            return null;
        }

        List<Estadoqueja> lst = em.createQuery("SELECT est FROM Estadoqueja est WHERE est.idestadoqueja =:idestadoqueja", Estadoqueja.class)
                .setParameter("idestadoqueja", idestadoqueja)
                .getResultList();

        if (lst == null || lst.isEmpty()) {
            return null;
        }

        return lst.get(0);
    }

}
