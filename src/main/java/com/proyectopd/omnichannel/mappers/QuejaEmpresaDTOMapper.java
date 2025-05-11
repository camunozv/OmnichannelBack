package com.proyectopd.omnichannel.mappers;

import com.proyectopd.omnichannel.dtos.createqueja.models.QuejaEmpresaDTO;
import com.proyectopd.omnichannel.models.Queja;

public class QuejaEmpresaDTOMapper {

    public QuejaEmpresaDTOMapper() {
    }

    public static QuejaEmpresaDTO mapQuejaToQuejaEmpresaDTO(Queja queja) {

        QuejaEmpresaDTO quejaEmpresaDTO = new QuejaEmpresaDTO();
        quejaEmpresaDTO.setIdQueja(queja.getIdQueja());
        quejaEmpresaDTO.setArchivo(queja.getArchivo());
        quejaEmpresaDTO.setNombreEmpresa(queja.getEmpresa().getNombreEmpresa());
        quejaEmpresaDTO.setTipoQueja(queja.getTipoQueja().getTipoQueja());
        quejaEmpresaDTO.setEstado(queja.getEstado());
        quejaEmpresaDTO.setTiempoMinimoRespuesta(queja.getTiempoMinimoRespuesta());
        quejaEmpresaDTO.setDescripcion(queja.getDescripcion());

        return quejaEmpresaDTO;
    }

    public static Queja mapQuejaEmpresaDTOToQueja(QuejaEmpresaDTO quejaEmpresaDTO) {

        Queja queja = new Queja();

        queja.setIdQueja(quejaEmpresaDTO.getIdQueja());
        queja.setEstado(quejaEmpresaDTO.getEstado());

        queja.setDescripcion(quejaEmpresaDTO.getDescripcion());
        queja.setArchivo(quejaEmpresaDTO.getArchivo());

        return queja;
    }
}
