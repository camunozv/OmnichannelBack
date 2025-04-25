package com.proyectopd.omnichannel.respuesta.Implementation;

import com.proyectopd.omnichannel.respuesta.Respuesta;
import com.proyectopd.omnichannel.respuesta.RespuestaRepository;
import com.proyectopd.omnichannel.respuesta.RespuestaService;

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
