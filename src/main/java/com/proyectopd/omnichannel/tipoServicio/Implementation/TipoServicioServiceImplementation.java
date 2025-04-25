package com.proyectopd.omnichannel.tipoServicio.Implementation;

import com.proyectopd.omnichannel.tipoServicio.TipoServicio;
import com.proyectopd.omnichannel.tipoServicio.TipoServicioRepository;
import com.proyectopd.omnichannel.tipoServicio.TipoServicioService;

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
