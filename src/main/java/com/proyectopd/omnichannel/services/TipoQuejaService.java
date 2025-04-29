package com.proyectopd.omnichannel.services;

import com.proyectopd.omnichannel.models.TipoQueja;

public interface TipoQuejaService {

    // Post
    boolean createTipoQueja(TipoQueja tipoQueja);

    // Get
    TipoQueja getTipoQuejaById(String nombreTipoQueja);
}
