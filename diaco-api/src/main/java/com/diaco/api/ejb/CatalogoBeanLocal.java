package com.diaco.api.ejb;

import com.diaco.api.entity.Departamento;
import com.diaco.api.entity.Estadoqueja;
import com.diaco.api.entity.Genero;
import com.diaco.api.entity.Municipio;
import com.diaco.api.entity.Region;
import com.diaco.api.entity.Tipoconsumidor;
import java.util.List;

/**
 *
 * @author rcacacho
 */
public interface CatalogoBeanLocal {

    List<Departamento> listDepartamentos();

    List<Municipio> listMunicipioByIdDepartamento(Integer iddepartamento);

    List<Tipoconsumidor> listTipoConsumidor();

    List<Genero> listGenero();

    List<Region> listRegion();

    Estadoqueja findEstadoQuejaById(Integer idestadoqueja);

    List<Departamento> listDepartamentoByIdRegion(Integer idregion);
}
