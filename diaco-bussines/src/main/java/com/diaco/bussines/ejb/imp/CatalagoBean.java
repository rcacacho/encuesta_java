package com.diaco.bussines.ejb.imp;

import com.diaco.api.ejb.CatalogoBeanLocal;
import com.diaco.api.entity.QaDepartamento;
import com.diaco.api.entity.QaEstadoQueja;
import com.diaco.api.entity.QaGenero;
import com.diaco.api.entity.QaMunicipio;
import com.diaco.api.entity.QaPerfil;
import com.diaco.api.entity.QaRegion;
import com.diaco.api.entity.QaTipoConsumidor;
import com.diaco.api.entity.QaUsuario;
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
    public List<QaDepartamento> listDepartamentos() {
        List<QaDepartamento> lst = em.createQuery("SELECT dep FROM QaDepartamento dep WHERE dep.activo  = true", QaDepartamento.class)
                .getResultList();

        if (lst == null || lst.isEmpty()) {
            return null;
        }

        return lst;
    }

    @Override
    public List<QaMunicipio> listMunicipioByIdDepartamento(Integer iddepartamento) {
        if (iddepartamento == null) {
            return null;
        }

        List<QaMunicipio> lst = em.createQuery("SELECT muni FROM QaMunicipio muni WHERE muni.iddepartamento.iddepartamento =:iddepartamento", QaMunicipio.class)
                .setParameter("iddepartamento", iddepartamento)
                .getResultList();

        if (lst == null || lst.isEmpty()) {
            return null;
        }

        return lst;
    }

    @Override
    public List<QaTipoConsumidor> listTipoConsumidor() {
        List<QaTipoConsumidor> lst = em.createQuery("SELECT tipo FROM QaTipoConsumidor tipo WHERE tipo.activo  = true", QaTipoConsumidor.class)
                .getResultList();

        if (lst == null || lst.isEmpty()) {
            return null;
        }

        return lst;
    }

    @Override
    public List<QaGenero> listGenero() {
        List<QaGenero> lst = em.createQuery("SELECT gen FROM QaGenero gen WHERE gen.activo = true", QaGenero.class)
                .getResultList();

        if (lst == null || lst.isEmpty()) {
            return null;
        }

        return lst;
    }

    @Override
    public List<QaRegion> listRegion() {
        List<QaRegion> lst = em.createQuery("SELECT reg FROM QaRegion reg WHERE reg.activo = true", QaRegion.class)
                .getResultList();

        if (lst == null || lst.isEmpty()) {
            return null;
        }

        return lst;
    }

    @Override
    public List<QaDepartamento> listDepartamentoByIdRegion(Integer idregion) {
        if (idregion == null) {
            return null;
        }

        List<QaDepartamento> lst = em.createQuery("SELECT dep FROM QaDepartamento dep WHERE dep.idregion.idregion =:idregion", QaDepartamento.class)
                .setParameter("idregion", idregion)
                .getResultList();

        if (lst == null || lst.isEmpty()) {
            return null;
        }

        return lst;
    }

    @Override
    public QaEstadoQueja findEstadoQuejaById(Integer idestadoqueja) {
        if (idestadoqueja == null) {
            return null;
        }

        List<QaEstadoQueja> lst = em.createQuery("SELECT est FROM QaEstadoQueja est WHERE est.idestadoqueja =:idestadoqueja", QaEstadoQueja.class)
                .setParameter("idestadoqueja", idestadoqueja)
                .getResultList();

        if (lst == null || lst.isEmpty()) {
            return null;
        }

        return lst.get(0);
    }

    @Override
    public List<QaPerfil> listPerfiles() {
        List<QaPerfil> lst = em.createQuery("SELECT per FROM QaPerfil per WHERE per.activo = true", QaPerfil.class)
                .getResultList();

        if (lst == null || lst.isEmpty()) {
            return null;
        }

        return lst;
    }

    @Override
    public List<QaUsuario> listUsuario() {
        List<QaUsuario> lst = em.createQuery("SELECT usu FROM QaUsuario usu WHERE usu.activo = true", QaUsuario.class)
                .getResultList();

        if (lst == null || lst.isEmpty()) {
            return null;
        }

        return lst;
    }

}
