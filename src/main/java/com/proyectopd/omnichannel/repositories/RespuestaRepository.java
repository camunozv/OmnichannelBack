package com.proyectopd.omnichannel.repositories;

import com.proyectopd.omnichannel.models.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespuestaRepository extends JpaRepository<Respuesta, Integer> {

    Respuesta getRespuestaByIdRespuesta(Integer idRespuesta);
}
