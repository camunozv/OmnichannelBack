package com.proyectopd.omnichannel.services;

import com.proyectopd.omnichannel.dtos.createuser.models.EmpresaDTO;
import com.proyectopd.omnichannel.models.TipoServicio;

import java.util.List;

public interface TipoServicioService {

    // Post
    boolean createTipoServicio(TipoServicio newServicio);

    // Get
    List<EmpresaDTO> getAllEmpresasPorTipoServicio(String nombreServicio);

    // Delete
    boolean deleteTipoServicioByNombreTipoServicio(String nombreServicio);
}
