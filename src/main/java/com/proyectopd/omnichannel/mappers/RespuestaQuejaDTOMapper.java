package com.proyectopd.omnichannel.mappers;

import com.proyectopd.omnichannel.dtos.quejaBeauty.RespuestaQuejaDTO;
import com.proyectopd.omnichannel.models.Queja;

import java.time.LocalDate;

public class RespuestaQuejaDTOMapper {

    public RespuestaQuejaDTOMapper() {
    }

    public static RespuestaQuejaDTO mapRespuestaToRespuestaQuejaDTO(Queja queja) {

        RespuestaQuejaDTO respuestaQuejaDTO = new RespuestaQuejaDTO();

        respuestaQuejaDTO.setIdQueja(queja.getIdQueja());
        respuestaQuejaDTO.setTextoRespuesta(queja.getRespuesta().getTextoRespuesta());
        respuestaQuejaDTO.setArchivo(queja.getArchivo());
        respuestaQuejaDTO.setEstado(queja.getEstado());
        respuestaQuejaDTO.setDescripcion(queja.getDescripcion());
        respuestaQuejaDTO.setTiempoMinimoRespuesta(queja.getTiempoMinimoRespuesta());

        return respuestaQuejaDTO;
    }
}
