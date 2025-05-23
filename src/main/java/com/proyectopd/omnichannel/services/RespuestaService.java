package com.proyectopd.omnichannel.services;

import com.proyectopd.omnichannel.models.Respuesta;

public interface RespuestaService {

    // Post
    boolean createRespuesta(Respuesta newRespuesta);

    // Delete
    boolean deleteRespuestaById(Integer idRespuesta);

    // Get
    Respuesta getRespuestaById(Integer idRespuesta);
}
