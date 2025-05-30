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
        try {
            respuestaQuejaDTO.setTextoRespuesta(queja.getRespuesta().getTextoRespuesta());
        } catch (Exception e) {
            respuestaQuejaDTO.setTextoRespuesta("");
        }
        respuestaQuejaDTO.setArchivo(queja.getArchivo());
        respuestaQuejaDTO.setEstado(queja.getEstado());
        respuestaQuejaDTO.setDescripcion(queja.getDescripcion());
        respuestaQuejaDTO.setTiempoMinimoRespuesta(queja.getTiempoMinimoRespuesta());

        return respuestaQuejaDTO;
    }
}
