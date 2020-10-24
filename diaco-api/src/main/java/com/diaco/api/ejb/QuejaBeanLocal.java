package com.diaco.api.ejb;

import com.diaco.api.entity.Queja;
import java.util.List;

/**
 *
 * @author rcacacho
 */
public interface QuejaBeanLocal {

    List<Queja> ListaQuejas();

    Queja saveQueja(Queja queja);

    Queja findQueja(Integer idQueja);

    List<Queja> listQuejaByIdQueja(Integer idqueja);

}
