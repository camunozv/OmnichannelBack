package com.proyectopd.omnichannel.mappers;

import com.proyectopd.omnichannel.dtos.createuser.models.EmpresaDTO;
import com.proyectopd.omnichannel.models.Empresa;

public class TipoServicioEmpresaDTOMapper {

    public TipoServicioEmpresaDTOMapper() {
    }

    public static EmpresaDTO mapEmpresaToEmpresaDTO(Empresa empresa) {

        EmpresaDTO empresaDTO = new EmpresaDTO();

        empresaDTO.setId(empresa.getUsuario().getIdUsuario());
        empresaDTO.setTipoServicio(empresa.getTipoServicio().getNombreServicio());
        empresaDTO.setCiudad(empresa.getCiudad());
        empresaDTO.setNombre(empresa.getNombreEmpresa());

        return empresaDTO;
    }
}
