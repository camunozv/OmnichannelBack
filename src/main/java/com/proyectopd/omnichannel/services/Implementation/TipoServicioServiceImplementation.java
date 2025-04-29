package com.proyectopd.omnichannel.services.Implementation;

import com.proyectopd.omnichannel.models.TipoServicio;
import com.proyectopd.omnichannel.repositories.TipoServicioRepository;
import com.proyectopd.omnichannel.services.TipoServicioService;
import org.springframework.stereotype.Service;

@Service
public class TipoServicioServiceImplementation implements TipoServicioService {

    TipoServicioRepository tipoServicioRepository;

    // Comment it for the initialization to begin with the other constructor
    // ohterwise we get null pointer exception, witout any tipoServicioRepository
    // object initialized
    /*public TipoServicioServiceImplementation() {
    }*/

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

        return created;
    }
}
