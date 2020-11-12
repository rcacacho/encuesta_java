package com.diaco.api.ejb;

import com.diaco.api.entity.QaEncargado;
import com.diaco.api.entity.QaQueja;
import java.util.Date;
import java.util.List;

/**
 *
 * @author rcacacho
 */
public interface QuejaBeanLocal {

    List<QaQueja> ListaQuejas();

    QaQueja saveQueja(QaQueja queja);

    QaQueja findQueja(Integer idQueja);

    List<QaQueja> listQuejaByIdQueja(Integer idqueja);

    List<QaQueja> listAllQueja();

    List<QaQueja> listQuejaByFechaCreacion(Date fechainicio, Date fechafin);

    QaEncargado asignacionQueja(QaEncargado asignacion);

    List<QaEncargado> listEncagardoByIdQueja(Integer idqueja);

    QaQueja rechazoQueja(Integer idQueja);
    
    QaQueja seguimientoQueja(Integer idQueja);
    
    List<QaEncargado> listEncagardo();

}
