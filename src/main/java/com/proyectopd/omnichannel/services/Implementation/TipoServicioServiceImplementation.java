package com.proyectopd.omnichannel.services.Implementation;

import com.proyectopd.omnichannel.models.TipoServicio;
import com.proyectopd.omnichannel.repositories.TipoServicioRepository;
import com.proyectopd.omnichannel.services.TipoServicioService;

public class TipoServicioServiceImplementation implements TipoServicioService {

    TipoServicioRepository tipoServicioRepository;

    public TipoServicioServiceImplementation() {
    }

    public TipoServicioServiceImplementation(TipoServicioRepository tipoServicioRepository) {
        this.tipoServicioRepository = tipoServicioRepository;
    }

    @Override
    public boolean createTipoServicio(TipoServicio newServicio) {

        boolean created;

        try {
            tipoServicioRepository.save(newServicio);
            created = true;
        } catch (Exception e) {
            created = false;
        }
        return false;
    }
}
