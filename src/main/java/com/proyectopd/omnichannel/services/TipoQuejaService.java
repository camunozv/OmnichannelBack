package com.proyectopd.omnichannel.services;

import com.proyectopd.omnichannel.models.TipoQueja;

import java.util.List;

public interface TipoQuejaService {

    // Post
    boolean createTipoQueja(TipoQueja tipoQueja);

    // Get
    TipoQueja getTipoQuejaById(String nombreTipoQueja);

    // Get All
    List<TipoQueja> getAllTipoQuejas();

    // Delete
    boolean deleteTipoQueja(String nombreTipoQueja);
}
