package com.proyectopd.omnichannel.services.Implementation;

import com.proyectopd.omnichannel.models.Respuesta;
import com.proyectopd.omnichannel.repositories.RespuestaRepository;
import com.proyectopd.omnichannel.services.RespuestaService;
import org.springframework.stereotype.Service;

@Service
public class RespuestaServiceImplementation implements RespuestaService {

    RespuestaRepository respuestaRepository;

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

    @Override
    public boolean deleteRespuestaById(Integer idRespuesta) {
        boolean deleted;
        try {
            respuestaRepository.deleteById(idRespuesta);
            deleted = true;
        } catch (Exception e) {
            deleted = false;
        }

        return deleted;
    }

    @Override
    public Respuesta getRespuestaById(Integer idRespuesta) {
        return respuestaRepository.getRespuestaByIdRespuesta(idRespuesta);
    }


}
