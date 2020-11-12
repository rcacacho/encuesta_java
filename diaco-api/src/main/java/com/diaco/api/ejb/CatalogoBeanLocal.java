package com.diaco.api.ejb;

import com.diaco.api.entity.QaDepartamento;
import com.diaco.api.entity.QaEstadoQueja;
import com.diaco.api.entity.QaGenero;
import com.diaco.api.entity.QaMunicipio;
import com.diaco.api.entity.QaPerfil;
import com.diaco.api.entity.QaRegion;
import com.diaco.api.entity.QaTipoConsumidor;
import com.diaco.api.entity.QaUsuario;
import java.util.List;

/**
 *
 * @author rcacacho
 */
public interface CatalogoBeanLocal {

    List<QaDepartamento> listDepartamentos();

    List<QaMunicipio> listMunicipioByIdDepartamento(Integer iddepartamento);

    List<QaTipoConsumidor> listTipoConsumidor();

    List<QaGenero> listGenero();

    List<QaRegion> listRegion();

    QaEstadoQueja findEstadoQuejaById(Integer idestadoqueja);

    List<QaDepartamento> listDepartamentoByIdRegion(Integer idregion);

    List<QaPerfil> listPerfiles();

    List<QaUsuario> listUsuario();
}
