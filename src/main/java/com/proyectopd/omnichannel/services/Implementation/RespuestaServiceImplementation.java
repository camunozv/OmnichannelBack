package com.proyectopd.omnichannel.services.Implementation;

import com.proyectopd.omnichannel.models.Respuesta;
import com.proyectopd.omnichannel.repositories.RespuestaRepository;
import com.proyectopd.omnichannel.services.RespuestaService;

public class RespuestaServiceImplementation implements RespuestaService {

    RespuestaRepository respuestaRepository;

    public RespuestaServiceImplementation() {
    }

    public RespuestaServiceImplementation(RespuestaRepository respuestaRepository) {
        this.respuestaRepository = respuestaRepository;
    }

    @Override
    public boolean createRespuesta(Respuesta newRespuesta) {

        boolean created;

        try {
            respuestaRepository.save(newRespuesta);
            created = true;
        } catch (Exception e) {
            created = false;
        }

        return created;
    }
}
